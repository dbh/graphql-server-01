# graphql-server-01
A simple graphql serve just for learning purposes

* Initial model is Countries and States

## Database
H2 database is used for a datastore.

**H2 Console**: http://localhost:8080/h2-console

## Data Exposed

Data is exposed by both REST and GraphQL.

### REST
Utilizing the magic of Spring Data, end points and data are automatically accessible via explorer on 
**Endpoint**: http://localhost:8080/

### GraphQL

**Endpoint**: http://localhost:8080/graphql 

**File**: resoures/graphql/**main.graphqls**


Find All Countries
```
query {
    findAllCountries {
        id
        name
    }
}
```

Find A Country by Name
```
query($name: String!) {
    findCountryByName(name: $name) {
        id
        name
    }
}
```

Find all states names their country names
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

Find a specific state, including country info
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