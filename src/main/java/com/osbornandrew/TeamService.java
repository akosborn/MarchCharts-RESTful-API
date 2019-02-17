package com.osbornandrew;

import com.osbornandrew.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class TeamService {

    private TeamRepository repo;

    @Autowired
    public TeamService(TeamRepository repo) {
        this.repo = repo;
    }

    public Optional<Team> findById(Long id) {
        return repo.findById(id);
    }

    public List<Team> getByConferenceId(Long id) {
        return repo.findAllByConference_Id(id);
    }
}
