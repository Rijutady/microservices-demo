# Homework 2
> by  Huiqing Wu (wj8664)

## Run environment 
    Java OpenJDK 8
    Maven 3.6.3

## Maven built by command line
```
mvn package
```

Maven will install dependencies from pom.xml and compile JAR in target/microservices-demo-2.1.0.RELEASE.jar

## Command line to run the code
You may find it easier to view the different applications by running them from a command line since you can place the four windows side-by-side and watch their log output

```sh
java -jar target/microservices-demo-2.1.0.RELEASE.jar registration
java -jar target/microservices-demo-2.1.0.RELEASE.jar accounts
java -jar target/microservices-demo-2.1.0.RELEASE.jar web
java -jar target/microservices-demo-2.1.0.RELEASE.jar posts
```

Each microservices application runs in different ports.

registration - 1111

accounts - 2222

web - 3333

posts - 8888

## API list

/posts - List all posts

/posts/{author_name} - List posts from author