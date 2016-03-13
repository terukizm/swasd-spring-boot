SWASD
===

Simple Web Application or Service Development by Spring Boot


# usage

## develop

```
$ gradle bootRun
```

## production

```
$ gradle bootRun -Pargs="--spring.profiles.active=production"
```

もしくは

```
$ gradle build
$ java -jar build/libs/xxxxx.jar
```

