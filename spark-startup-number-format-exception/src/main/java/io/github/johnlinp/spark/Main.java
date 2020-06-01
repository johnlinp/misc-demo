package io.github.johnlinp.spark;

import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Main implements CommandLineRunner
{
    private final SparkSession spark;

    @Autowired
    public Main (SparkSession spark)
    {
        this.spark = spark;
    }

    public static void main (String[] args)
    {
        new SpringApplicationBuilder(Main.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Override
    public void run (String... args)
    {
        // using spark
    }
}
