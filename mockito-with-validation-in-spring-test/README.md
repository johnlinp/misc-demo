# Mockito with Validation in Spring Test

## How to Run

```
$ mvn test
```

## Problem

The test case `refreshUsersCalled2` will fail with the following message:

```
Missing method call for verify(mock) here:
-> at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)

Example of correct verification:
    verify(mock).doSomething()

Also, this error might show up because you verify either of: final/private/equals()/hashCode() methods.
Those methods *cannot* be stubbed/verified.
Mocking methods declared on non-public parent classes is not supported.
```

However, the method it tried to `verify()` is `UserService::refreshUsers()`, which is a public method.

## Attempted to Fix

After some investigation, I found that the problem came from the conflict between `mock()` and `MethodValidationPostProcessor`.

If I remove the `MethodValidationPostProcessor` Spring bean from `TestConfig`, the above issues will be solved. However, the test case `createUserWithInvalidEmail` will fail because the validation is gone.
