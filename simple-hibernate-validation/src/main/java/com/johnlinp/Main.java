package com.johnlinp;

import java.util.Set;
import javax.validation.ValidationException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnlinp.service.SomeService;

public final class Main {
    public static void main(final String... args) {
        final AbstractApplicationContext context =
            new ClassPathXmlApplicationContext("classpath:META-INF/spring/*-context.xml");

        context.registerShutdownHook();

        final SomeService service = context.getBean(SomeService.class);

        System.out.println("Start running SomeService...");
        for (String arg : args) {
            try {
                System.out.println("Convert '" + arg + "' to uppercase:");
                System.out.println(service.convertToUppercase(arg));
            } catch (ValidationException e) {
                System.out.println("ValidationException!");
            }
        }
    }
}
