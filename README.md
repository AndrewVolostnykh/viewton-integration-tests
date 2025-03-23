## Viewton Integration tests

This project is a set of integration test for Viewton library.

Integration tests uses `spring-boot-starter-test` and `junit`, also connects H2 DB to a context with
preinstalled data (see [data.sql](./src/test/resources/data.sql)). The database is starting when tests is starting 
and shutting down when tests finished