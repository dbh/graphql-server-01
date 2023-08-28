package com.davidbharrison.graphql.server.graphqlserverdemo.resolver;

import com.davidbharrison.graphql.server.graphqlserverdemo.entity.Country;
import com.davidbharrison.graphql.server.graphqlserverdemo.entity.State;
import com.davidbharrison.graphql.server.graphqlserverdemo.input.CountryInput;
import com.davidbharrison.graphql.server.graphqlserverdemo.input.StateInput;
import com.davidbharrison.graphql.server.graphqlserverdemo.repo.CountryRepo;
import com.davidbharrison.graphql.server.graphqlserverdemo.repo.StateRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Log
@Controller
public class StateResolver {
    private StateRepo stateRepo;

    @Autowired
    public StateResolver(StateRepo repo) {
        this.stateRepo = repo;
    }

    @QueryMapping
    public List<State> findStateByName(@Argument String name) {
        return stateRepo.findByName(name);
    }

    @QueryMapping
    public List<State> findAllStates() {
        System.out.println("findAllStates entry point");
        return stateRepo.findAll();
    }

    @MutationMapping(name="saveState")
    public State saveState(@Argument StateInput stateInput) {
        log.info("saveState");
        State state = new State();
        state.setId(stateInput.getId());
        state.setName(stateInput.getName());
        state.setCountryId(stateInput.getCountryId());

        state = stateRepo.save(state);
        return state;
    }

    @Transactional
    @MutationMapping(name="deleteState")
    public Boolean deleteState(@Argument Integer stateId) {
        log.info("deleteState");
        if (!stateRepo.existsById(stateId)) {
            return false;
        }
        stateRepo.deleteById(stateId);
        return true;
    }
}
