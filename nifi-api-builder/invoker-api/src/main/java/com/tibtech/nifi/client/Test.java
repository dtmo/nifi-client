package com.tibtech.nifi.client;

import org.apache.nifi.scheduling.SchedulingStrategy;

import com.tibtech.nifi.dbcp.DBCPConnectionPoolPropertiesBuilder;
import com.tibtech.nifi.web.api.dto.ProcessorConfigDTOBuilder;

public class Test
{
	public void test() throws InvokerException
	{
		ProcessGroup processGroup = null;

		final Processor processor = processGroup.createProcessor().setName("My Processor")
				.setDescription("My processor's description")
				.setConfig(new ProcessorConfigDTOBuilder()
						.setProperties(
								new DBCPConnectionPoolPropertiesBuilder().setDatabaseConnectionUrl("jdbc:blah").build())
						.setSchedulingStrategy(SchedulingStrategy.CRON_DRIVEN.name()).build())
				.commit();

		processor.update().setDescription("A different description").commit();

	}
}
