package com.tibtech.nifi.client;

import javax.ws.rs.client.ClientBuilder;

import org.apache.nifi.scheduling.SchedulingStrategy;
import org.apache.nifi.web.api.dto.PositionDTO;

import com.tibtech.nifi.dbcp.DBCPConnectionPoolPropertiesBuilder;
import com.tibtech.nifi.web.api.dto.ProcessorConfigDTOBuilder;

public class Test
{
	public void test() throws InvokerException
	{
		final Transport transport = new Transport(ClientBuilder.newBuilder().build(),
				"https://localhost:8443/nifi-api");

		final Flow flow = new Flow(transport);

		final ControllerService controllerService = flow.createControllerService(c -> c.setType(""));
		controllerService.enable();
		
		final ProcessGroup myProcessGroup = flow.getRootProcessGroup()
				.createProcessGroup(p -> p.setName("My process group"));
		myProcessGroup.update(p -> p.setPosition(new PositionDTO(100.0, 100.0)));

		final Processor processor = myProcessGroup.createProcessor(p -> p.setName("My processor")
				.setDescription("My processor's description")
				.setConfig(new ProcessorConfigDTOBuilder()
						.setProperties(
								new DBCPConnectionPoolPropertiesBuilder().setDatabaseConnectionUrl("jdbc:blah").build())
						.setSchedulingStrategy(SchedulingStrategy.TIMER_DRIVEN.name()).setSchedulingPeriod("1 sec")
						.build()));

		processor.update(p -> p.setDescription("A different description"));

		processor.refresh();
	}
}
