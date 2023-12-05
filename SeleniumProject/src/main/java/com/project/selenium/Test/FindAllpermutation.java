package com.project.selenium.Test;

public class FindAllpermutation {
    public static void main(String[] args) {
        String str = "abc";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            System.out.println(remaining+""+str+ch);
        }
    }

}
