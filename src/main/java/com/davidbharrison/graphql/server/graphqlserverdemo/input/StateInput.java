package com.davidbharrison.graphql.server.graphqlserverdemo.input;

import com.davidbharrison.graphql.server.graphqlserverdemo.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class StateInput {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer countryId;
}
