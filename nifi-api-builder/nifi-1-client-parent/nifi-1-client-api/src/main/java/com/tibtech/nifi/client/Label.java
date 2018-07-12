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

/**
 * Label represents a NiFi label to provide documentation to a flow.
 */
public class Label extends UpdatableComponent<Label, LabelEntity, LabelDTOBuilder>
		implements Deletable, Refreshable<Label, LabelDTOBuilder>
{
	/**
	 * Constructs a new instance of Label.
	 * 
	 * @param transport The transport with to communicate with the NiFi server.
	 * @param labelEntity The label entity.
	 */
	public Label(final Transport transport, final LabelEntity labelEntity)
	{
		super(transport, labelEntity);
	}

	/**
	 * Returns the LabelDTO that describes the label.
	 * 
	 * @return The LabelDTO that describes the label.
	 */
	protected LabelDTO getLabelDTO()
	{
		return getComponentEntity().getComponent();
	}

	/**
	 * Returns the width of the label in pixels when at a 1:1 scale.
	 * 
	 * @return The width of the label in pixels when at a 1:1 scale.
	 */
	public Double getWidth()
	{
		return getLabelDTO().getWidth();
	}

	/**
	 * Returns the height of the label in pixels when at a 1:1 scale.
	 * 
	 * @return The height of the label in pixels when at a 1:1 scale.
	 */
	public Double getHeight()
	{
		return getLabelDTO().getHeight();
	}

	/**
	 * Returns the text that appears in the label.
	 * 
	 * @return The text that appears in the label.
	 */
	public String getLabel()
	{
		return getLabelDTO().getLabel();
	}

	/**
	 * Returns the ID of process group containing the component.
	 * 
	 * @return The ID of process group containing the component.
	 */
	public String getParentGroupId()
	{
		return getLabelDTO().getParentGroupId();
	}

	/**
	 * Returns the styles for this label (font-size : 12px, background-color : #eee,
	 * etc).
	 * 
	 * @return The styles for this label (font-size : 12px, background-color : #eee,
	 *         etc).
	 */
	public Map<String, String> getStyles()
	{
		return Collections.unmodifiableMap(getLabelDTO().getStyle());
	}

	@Override
	public Label update(final Consumer<LabelDTOBuilder> configurator) throws InvokerException
	{
		final LabelDTOBuilder labelDTOBuilder = LabelDTOBuilder.of(getLabelDTO());

		configurator.accept(labelDTOBuilder);

		setComponentEntity(new UpdateLabelInvoker(getTransport(), getVersion())
				.setId(getId())
				.setLabelEntity(new LabelEntityBuilder()
						.setComponent(labelDTOBuilder.build())
						.build())
				.invoke());

		return this;
	}

	@Override
	public Label refresh() throws InvokerException
	{
		setComponentEntity(new GetLabelInvoker(getTransport(), getVersion())
				.setId(getId())
				.invoke());

		return this;
	}

	@Override
	public void delete() throws InvokerException
	{
		new RemoveLabelInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}
}
