package com.davidbharrison.graphql.server.graphqlserverdemo.repo;

import com.davidbharrison.graphql.server.graphqlserverdemo.entity.State;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepo extends PagingAndSortingRepository<State, Long> {

    List<State>findByName(@Param("name") String name);

    List<State> findAll();

    State save(State state);

}
