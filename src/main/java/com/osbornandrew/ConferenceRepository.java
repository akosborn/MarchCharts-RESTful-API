package com.osbornandrew;

import com.osbornandrew.model.Conference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConferenceRepository extends CrudRepository<Conference, Long> {

    @Override
    List<Conference> findAll();
}
