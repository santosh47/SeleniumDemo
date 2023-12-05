package com.project.selenium.Test;

import java.io.IOException;

public class Str {
    public static void main(String[] args) throws IOException {

        String a="newspaper";
        a=a.substring(5,7);
        System.out.println(a);
        char b=a.charAt(0);
        System.out.println(b);
        a=a+b;
        System.out.println(a);
    }
}
