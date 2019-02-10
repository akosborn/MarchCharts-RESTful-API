package com.osbornandrew.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @JsonIgnoreProperties({"teams"})
    @ManyToOne
    @JoinColumn(name = "conference_id")
    @Getter @Setter
    private Conference conference;

    @JsonIgnoreProperties({"metrics", "conference"})
    @OneToMany(mappedBy = "team")
    @Getter @Setter
    private List<Metrics> metrics = new ArrayList<>();
}
