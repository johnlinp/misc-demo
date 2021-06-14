# flyway-two-migrations-running-forever

This is a demo for the bug: <https://github.com/flyway/flyway/issues/3207>


## Reproduction steps

1. Change the url/user/password in `pom.xml`
1. Open 2 terminals and run the Run the command in both terminals:
```
$ mvn flyway:migrate
```

## Expected results

The 2 migrations will run `R__always_run_once.sql` once each and then finish successfully.


## Actual results

The 2 termnials will run `R__always_run_once.sql` repeatedly and never stops:

```
$ mvn flyway:migrate
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------< io.github.johnlinp:test-migration >------------------
[INFO] Building db-migration 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- flyway-maven-plugin:7.9.1:migrate (default-cli) @ test-migration ---
[INFO] Flyway Community Edition 7.9.1 by Redgate
[INFO] Database: jdbc:mysql://127.0.0.1:3306/testdb (MySQL 5.7)
[INFO] Successfully validated 1 migration (execution time 00:00.024s)
[INFO] Creating Schema History table `testdb`.`flyway_schema_history` with baseline ...
[INFO] Successfully baselined schema with version: 1
[INFO] Current version of schema `testdb`: 1
[INFO] Migrating schema `testdb` with repeatable migration "always run once"
[INFO] +-----------+
| SLEEP(20) |
+-----------+
| 0         |
+-----------+

[INFO] Migrating schema `testdb` with repeatable migration "always run once"
[INFO] +-----------+
| SLEEP(20) |
+-----------+
| 0         |
+-----------+

[INFO] Migrating schema `testdb` with repeatable migration "always run once"
[INFO] +-----------+
| SLEEP(20) |
+-----------+
| 0         |
+-----------+
```
