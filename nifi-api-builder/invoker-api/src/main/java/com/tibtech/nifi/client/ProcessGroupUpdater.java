package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.ProcessGroupDTO;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;

import com.tibtech.nifi.web.api.dto.ProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.entity.ProcessGroupEntityBuilder;
import com.tibtech.nifi.web.api.process.groups.UpdateProcessGroupInvoker;

public class ProcessGroupUpdater extends ProcessGroupBuilder<ProcessGroupUpdater>
{
	private final Transport transport;

	private final ProcessGroup processGroupToUpdate;

	public ProcessGroupUpdater(final Transport transport, final ProcessGroup processGroupToUpdate,
			final ProcessGroupDTO processGroupDTO)
	{
		super(ProcessGroupDTOBuilder.of(processGroupDTO));

		this.transport = transport;
		this.processGroupToUpdate = processGroupToUpdate;
	}

	public ProcessGroupUpdater setParentGroupId(String parentGroupId)
	{
		getProcessGroupDTOBuilder().setParentGroupId(parentGroupId);
		return this;
	}

	public void commit() throws InvokerException
	{
		final ProcessGroupDTO processGroupDTO = getProcessGroupDTOBuilder().build();
		final ProcessGroupEntity processGroupEntity = new UpdateProcessGroupInvoker(transport)
				.setId(processGroupDTO.getId())
				.setProcessGroupEntity(new ProcessGroupEntityBuilder().setComponent(processGroupDTO).build()).invoke();

		processGroupToUpdate.setProcessGroupDTO(processGroupEntity.getComponent());
	}
}
