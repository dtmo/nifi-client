package com.tibtech.nifi.web.api.dto;

import java.util.Collection;
import java.util.Date;
import org.apache.nifi.web.api.dto.CounterDTO;
import org.apache.nifi.web.api.dto.CountersSnapshotDTO;

public final class CountersSnapshotDTOBuilder {
  private Collection<CounterDTO> counters;

  private Date generated;

  /**
   * All counters in the NiFi.
   */
  public Collection<CounterDTO> getCounters() {
    return counters;
  }

  /**
   * All counters in the NiFi.
   */
  public CountersSnapshotDTOBuilder setCounters(final Collection<CounterDTO> counters) {
    this.counters = counters;
    return this;
  }

  /**
   * The timestamp when the report was generated.
   */
  public Date getGenerated() {
    return generated;
  }

  /**
   * The timestamp when the report was generated.
   */
  public CountersSnapshotDTOBuilder setGenerated(final Date generated) {
    this.generated = generated;
    return this;
  }

  public CountersSnapshotDTO build() {
    final CountersSnapshotDTO countersSnapshotDTO = new CountersSnapshotDTO();
    countersSnapshotDTO.setCounters(counters);
    countersSnapshotDTO.setGenerated(generated);
    return countersSnapshotDTO;
  }

  public static CountersSnapshotDTOBuilder of(final CountersSnapshotDTO countersSnapshotDTO) {
    final CountersSnapshotDTOBuilder countersSnapshotDTOBuilder = new CountersSnapshotDTOBuilder();
    countersSnapshotDTOBuilder.setCounters(countersSnapshotDTO.getCounters());
    countersSnapshotDTOBuilder.setGenerated(countersSnapshotDTO.getGenerated());
    return countersSnapshotDTOBuilder;
  }
}
