package com.tibtech.nifi.client;

import javax.ws.rs.core.Response.StatusType;

/**
 * InvokerException is thrown when an invoker receives an unsuccessful response.
 */
public class InvokerException extends Exception
{
	/**
	 * Serialized version unique ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The response status that caused the exception to be thrown.
	 */
	private final StatusType statusType;

	/**
	 * Constructs a new instance of InvokerException.
	 *
	 * @param message
	 *            A message explaining why the exception was thrown.
	 * @param cause
	 *            The cause of the exception being thrown.
	 * @param statusType
	 *            The response status that caused the exception to be thrown.
	 */
	public InvokerException(final String message, final Throwable cause, final StatusType statusType)
	{
		super(message, cause);

		this.statusType = statusType;
	}

	/**
	 * Constructs a new instance of InvokerException.
	 *
	 * @param message
	 *            A message explaining why the exception was thrown.
	 * @param statusType
	 *            The response status that caused the exception to be thrown.
	 */
	public InvokerException(final String message, final StatusType statusType)
	{
		this(message, null, statusType);
	}

	/**
	 * Returns the response status that caused the exception to be thrown.
	 *
	 * @return The response status that caused the exception to be thrown.
	 */
	public StatusType getStatusType()
	{
		return statusType;
	}
}
