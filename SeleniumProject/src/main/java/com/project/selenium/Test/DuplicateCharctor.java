package com.project.selenium.Test;

import java.util.HashSet;
import java.util.Set;

public class DuplicateCharctor {

    public static void main(String args[]){

        String str="AA BB CC DD";
        str = str.replaceAll("\\s", "");
        Set<Character> characterSet=new HashSet<>();
        StringBuilder result=new StringBuilder();
        for (char c:str.toCharArray()){
            if (characterSet.add(c)){
                result.append(c);
            }
        }
        System.out.println(result);
    }

}



