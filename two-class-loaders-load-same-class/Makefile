all: /tmp/test/Foo.class Run.class

run: all
	java Run

clean:
	rm -f *.class
	rm -rf /tmp/test

/tmp/test/Foo.class: Foo.java
	javac Foo.java
	mkdir -p /tmp/test
	mv Foo.class /tmp/test

Run.class: Run.java
	javac Run.java
