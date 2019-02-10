package com.osbornandrew;

import com.osbornandrew.model.Metrics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetricsRepository  extends CrudRepository<Metrics, Long> {

    List<Metrics> findAllByTeamId(Long id);
}
