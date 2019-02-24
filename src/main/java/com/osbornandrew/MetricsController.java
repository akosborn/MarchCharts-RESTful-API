package com.osbornandrew;

import com.osbornandrew.dto.MetricsDifference;
import com.osbornandrew.model.Conference;
import com.osbornandrew.model.Metrics;
import com.osbornandrew.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
        return teamService.findById(teamId).orElse(null);
    }

    @RequestMapping("/conferences")
    public List<Conference> getAllConferences() {
        return confService.getAll();
    }

    @RequestMapping("/conferences/{id}")
    public List<Team> getByConference(@PathVariable("id") Long id) {
        return teamService.getByConferenceId(id);
    }

    @RequestMapping("/metrics/movement")
    public List<MetricsDifference> getChangeByDates(@RequestParam("from") String from,
                                                    @RequestParam("to") String to) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate fromDate = LocalDate.parse(from, formatter);
        LocalDate toDate = LocalDate.parse(to, formatter);
        return metricsService.getChangeByDates(fromDate, toDate);
    }

    @RequestMapping("/metrics/dates")
    public List<LocalDate> getAllDates() {
        return metricsService.getAllDates();
    }
}
