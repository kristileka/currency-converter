# ECB Currency Converter

This backend rest api project provides apis to do operations with currencies. It is built using a small stack of
technology:

- [Spring Boot](https://spring.io/projects/spring-boot) as a Java framework
  for REST API.
- [Postgresql](https://www.postgresql.org/) as database for storing the currencies into the database, in order to
  provide fast operations with currencies.
- [Docker](https://www.docker.com/) as postgres running image.
- [Spring Docs](https://springdoc.org/) as endpoint documentation tool.
- [OpenCSV](https://github.com/cygri/opencsv) as CSV reader.

## Usage

This application downloads the latest EU currency update using spring cron from [Europian Central Bank](ecb.europa.eu/)
website. It downloads from there a zip containing all history about currencies.
Extract the zip in background,and reads the CSV that is provided.It performs a check with the current currencies stored
into the database and finds any new or missing ones. Then updates the database
and allows use of those data through REST APIs

## Data Insertion

In order to store currencies there was the need to have a different storing then what spring orm provides.
The chunks of data need to be stored fast into the database, so there is added
[CurrencyManualRepository](src/main/java/com/kristileka/eucurrencyconverter/service/db/CurrencyManualRepository.java).
This seperates the list of currencies on chunks of list, then generates the necessary insertion queries and executes
them among the database pool-size. This ensures that the storing will be done in very good performance.

## Documentation

This Application uses SpringDocs, and is set to be configured into the default swagger url, you can access the API
documentation through [Swagger URL]( http://localhost:9000/swagger-ui.html)

## Testing

To ensure that the business logic is correct, It is separated into what is called domain. It stands there separated so
it can be easily tested by mocking the needed services. To test the domain layer is
used [Mockito](https://github.com/mockito/mockito) and [junit](https://github.com/junit-team/junit5).

## Running

To run the app is pretty straight forward. You need to start postgres server which can be done by one of the two ways.

### Docker

There is a [docker-compose.yml](docker-compose.yml) which contains the proper configuration to start a postgres database
with the configuration that the application needs. To start the database run:

```
docker-compose up
```

### Non Docker

You can create any postgres image as long as it contains the following instructions: <br><br>

```
Postgres Port : 5432
Postgres db: ecb-currency
Postgres username: ecb
Postgres password: ecb
```

Then simply start the spring boot application by running it on any IDE or running: 
```
gradlew bootRun
```