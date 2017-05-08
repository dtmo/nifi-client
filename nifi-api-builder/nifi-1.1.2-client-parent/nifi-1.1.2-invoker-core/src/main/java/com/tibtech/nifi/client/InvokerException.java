package com.tibtech.nifi.client;

public class InvokerException extends Exception
{
	/**
	 * Serialized version UID.
	 */
	private static final long serialVersionUID = 1L;

	public InvokerException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public InvokerException(String message)
	{
		super(message);
	}
}
