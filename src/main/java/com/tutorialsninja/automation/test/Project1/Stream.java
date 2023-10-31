package com.tutorialsninja.automation.test.Project1;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stream {


    @Test
    public void stream(){

        List<String> list= Arrays.asList("test", "test2", "apple");
        list.stream().filter(l->l.startsWith("t")).forEach(System.out::println);

       // List to Array

        List<Integer> list1=Arrays.asList(10,20,40);
        Integer[] integers=list1.toArray(new Integer[0]);

       // Array to List


        Integer[] integerArray = {1, 2, 3, 4, 5};

        List<Integer> integerList = Arrays.asList(integerArray);

        Integer[] numbers =  { 1, 2, 3 };
        List<Integer> list2=Arrays.asList(numbers);





    }
}
