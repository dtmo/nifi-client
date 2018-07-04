package com.tibtech.nifi.client;

import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.nifi.web.api.dto.LabelDTO;
import org.apache.nifi.web.api.entity.LabelEntity;

import com.tibtech.nifi.web.api.dto.LabelDTOBuilder;
import com.tibtech.nifi.web.api.entity.LabelEntityBuilder;
import com.tibtech.nifi.web.api.label.GetLabelInvoker;
import com.tibtech.nifi.web.api.label.RemoveLabelInvoker;
import com.tibtech.nifi.web.api.label.UpdateLabelInvoker;

public class Label extends UpdatableComponent<Label, LabelEntity, LabelDTOBuilder>
{
	public Label(final Transport transport, final LabelEntity componentEntity)
	{
		super(transport, componentEntity);
	}

	protected LabelDTO getLabelDTO()
	{
		return getComponentEntity().getComponent();
	}

	public Double getWidth()
	{
		return getLabelDTO().getWidth();
	}

	public Double getHeight()
	{
		return getLabelDTO().getHeight();
	}

	public String getLabel()
	{
		return getLabelDTO().getLabel();
	}

	public String getParentGroupId()
	{
		return getLabelDTO().getParentGroupId();
	}

	public Map<String, String> getStyle()
	{
		return Collections.unmodifiableMap(getLabelDTO().getStyle());
	}

	@Override
	public Label update(final Consumer<LabelDTOBuilder> configurator) throws InvokerException
	{
		final LabelDTOBuilder labelDTOBuilder = LabelDTOBuilder.of(getLabelDTO());

		configurator.accept(labelDTOBuilder);

		setComponentEntity(new UpdateLabelInvoker(getTransport(), getVersion()).setId(getId())
				.setLabelEntity(new LabelEntityBuilder().setComponent(labelDTOBuilder.build()).build()).invoke());

		return this;
	}

	@Override
	public Label refresh() throws InvokerException
	{
		setComponentEntity(new GetLabelInvoker(getTransport(), getVersion()).setId(getId()).invoke());

		return this;
	}

	@Override
	public void delete() throws InvokerException
	{
		new RemoveLabelInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}
}
