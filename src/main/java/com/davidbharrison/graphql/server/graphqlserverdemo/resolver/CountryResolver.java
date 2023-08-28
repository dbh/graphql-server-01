package com.davidbharrison.graphql.server.graphqlserverdemo.resolver;

import java.util.List;

import com.davidbharrison.graphql.server.graphqlserverdemo.entity.State;
import com.davidbharrison.graphql.server.graphqlserverdemo.input.CountryInput;
import lombok.extern.java.Log;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;

import com.davidbharrison.graphql.server.graphqlserverdemo.repo.CountryRepo;
import com.davidbharrison.graphql.server.graphqlserverdemo.entity.Country;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Log
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


    @MutationMapping(name="saveCountry")
    public Country saveCountry(@Argument CountryInput countryInput) {
        log.info("saveCountry");
        Country country = new Country();
        country.setId(countryInput.getId());
        country.setName(countryInput.getName());

        country = countryRepo.save(country);
        return country;
    }
}
