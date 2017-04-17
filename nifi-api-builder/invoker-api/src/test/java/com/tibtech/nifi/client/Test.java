package com.tibtech.nifi.client;

import org.apache.nifi.scheduling.SchedulingStrategy;
import org.apache.nifi.web.api.dto.PositionDTO;

import com.tibtech.nifi.dbcp.DBCPConnectionPoolPropertiesBuilder;
import com.tibtech.nifi.web.api.dto.ProcessorConfigDTOBuilder;

public class Test
{
	@SuppressWarnings("null")
	public void test() throws InvokerException
	{
		ProcessGroup processGroup = null;

		final ProcessGroup myProcessGroup = processGroup.createProcessGroup(p -> p.setName("My process group"));
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
