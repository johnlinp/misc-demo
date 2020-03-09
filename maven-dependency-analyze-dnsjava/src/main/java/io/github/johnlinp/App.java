package io.github.johnlinp;

import java.util.HashMap;
import java.util.Map;

import org.apache.jmeter.protocol.http.control.Cookie;

public class App
{
    private Map<String, Object> map = new HashMap<>();

    public App()
    {
        Cookie cookie = new Cookie();
        map.put("update", null);
    }

    public static void main(String[] args)
    {
        System.out.println("Hello World!");
    }
}
