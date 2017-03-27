package com.tibtech.nifi.client.processgroup;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.nifi.web.api.dto.DimensionsDTO;
import org.apache.nifi.web.api.dto.LabelDTO;
import org.apache.nifi.web.api.entity.LabelEntity;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;

public class CreateLabelInvoker extends ComponentEntityInvoker<LabelEntity>
{
	public static final String PROCESS_GROUPS = "process-groups";
	public static final String LABELS = "labels";

	private String groupId;

	private DimensionsDTO dimensions;
	private LabelDTO component;

	public CreateLabelInvoker(final Transport transport)
	{
		super(transport);
	}

	public CreateLabelInvoker groupId(final String groupId)
	{
		this.groupId = groupId;
		return this;
	}

	public CreateLabelInvoker dimensions(final DimensionsDTO dimensions)
	{
		this.dimensions = dimensions;
		return this;
	}

	public CreateLabelInvoker label(final LabelDTO component)
	{
		this.component = component;
		return this;
	}

	@Override
	public LabelEntity invoke() throws InvokerException
	{
		final LabelEntity labelEntity = new LabelEntity();

		setEntityValues(labelEntity);

		labelEntity.setDimensions(dimensions);
		labelEntity.setComponent(component);

		final Entity<LabelEntity> jsonEntity = Entity.json(labelEntity);

		final WebTarget baseWebTarget = getBaseWebTarget();

		final Invocation.Builder invocationBuilder = baseWebTarget.path(PROCESS_GROUPS).path(groupId).path(LABELS)
				.request(MediaType.APPLICATION_JSON);
		final Response response = invocationBuilder.post(jsonEntity);
		try
		{
			return handleComponentEntityResponse(response, LabelEntity.class);
		}
		finally
		{
			response.close();
		}
	}
}
