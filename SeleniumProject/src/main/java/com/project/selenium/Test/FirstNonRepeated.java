package com.project.selenium.Test;

import java.io.IOException;

public class FirstNonRepeated {

    public static void main(String[] args) throws IOException {

        String str = "test";
        int[] a = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            a[c]++;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (a[ch] == 2) {
                System.out.println(ch);

            }
        }

    }
}