package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.ProcessGroupDTO;

public class ProcessGroup extends Component
{
	private final ProcessGroupDTO processGroupDTO;
	
	public ProcessGroup(final Transport transport, final ProcessGroupDTO processGroupDTO)
	{
		super(transport, processGroupDTO);
		
		this.processGroupDTO = processGroupDTO;
	}
	
	public ProcessorBuilder createProcessor()
	{
		return new ProcessorCreator(getTransport(), this);
	}
}
