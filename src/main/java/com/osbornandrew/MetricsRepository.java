package com.osbornandrew;

import com.osbornandrew.dto.MetricsDifference;
import com.osbornandrew.model.Metrics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MetricsRepository  extends CrudRepository<Metrics, Long> {

    List<Metrics> findAllByTeamId(Long id);

    @Query(value = "SELECT " +
            "t.id AS teamId, " +
            "t.name AS teamName, " +
            "c.name AS conferenceName, " +
            "CASE WHEN t.bubble = 1 THEN 'true' ELSE 'false' END AS onBubble, " +
            "MAX(CASE WHEN m.date = ?2 THEN m.date END) as date2, " +
            "MAX(CASE WHEN m.date != ?2 THEN m.date END) as date1, " +
            "MAX(CASE WHEN m.date = ?2 THEN net END) AS net2, " +
            "MAX(CASE WHEN m.date != ?2 THEN net END) AS net1, " +
            "(MAX(CASE WHEN m.date = ?2 THEN net END) - MAX(CASE WHEN m.date != ?2 THEN net END)) AS netChange, " +
            "MAX(CASE WHEN m.date = ?2 THEN sos END) AS sos2, " +
            "MAX(CASE WHEN m.date != ?2 THEN sos END) AS sos1, " +
            "(MAX(CASE WHEN m.date = ?2 THEN sos END) - MAX(CASE WHEN m.date != ?2 THEN sos END)) AS sosChange, " +
            "MAX(CASE WHEN m.date = ?2 THEN q1_wins END) AS q1Wins2, " +
            "MAX(CASE WHEN m.date != ?2 THEN q1_wins END) AS q1Wins1, " +
            "(MAX(CASE WHEN m.date = ?2 THEN q1_wins END) - MAX(CASE WHEN m.date != ?2 THEN q1_wins END)) AS q1WinsChange, " +
            "MAX(CASE WHEN m.date = ?2 THEN q2_wins END) AS q2Wins2, " +
            "MAX(CASE WHEN m.date != ?2 THEN q2_wins END) AS q2Wins1, " +
            "(MAX(CASE WHEN m.date = ?2 THEN q2_wins END) - MAX(CASE WHEN m.date != ?2 THEN q2_wins END)) AS q2WinsChange, " +
            "MAX(CASE WHEN m.date = ?2 THEN q3_losses END) AS q3Losses2, " +
            "MAX(CASE WHEN m.date != ?2 THEN q3_losses END) AS q3Losses1, " +
            "(MAX(CASE WHEN m.date = ?2 THEN q3_losses END) - MAX(CASE WHEN m.date != ?2 THEN q3_losses END)) AS Q3LossesChange, " +
            "MAX(CASE WHEN m.date = ?2 THEN q4_losses END) AS q4Losses2, " +
            "MAX(CASE WHEN m.date != ?2 THEN q4_losses END) AS q4Losses1, " +
            "(MAX(CASE WHEN m.date = ?2 THEN q4_losses END) - MAX(CASE WHEN m.date != ?2 THEN q4_losses END)) AS q4LossesChange " +
            "FROM metrics m " +
            "JOIN teams t ON t.id = m.team_id " +
            "JOIN conferences c ON c.id = t.conference_id " +
            "WHERE m.date IN (?1, ?2) " +
            "GROUP BY m.team_id " +
            "ORDER BY team_id", nativeQuery = true)
    List<MetricsDifference> findChangeByDates(LocalDate from, LocalDate to);

    @Query(value = "" +
            "SELECT DISTINCT date " +
            "FROM Metrics " +
            "ORDER BY date desc")
    List<LocalDate> findAllDates();
}
