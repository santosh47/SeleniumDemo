package com.project.selenium.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public void test(){
        String str = "AA BB CC DD";
        Set<Character> set=new HashSet<>();
        String test=str.replaceAll("\\s","");
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            System.out.println(set.add(ch)); ;
        }
        for (char alp:set){
            System.out.println(alp);
        }
    }

    public static void main(String[] args) throws IOException {
        String str="testing";
        String org="";
        for (int i=0;i<str.length();i++){
            for (int j=i+1;j<str.length();j++){
                String sub=str.substring(i,j);
                if (str.substring(j).contains(sub) && sub.length()>org.length()){
                    org=sub;
                    System.out.println(org);

                }
            }

        }

    }
}