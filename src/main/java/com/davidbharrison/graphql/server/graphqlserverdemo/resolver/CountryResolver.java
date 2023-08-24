package com.davidbharrison.graphql.server.graphqlserverdemo.resolver;

import java.util.List;

import com.davidbharrison.graphql.server.graphqlserverdemo.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;

import com.davidbharrison.graphql.server.graphqlserverdemo.repo.CountryRepo;
import com.davidbharrison.graphql.server.graphqlserverdemo.entity.Country;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CountryResolver {
    private CountryRepo countryRepo;

    public CountryResolver(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @QueryMapping
    public List<Country> findCountryByName(@Argument String name) {
        System.out.println("findCountryByName entry point");
        return countryRepo.findByName(name);
    }

    @QueryMapping
    public List<Country> findAllCountries() {
        System.out.println("findAllCountries entry point");
        return countryRepo.findAll();
    }

    @SchemaMapping
    public Country country(State state) {
        return countryRepo.findById(state.getCountryId());
    }
}
