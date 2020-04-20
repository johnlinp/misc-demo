package io.github.johnlinp.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Main implements CommandLineRunner
{
    private static final Logger logger = LogManager.getLogger();

    private final Printer printer;

    @Autowired
    public Main (Printer printer)
    {
        this.printer = printer;
    }

    public static void main (String[] args)
    {
        logger.info("start main");
        new SpringApplicationBuilder(Main.class)
                .web(WebApplicationType.NONE)
                .run(args);
        logger.info("end main");
    }

    @Override
    public void run (String... args)
    {
        logger.info("run");
    }
}
