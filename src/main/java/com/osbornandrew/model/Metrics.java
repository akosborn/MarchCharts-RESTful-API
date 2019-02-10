package com.osbornandrew.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "metrics")
public class Metrics {

    @Id
    @Getter @Setter
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "team_id")
    @Getter @Setter
    private Team team;

    @Getter @Setter
    private LocalDate date;

    @Getter @Setter
    private int NET;

    @Column(name = "avg_opp_net")
    @Getter @Setter
    private int avgOppNET;

    @Getter @Setter
    private int rank;

    @Getter @Setter
    private int wins;

    @Getter @Setter
    private int losses;

    @Getter @Setter
    private int confWins;

    @Getter @Setter
    private int confLosses;

    @Getter @Setter
    private int nonConfWins;

    @Getter @Setter
    private int nonConfLosses;

    @Getter @Setter
    private int roadWins;

    @Getter @Setter
    private int roadLosses;

    @Getter @Setter
    private int SOS;

    @Column(name = "non_conf_sos")
    @Getter @Setter
    private int nonConfSOS;

    @Column(name = "q1_wins")
    @Getter @Setter
    private int q1Wins;

    @Column(name = "q1_losses")
    @Getter @Setter
    private int q1Losses;

    @Column(name = "q2_wins")
    @Getter @Setter
    private int q2Wins;

    @Column(name = "q2_losses")
    @Getter @Setter
    private int q2Losses;

    @Column(name = "q3_wins")
    @Getter @Setter
    private int q3Wins;

    @Column(name = "q3_losses")
    @Getter @Setter
    private int q3Losses;

    @Column(name = "q4_wins")
    @Getter @Setter
    private int q4Wins;

    @Column(name = "q4_losses")
    @Getter @Setter
    private int q4Losses;
}
