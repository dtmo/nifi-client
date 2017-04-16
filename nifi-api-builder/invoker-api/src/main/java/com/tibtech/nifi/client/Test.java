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

		final ProcessGroup myProcessGroup = processGroup.createProcessGroup().setName("My process group").create();
		myProcessGroup.startUpdate().setPosition(new PositionDTO(100.0, 100.0)).commit();

		final Processor processor = myProcessGroup.createProcessor().setName("My processor")
				.setDescription("My processor's description")
				.setConfig(new ProcessorConfigDTOBuilder()
						.setProperties(
								new DBCPConnectionPoolPropertiesBuilder().setDatabaseConnectionUrl("jdbc:blah").build())
						.setSchedulingStrategy(SchedulingStrategy.CRON_DRIVEN.name()).build())
				.create();

		processor.startUpdate().setDescription("A different description").commit();

		processor.refresh();
	}
}
