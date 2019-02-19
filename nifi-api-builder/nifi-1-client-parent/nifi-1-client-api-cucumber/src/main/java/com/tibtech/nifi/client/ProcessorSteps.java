package com.tibtech.nifi.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.tibtech.nifi.processors.standard.GenerateFlowFile;
import com.tibtech.nifi.web.api.dto.ProcessorConfigDTOBuilder;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class ProcessorSteps implements En
{
    public ProcessorSteps(final TestState testState)
    {
        When("a Processor is created", () -> {
            final Controller controller = testState.getController();
            final Processor processor = controller.getRootProcessGroup().createProcessor(0, 0,
                    GenerateFlowFile.COMPONENT_TYPE, builder -> {});
            testState.addCreatedProcessor(processor);
        });

        Then("a Processor exists", () -> {
            final Set<Processor> processors = testState.getController().getRootProcessGroup().getProcessors();
            final Set<Processor> createdProcessors = testState.getCreatedProcessors();

            assertEquals(createdProcessors, processors);
        });

        Given("a Processor has been created", () -> {
            final Controller controller = testState.getController();
            final Processor processor = controller.getRootProcessGroup().createProcessor(0, 0,
                    GenerateFlowFile.COMPONENT_TYPE,
                    processorBuilder -> processorBuilder.setConfig(configBuilder -> configBuilder
                            .setAutoTerminatedRelationships(Collections.singleton("success"))));
            testState.addCreatedProcessor(processor);
        });

        When("a Processor is started", () -> {
            testState.getController().getRootProcessGroup().getProcessors().forEach(processor -> processor.start());
        });

        Then("the Processor starts", () -> {
            testState.getController().getRootProcessGroup().getProcessors().forEach(
                    processor -> assertEquals(ScheduledStates.RUNNING, processor.refresh().getScheduledState()));
        });

        Given("a Processor has been started", () -> {
            final Controller controller = testState.getController();
            final Processor processor = controller.getRootProcessGroup().createProcessor(0, 0,
                    GenerateFlowFile.COMPONENT_TYPE,
                    processorBuilder -> processorBuilder.setConfig(configBuilder -> configBuilder
                            .setAutoTerminatedRelationships(Collections.singleton("success"))));
            testState.addCreatedProcessor(processor);
            processor.start();
        });

        When("the Processor is stopped", () -> {
            testState.getController().getRootProcessGroup().getProcessors().forEach(processor -> processor.stop());
        });

        Then("the Processor stops", () -> {
            testState.getController().getRootProcessGroup().getProcessors().forEach(
                    processor -> assertEquals(ScheduledStates.STOPPED, processor.refresh().getScheduledState()));
        });
    }
}
