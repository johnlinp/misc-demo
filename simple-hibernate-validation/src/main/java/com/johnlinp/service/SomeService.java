package com.johnlinp.service;

import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public interface SomeService {
    String convertToUppercase(@Size(max = 5) String input);
}
