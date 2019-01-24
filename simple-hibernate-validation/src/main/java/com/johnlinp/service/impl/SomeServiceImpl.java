package com.johnlinp;

import org.springframework.stereotype.Service;

import com.johnlinp.service.SomeService;


@Service
public class SomeServiceImpl implements SomeService {
    public String convertToUppercase(String input) {
        return input.toUpperCase();
    }
}
