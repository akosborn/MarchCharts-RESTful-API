package com.osbornandrew;

import com.osbornandrew.model.Conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ConferenceService {

    private ConferenceRepository repo;

    @Autowired
    public ConferenceService(ConferenceRepository repo) {
        this.repo = repo;
    }

    List<Conference> getAll() {
        return repo.findAll();
    }
}
