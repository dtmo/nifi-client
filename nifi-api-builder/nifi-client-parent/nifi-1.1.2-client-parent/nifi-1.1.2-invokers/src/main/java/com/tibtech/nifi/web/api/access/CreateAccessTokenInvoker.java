package com.tibtech.nifi.web.api.access;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

/**
 * Creates a token for accessing the REST API via username/password
 */
public final class CreateAccessTokenInvoker extends AbstractInvoker<String> {
  private String username;

  private String password;

  public CreateAccessTokenInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String getUsername() {
    return username;
  }

  public final CreateAccessTokenInvoker setUsername(final String username) {
    this.username = username;
    return this;
  }

  public final String getPassword() {
    return password;
  }

  public final CreateAccessTokenInvoker setPassword(final String password) {
    this.password = password;
    return this;
  }

  public final String invoke() throws InvokerException {
    // /access/token
    WebTarget target = getBaseWebTarget();
    target = target.path("access");
    target = target.path("token");
    final Form form = new Form();
    form.param("username", username);
    form.param("password", password);
    final Entity<Form> entity = Entity.form(form);
    final Invocation.Builder invocationBuilder = target.request("text/plain");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, String.class);
    }
    finally {
      response.close();
    }
  }
}
