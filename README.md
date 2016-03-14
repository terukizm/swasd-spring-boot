swasd-spring-boot
===

Simple Web Application or Service Development by Spring Boot

- implement
  - [x] REST API with RDBMS(MySQL)
  - [x] Validator
  - [x] Exception Handling(return 40x/50x Status)
  - [x] access logging(by Interceptor)
  - [x] API versioning(by URI and HTTP-Header)
  - [x] environments(develop/production)

- development support
  - [x] hot deploy
  - [x] Unittest and Coverage(by Jacoco) sample

- TODO:
  - [ ] login / auth  (use Spring-Security?)
  - [ ] generate access token
  - [ ] service-layer test(use HSQLDB?)

# usage

## develop

```
$ gradle bootRun
```

## production

```
$ gradle bootRun -Pargs="--spring.profiles.active=production"
```

or

```
$ gradle build
$ java -jar build/libs/xxxxx.jar
```

# coverage

```
$ grade jacoco
```

@see
* reports/
* test-results/
* jacoco/
