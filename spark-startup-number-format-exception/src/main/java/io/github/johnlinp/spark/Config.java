package io.github.johnlinp.spark;

import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config
{
    @Bean
    public SparkSession spark ()
    {
        return SparkSession.builder()
                           .appName("demo")
                           .master("local[1]")
                           .config("spark.sql.shuffle.partitions", 20)
                           .getOrCreate();
    }
}
