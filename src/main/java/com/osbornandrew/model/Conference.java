package com.osbornandrew.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "conferences")
public class Conference {

    @Id
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @JsonIgnoreProperties({"conference", "metrics"})
    @OneToMany(mappedBy = "conference")
    @Getter @Setter
    private List<Team> teams;
}
