# Unstoppable Spring Boot Command-line Runner

The application is a command-line tool.

The `main` function will create a Spring bean `Printer`.

In the constructor of `Printer`, it will start a background thread to constantly print logs.

`Printer` implements `Closeable`, so calling `Printer::close()` will stop the background thread.


## Reproduction steps

Running the command:

```
mvn spring-boot:run
```


## Expect results

The command should stop after `main` exits.


## Actual results

The command will continue printing logs after `main` exits.

After pressing ctrl+C, the application will shutdown and finally call `Printer::close()`.

The logs are:

```
09:33:04.293 [main] INFO io.github.johnlinp.demo.Main - start main

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.6.RELEASE)

2020-04-21 09:33:04.687  INFO 11835 --- [           main] io.github.johnlinp.demo.Main             : Starting Main on john with PID 11835 (/Users/johnlinp/coding/misc-demo/unstoppable-spring-boot-command-line-runner/target/classes started by johnlinp in /Users/johnlinp/coding/misc-demo/unstoppable-spring-boot-command-line-runner)
2020-04-21 09:33:04.688  INFO 11835 --- [           main] io.github.johnlinp.demo.Main             : No active profile set, falling back to default profiles: default
2020-04-21 09:33:04.953  INFO 11835 --- [           main] io.github.johnlinp.demo.Printer          : Printer constructor
2020-04-21 09:33:04.963  INFO 11835 --- [       Thread-2] io.github.johnlinp.demo.Printer          : InnerPrinter idx: 0
2020-04-21 09:33:05.004  INFO 11835 --- [           main] io.github.johnlinp.demo.Main             : Started Main in 0.597 seconds (JVM running for 0.907)
2020-04-21 09:33:05.005  INFO 11835 --- [           main] io.github.johnlinp.demo.Main             : run
2020-04-21 09:33:05.006  INFO 11835 --- [           main] io.github.johnlinp.demo.Main             : end main
2020-04-21 09:33:05.969  INFO 11835 --- [       Thread-2] io.github.johnlinp.demo.Printer          : InnerPrinter idx: 1
2020-04-21 09:33:06.974  INFO 11835 --- [       Thread-2] io.github.johnlinp.demo.Printer          : InnerPrinter idx: 2
2020-04-21 09:33:07.980  INFO 11835 --- [       Thread-2] io.github.johnlinp.demo.Printer          : InnerPrinter idx: 3
2020-04-21 09:33:08.985  INFO 11835 --- [       Thread-2] io.github.johnlinp.demo.Printer          : InnerPrinter idx: 4
2020-04-21 09:33:09.986  INFO 11835 --- [       Thread-2] io.github.johnlinp.demo.Printer          : InnerPrinter idx: 5
2020-04-21 09:33:10.989  INFO 11835 --- [       Thread-2] io.github.johnlinp.demo.Printer          : InnerPrinter idx: 6
2020-04-21 09:33:11.995  INFO 11835 --- [       Thread-2] io.github.johnlinp.demo.Printer          : InnerPrinter idx: 7
^C2020-04-21 09:33:12.305  INFO 11835 --- [extShutdownHook] io.github.johnlinp.demo.Printer          : Printer close
```
