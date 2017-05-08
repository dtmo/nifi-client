package com.tibtech.nifi.apibuilder

import java.nio.file.Path
import java.nio.file.Paths

import org.apache.nifi.web.api.dto.DocumentedTypeDTO
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO

import com.squareup.javapoet.JavaFile
import com.tibtech.nifi.client.Flow

def flow = Flow.connect "http://localhost:8080/nifi-api"

def root = flow.rootProcessGroup

def outputPath = Paths.get("../../nifi-1.1.2-client-parent/nifi-1.1.2-component-properties-builders/src/main/java/")
def packageNameMapper = {String s -> s.replaceFirst("org\\.apache", "com.tibtech")}

def writeComponentPropertiesBuilder(Flow flow, Closure packageNameMapper, Closure propertyDescriptorsProducer, Path outputPath, DocumentedTypeDTO docmentedTypeDTO)
{
	String componentTypeName = docmentedTypeDTO.getType()
	def packageName = packageNameMapper(componentTypeName.substring(0, componentTypeName.lastIndexOf(".")))
	def classname = componentTypeName.substring(componentTypeName.lastIndexOf(".") + 1)
	def builder = new ConfigurableComponentPropertiesBuilderTypeSpecBuilder(packageName, classname)
	
	builder.componentType = componentTypeName;

	for (PropertyDescriptorDTO d : propertyDescriptorsProducer())
	{
		builder.addConfigurableComponentProperty(new ConfigurableComponentProperty(d.name, d.description))
	}

	def typeSpec = builder.build()
	def javaFile = JavaFile.builder(packageName, typeSpec).build()

	javaFile.writeTo(outputPath)
}

println "Controller service types:"
for (def controllerServiceType : flow.controllerServiceTypes)
{
	println "\t" + controllerServiceType.type
	def propertyDescriptorsProducer =
	{
		def controllerService = flow.createControllerService {type = controllerServiceType.getType()}
		def propertyDescriptors = controllerService.descriptors.values()
		controllerService.delete()
		propertyDescriptors
	}

	writeComponentPropertiesBuilder(flow, packageNameMapper, propertyDescriptorsProducer, outputPath, controllerServiceType)
}

println "\nProcessor types: "
for (def processorType : flow.processorTypes)
{
	println "\t" + processorType.getType()
	def propertyDescriptorsProducer =
	{
		def processor = root.createProcessor {type = processorType.type}
		def propertyDescriptors = processor.config.descriptors.values()
		processor.delete()
		propertyDescriptors
	}

	writeComponentPropertiesBuilder(flow, packageNameMapper, propertyDescriptorsProducer, outputPath, processorType)
}

println "\nReporting Task types: "
for (def reportingTaskType : flow.reportingTaskTypes)
{
	println "\t" + reportingTaskType.type
	def propertyDescriptorsProducer =
	{
		def reportingTask = flow.createReportingTask {type = reportingTaskType.type}
		def propertyDescriptors = reportingTask.descriptors.values()
		reportingTask.delete()
		propertyDescriptors
	}

	writeComponentPropertiesBuilder(flow, packageNameMapper, propertyDescriptorsProducer, outputPath, reportingTaskType)
}
