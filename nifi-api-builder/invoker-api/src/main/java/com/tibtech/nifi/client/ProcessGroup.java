package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.ProcessGroupDTO;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;

import com.tibtech.nifi.web.api.process.groups.GetProcessGroupInvoker;
import com.tibtech.nifi.web.api.process.groups.RemoveProcessGroupInvoker;

public class ProcessGroup extends Component
{
	private ProcessGroupDTO processGroupDTO;

	public ProcessGroup(final Transport transport, final ProcessGroupDTO processGroupDTO)
	{
		super(transport, processGroupDTO);

		this.processGroupDTO = processGroupDTO;
	}

	public ProcessorCreator createProcessor()
	{
		return new ProcessorCreator(getTransport(), this);
	}

	public ProcessGroupCreator createProcessGroup()
	{
		return new ProcessGroupCreator(getTransport(), this);
	}

	public ProcessGroupUpdater startUpdate()
	{
		return new ProcessGroupUpdater(getTransport(), this, processGroupDTO);
	}

	protected void setProcessGroupDTO(final ProcessGroupDTO processGroupDTO)
	{
		this.processGroupDTO = processGroupDTO;
	}

	public void refresh() throws InvokerException
	{
		final ProcessGroupEntity processGroupEntity = new GetProcessGroupInvoker(getTransport()).setId(getId())
				.invoke();
		this.processGroupDTO = processGroupEntity.getComponent();
	}

	public void delete() throws InvokerException
	{
		new RemoveProcessGroupInvoker(getTransport()).setId(getId()).invoke();
	}
}
