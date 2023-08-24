# graphql-server-01
A simple graphql serve just for learning purposes

* Initial model is Countries and States

## Data Exposed

Data is exposed by both REST and GraphQL.

### REST
Utilizing the magic of Spring Data, end points and data are automatically accessible via explorer on 
**Endpoint**: http://localhost:8080/

### GraphQL

**Endpoint**: http://localhost:8080/graphql 

**File**: resoures/graphql/**main.graphqls**

## Database
H2 database is used for a datastore. 

**H2 Console**: http://localhost:8080/h2-console

