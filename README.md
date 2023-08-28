# graphql-server-01
A simple graphql server just for learning purposes

* Initial model is Countries and States
* Maximum magic is permitted

## Database
H2 database is used for a datastore.

Initial schema and data are populated, if the spring.sql.init.mode=always

see schema.sql and data.sql for more info.

**H2 Console**: http://localhost:8080/h2-console

## Data Exposed

Data is exposed by both REST and GraphQL.

### REST
Utilizing the magic of Spring Data, end points and data are automatically accessible via explorer on 
**Endpoint**: http://localhost:8080/

This is helpful in seeing what is in the database, before GraphQL Operations defined.

### GraphQL

**Endpoint**: http://localhost:8080/graphql 

**File**: resoures/graphql/**main.graphqls**


#### Find All Countries
```
query {
    findAllCountries {
        id
        name
    }
}
```

#### Find A Country by Name
```
query($name: String!) {
    findCountryByName(name: $name) {
        id
        name
    }
}
```

#### Update a Country

variables
```json
{
    "data": {
        "id": 1,
        "name": "United States of America"
    }
}
```

mutation
```
mutation($data: CountryInput){
    saveCountry(countryInput: $data)
    {id, name}
}
```


#### Find all states names their country names
```
query {
    findAllStates {
        name
        country {
            name
        }
    }
}
```

#### Find a specific state, including country info
variables
```json
{
    "name": "Arizona"
}
```

Query
```
query($name: String!) {
    findStateByName(name: $name) {
        id
        name
        country {
            id
            name
        }
    }
}
```

#### update a state

Here, we'll update a state's name

Variables
```
{
    "data": {
        "name": "confusion",
        "countryId": 1
    }
}
```

Mutation
```
mutation($data: StateInput){
    saveState(stateInput: $data)
    {id, name}
}
```

#### delete a state
```
mutation{
    deleteState(stateId: 2)
}
```