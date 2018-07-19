package com.tibtech.nifi.apibuilder

import java.nio.file.Path
import java.nio.file.Paths

import org.apache.nifi.web.api.dto.DocumentedTypeDTO
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO

import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec
import com.tibtech.nifi.client.ControllerService
import com.tibtech.nifi.client.Controller
import com.tibtech.nifi.client.ProcessGroup
import com.tibtech.nifi.client.Processor
import com.tibtech.nifi.client.ReportingTask

Controller flow = Controller.connect "http://localhost:8080/"

ProcessGroup root = flow.rootProcessGroup

Path outputPath = Paths.get("../../nifi-1-client-parent/nifi-1.7.0-component-properties-builders/src/main/java/")
def packageNameMapper = {String s -> s.replaceFirst("org\\.apache", "com.tibtech")}

def writeComponentPropertiesBuilder(Controller flow, Closure packageNameMapper, Closure propertyDescriptorsProducer, Path outputPath, DocumentedTypeDTO docmentedTypeDTO) {
	String componentTypeName = docmentedTypeDTO.getType()
	String packageName = packageNameMapper(componentTypeName.substring(0, componentTypeName.lastIndexOf(".")))
	String classname = componentTypeName.substring(componentTypeName.lastIndexOf(".") + 1)
	ConfigurableComponentPropertiesBuilderTypeSpecBuilder builder = new ConfigurableComponentPropertiesBuilderTypeSpecBuilder(packageName, classname)

	builder.componentType = componentTypeName;

	for (PropertyDescriptorDTO d : propertyDescriptorsProducer()) {
		builder.addConfigurableComponentProperty(new ConfigurableComponentProperty(d.name, d.description))
	}

	TypeSpec typeSpec = builder.build()
	JavaFile javaFile = JavaFile.builder(packageName, typeSpec).build()

	javaFile.writeTo(outputPath)
}

println "Controller service types:"
for (DocumentedTypeDTO controllerServiceType : flow.controllerServiceTypeDTOs) {
	println "\t" + controllerServiceType.type
	def propertyDescriptorsProducer = {
		ControllerService controllerService = flow.createControllerService controllerServiceType.getType(), {}
		Collection<PropertyDescriptorDTO> propertyDescriptors = controllerService.descriptors.values()
		controllerService.delete()
		propertyDescriptors
	}

	writeComponentPropertiesBuilder(flow, packageNameMapper, propertyDescriptorsProducer, outputPath, controllerServiceType)
}

println "\nProcessor types: "
for (DocumentedTypeDTO processorType : flow.processorTypeDTOs) {
	println "\t" + processorType.getType()
	def propertyDescriptorsProducer = {
		Processor processor = root.createProcessor 0, 0, processorType.type, {}
		Collection<PropertyDescriptorDTO> propertyDescriptors = processor.config.descriptors.values()
		processor.delete()
		propertyDescriptors
	}

	writeComponentPropertiesBuilder(flow, packageNameMapper, propertyDescriptorsProducer, outputPath, processorType)
}

println "\nReporting Task types: "
for (DocumentedTypeDTO reportingTaskType : flow.reportingTaskTypeDTOs) {
	println "\t" + reportingTaskType.type
	def propertyDescriptorsProducer = {
		ReportingTask reportingTask = flow.createReportingTask reportingTaskType.type, {}
		Collection<PropertyDescriptorDTO> propertyDescriptors = reportingTask.descriptors.values()
		reportingTask.delete()
		propertyDescriptors
	}

	writeComponentPropertiesBuilder(flow, packageNameMapper, propertyDescriptorsProducer, outputPath, reportingTaskType)
}
