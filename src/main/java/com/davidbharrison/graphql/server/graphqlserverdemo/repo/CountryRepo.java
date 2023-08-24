package com.davidbharrison.graphql.server.graphqlserverdemo.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.davidbharrison.graphql.server.graphqlserverdemo.entity.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepo extends PagingAndSortingRepository<Country, Long> {

    List<Country>findByName(@Param("name") String name);

    List<Country> findAll();
}
