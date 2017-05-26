package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ScheduleComponentsEntity;

public final class ScheduleComponentsInvoker extends AbstractInvoker<ScheduleComponentsEntity> {
  private String id;

  private ScheduleComponentsEntity scheduleComponentsEntity;

  public ScheduleComponentsInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final ScheduleComponentsInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The request to schedule or unschedule. If the comopnents in the request are not specified, all authorized components will be considered. */
  public final ScheduleComponentsEntity getScheduleComponentsEntity() {
    return scheduleComponentsEntity;
  }

  /**
   * The request to schedule or unschedule. If the comopnents in the request are not specified, all authorized components will be considered. */
  public final ScheduleComponentsInvoker setScheduleComponentsEntity(final ScheduleComponentsEntity scheduleComponentsEntity) {
    this.scheduleComponentsEntity = scheduleComponentsEntity;
    return this;
  }

  public final ScheduleComponentsEntity invoke() throws InvokerException {
    // /flow/process-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("process-groups");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<ScheduleComponentsEntity> entity = Entity.entity(scheduleComponentsEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleResponse(response, ScheduleComponentsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
