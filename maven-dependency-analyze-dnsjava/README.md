# Maven dependency analyze bug for dnsjava

## Reproduction steps:

1. Run `mvn dependency:analyze`.
1. Observe the output.

## Expected results:

See the message "No dependency problems found".

## Actual results:

Saw the message:

```
[WARNING] Used undeclared dependencies found:
[WARNING]    dnsjava:dnsjava:jar:2.1.9:runtime
```
