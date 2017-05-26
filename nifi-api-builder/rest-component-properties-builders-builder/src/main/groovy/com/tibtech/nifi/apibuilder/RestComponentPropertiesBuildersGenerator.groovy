package com.tibtech.nifi.apibuilder

//@Grapes([
//	@Grab("org.glassfish.jersey.core:jersey-client:2.25.1"),
//	@Grab("org.glassfish.jersey.media:jersey-media-json-jackson:2.25.1"),
//	@Grab("org.glassfish.jersey.media:jersey-media-multipart:2.25.1"),
//	@Grab("javax.ws.rs:javax.ws.rs-api:2.0.1"),
//	@Grab("org.apache.nifi:nifi-client-dto:1.1.2"),
//	@Grab("com.squareup:javapoet:1.8.0"),
//])
import java.nio.file.Path
import java.nio.file.Paths

import org.apache.nifi.web.api.dto.DocumentedTypeDTO
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO

import com.squareup.javapoet.JavaFile
import com.tibtech.nifi.apibuilder.ConfigurableComponentPropertiesBuilderTypeSpecBuilder
import com.tibtech.nifi.apibuilder.ConfigurableComponentProperty
import com.tibtech.nifi.client.Flow

def flow = Flow.connect "http://localhost:8080/nifi-api"

def root = flow.rootProcessGroup

def outputPath = Paths.get("../nifi-client-parent/component-properties-builders/src/main/java/")
def packageNameMapper = {String s -> s.replaceFirst("org\\.apache", "com.tibtech")}

def writeComponentPropertiesBuilder(Flow flow, Closure packageNameMapper, Closure propertyDescriptorsProducer, Path outputPath, DocumentedTypeDTO docmentedTypeDTO)
{
	String componentTypeName = docmentedTypeDTO.getType()
	def packageName = packageNameMapper(componentTypeName.substring(0, componentTypeName.lastIndexOf(".")))
	def classname = componentTypeName.substring(componentTypeName.lastIndexOf(".") + 1)
	def builder = new ConfigurableComponentPropertiesBuilderTypeSpecBuilder(packageName, classname)

	for (PropertyDescriptorDTO d : propertyDescriptorsProducer())
	{
		builder.addConfigurableComponentProperty(new ConfigurableComponentProperty(d.getName(), d.getDescription()))
	}

	def typeSpec = builder.build()
	def javaFile = JavaFile.builder(packageName, typeSpec).build()

	javaFile.writeTo(outputPath)
}

println "Controller service types:"
def controllerServiceTypes = flow.getControllerServiceTypes()
for (def controllerServiceType : controllerServiceTypes)
{
	def propertyDescriptorsProducer =
	{
		def controllerService = flow.createControllerService {type = controllerServiceType.getType()}
		def propertyDescriptors = controllerService.getDescriptors().values()
		controllerService.remove()
		propertyDescriptors
	}

	writeComponentPropertiesBuilder(flow, packageNameMapper, propertyDescriptorsProducer, outputPath, controllerServiceType)
}

println "Processor types: "
def processorTypes = flow.getProcessorTypes()
for (def processorType : processorTypes)
{
	def propertyDescriptorsProducer =
	{
		def processor = root.createProcessor {type = processorType.getType()}
		def propertyDescriptors = processor.getConfig().getDescriptors().values()
		processor.delete()
		propertyDescriptors
	}

	writeComponentPropertiesBuilder(flow, packageNameMapper, propertyDescriptorsProducer, outputPath, processorType)
}
