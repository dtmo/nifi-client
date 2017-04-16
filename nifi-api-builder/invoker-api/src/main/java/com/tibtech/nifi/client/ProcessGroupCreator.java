package com.tibtech.nifi.client;

import org.apache.nifi.web.api.entity.ProcessGroupEntity;

import com.tibtech.nifi.web.api.dto.ProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.entity.ProcessGroupEntityBuilder;
import com.tibtech.nifi.web.api.process.groups.CreateProcessGroupInvoker;

public class ProcessGroupCreator extends ProcessGroupBuilder<ProcessGroupCreator>
{
	private final Transport transport;

	private final ProcessGroup parentProcessGroup;

	public ProcessGroupCreator(final Transport transport, final ProcessGroup parentProcessGroup)
	{
		super(new ProcessGroupDTOBuilder());

		this.transport = transport;
		this.parentProcessGroup = parentProcessGroup;
	}

	public ProcessGroup create() throws InvokerException
	{
		final ProcessGroupEntity processGroupEntity = new CreateProcessGroupInvoker(transport)
				.setId(parentProcessGroup.getId())
				.setProcessGroupEntity(new ProcessGroupEntityBuilder()
						.setComponent(getProcessGroupDTOBuilder().setParentGroupId(parentProcessGroup.getId()).build())
						.build())
				.invoke();

		return new ProcessGroup(transport, processGroupEntity.getComponent());
	}
}
