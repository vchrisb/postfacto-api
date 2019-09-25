# Postfacto API Binding

## Build

```
mvn clean install
```

## Configure
`pom.xml`
```
<dependency>
    <groupId>net.banck</groupId>
    <artifactId>postfactoApi</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```
`application.properties`
```
postfacto.token=${POSTFACTO_TOKEN}
postfacto.url=${POSTFACTO_URL}
postfacto.team=${POSTFACTO_TEAM}
```
