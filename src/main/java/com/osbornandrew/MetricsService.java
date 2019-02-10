package com.osbornandrew;

import com.osbornandrew.MetricsRepository;
import com.osbornandrew.model.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricsService {

    private MetricsRepository repo;

    @Autowired
    public MetricsService(MetricsRepository repo) {
        this.repo = repo;
    }

    public List<Metrics> getByTeamId(Long id) {
        return repo.findAllByTeamId(id);
    }
}
