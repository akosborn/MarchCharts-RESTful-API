package com.osbornandrew;

import com.osbornandrew.model.Conference;
import com.osbornandrew.model.Metrics;
import com.osbornandrew.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class MetricsController {

    private MetricsService metricsService;
    private TeamService teamService;
    private ConferenceService confService;

    @Autowired
    public MetricsController(MetricsService metricsService, TeamService teamService, ConferenceService confService) {
        this.metricsService = metricsService;
        this.teamService = teamService;
        this.confService = confService;
    }

    @RequestMapping("/teams/{id}")
    public Team getByTeam(@PathVariable("id") Long teamId) {
        Team team = teamService.findById(teamId).orElse(null);
        return team;
    }

    @RequestMapping("/conferences")
    public List<Conference> getAllConferences() {
        return confService.getAll();
    }

    @RequestMapping("/conferences/{id}")
    public List<Team> getByConference(@PathVariable("id") Long id) {
        return teamService.getByConferenceId(id);
    }
}
