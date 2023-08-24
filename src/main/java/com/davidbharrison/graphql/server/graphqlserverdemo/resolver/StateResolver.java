package com.davidbharrison.graphql.server.graphqlserverdemo.resolver;

import com.davidbharrison.graphql.server.graphqlserverdemo.entity.Country;
import com.davidbharrison.graphql.server.graphqlserverdemo.entity.State;
import com.davidbharrison.graphql.server.graphqlserverdemo.repo.CountryRepo;
import com.davidbharrison.graphql.server.graphqlserverdemo.repo.StateRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StateResolver {
    private StateRepo stateRepo;

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
}
