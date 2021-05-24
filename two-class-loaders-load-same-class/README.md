# Two `ClassLoader`s load the same class file

This test is to demonstrate that a class file will be treated as different classes if it gets loaded by 2 `ClassLoader`s.


## Usage

```
$ make run
```


## Sample Output

```
===================================
class1: class Foo
class2: class Foo
===================================
calling print() on object1:
Foo::print() called
calling print() on object2:
Foo::print() called
===================================
class1 == class2: false
class1.equals(class2): false
class1.isAssignableFrom(class2): false
```
