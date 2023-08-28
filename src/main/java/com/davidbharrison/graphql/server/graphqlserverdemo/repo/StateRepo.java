package com.davidbharrison.graphql.server.graphqlserverdemo.repo;

import com.davidbharrison.graphql.server.graphqlserverdemo.entity.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepo extends PagingAndSortingRepository<State, Long> {

    List<State>findByName(@Param("name") String name);

    List<State> findAll();

    State save(State state);

    void deleteById(Integer id);

    boolean existsById(Integer id);
    Optional<State> findById(Integer id);

}
