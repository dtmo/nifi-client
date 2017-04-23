#!/usr/bin/env groovy

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
import com.tibtech.nifi.client.Flow

def flow = Flow.connect "http://localhost:8080/nifi-api"

def root = flow.rootProcessGroup

def outputPath = Paths.get("../nifi-client-parent/nifi-component-properties-builders/src/main/java/")
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
	println "\t" + controllerServiceType.getType()
	def propertyDescriptorsProducer =
	{
		def controllerService = flow.createControllerService {type = controllerServiceType.getType()}
		def propertyDescriptors = controllerService.getDescriptors().values()
		controllerService.delete()
		propertyDescriptors
	}

	writeComponentPropertiesBuilder(flow, packageNameMapper, propertyDescriptorsProducer, outputPath, controllerServiceType)
}

println "\nProcessor types: "
def processorTypes = flow.getProcessorTypes()
for (def processorType : processorTypes)
{
	println "\t" + processorType.getType()
	def propertyDescriptorsProducer =
	{
		def processor = root.createProcessor {type = processorType.getType()}
		def propertyDescriptors = processor.getConfig().getDescriptors().values()
		processor.delete()
		propertyDescriptors
	}

	writeComponentPropertiesBuilder(flow, packageNameMapper, propertyDescriptorsProducer, outputPath, processorType)
}

println "\nReporting Task types: "
def reportingTaskTypes = flow.getReportingTaskTypes()
for (def reportingTaskType : reportingTaskTypes)
{
	println "\t" + reportingTaskType.getType()
	def propertyDescriptorsProducer =
	{
		def reportingTask = flow.createReportingTask {type = reportingTaskType.getType()}
		def propertyDescriptors = reportingTask.getDescriptors().values()
		reportingTask.delete()
		propertyDescriptors
	}

	writeComponentPropertiesBuilder(flow, packageNameMapper, propertyDescriptorsProducer, outputPath, reportingTaskType)
}
