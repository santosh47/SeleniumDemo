package com.project.selenium.Test;

public class StringPattern {
    public class StringOutput {
        public static void main(String[] args) {
            String s = "asdf";

            for (int i = 0; i < s.length(); i++) {
                System.out.println(s.substring(0, i + 1));
            }
        }
    }

}
