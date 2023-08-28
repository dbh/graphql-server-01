package com.davidbharrison.graphql.server.graphqlserverdemo.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CountryInput implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
}
