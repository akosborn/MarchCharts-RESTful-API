package com.osbornandrew.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonPropertyOrder({"id", "name", "conference", "onBubble", "metrics"})
@Table(name = "teams")
public class Team {

    @Id
    private Long id;

    private String name;

    @JsonIgnoreProperties({"teams"})
    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference;

    @Column(name = "bubble", nullable = false)
    private boolean isOnBubble;

    @JsonIgnoreProperties({"metrics", "conference"})
    @OneToMany(mappedBy = "team")
    private List<Metrics> metrics = new ArrayList<>();
}
