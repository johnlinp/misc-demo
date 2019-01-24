# Simple Hibernate Validation

This is a demo for <https://github.com/spring-projects/spring-framework/issues/22296>.

`SomeService.convertToUppercase()` will convert strings to uppercase.
But it only accept strings with maximum length of 5.

## Build

Please run:

```
$ mvn package
```


## Run

Please run:

```
$ mvn exec:java -Dexec.args="apple banana"
```

It will output something like:

```
Start running SomeService...
Convert 'apple' to uppercase:
APPLE
Convert 'banana' to uppercase:
ValidationException!
```

## Analyze

Running:

```
$ mvn dependency:analyze
```

will output:

```
[WARNING] Unused declared dependencies found:
[WARNING]    org.hibernate:hibernate-validator:jar:4.2.0.Final:runtime
```

But if you remove the dependency of `hibernate-validator` in the `pom.xml`, it will break at runtime:

```
[ERROR] Failed to execute goal org.codehaus.mojo:exec-maven-plugin:1.2:java (default-cli) on project simple-hibernate-validation: An exception occured while executing the Java class. null: InvocationTargetException: Error creating bean with name 'org.springframework.validation.beanvalidation.MethodValidationPostProcessor#0' defined in file [/Users/johnlinp/coding/misc-demo/simple-hibernate-validation/target/classes/META-INF/spring/application-context.xml]: Invocation of init method failed; nested exception is java.lang.NoClassDefFoundError: org/hibernate/validator/method/MethodConstraintViolationException: org.hibernate.validator.method.MethodConstraintViolationException -> [Help 1]
```
