package com.tutorialsninja.automation.test.Streams;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream {



    @Test
    public void streams() {
        List<String> str = Arrays.asList("test", "testing", "apple", "apple");
        str.stream().distinct().forEach(value->System.out.println(value));
       long count= str.stream().distinct().count();
        System.out.println(count);

        int a[]={1,2,3};
        System.out.println("gretest number");
        Arrays.stream(a).filter(n->n>10).forEach(System.out::println);

       List<String> limit= str.stream().limit(2).collect(Collectors.toList());
        System.out.println(limit);

        List<Integer> even=Arrays.asList(1,7,4,2,6,8,22,28);
         even.stream().filter(e->e%2==0).forEach(System.out::println);
        long evennumber= even.stream().filter(e->e%2==0).count();

      System.out.println(evennumber);

        int[] numbers = {5, 9, 11, 2, 8, 21, 1};
        System.out.println(Arrays.toString(numbers));
        int secondLargestNumber = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondLargestNumber);

       Optional<Integer> min= even.stream().min((val1, val2)->{return val1.compareTo(val2);});
        System.out.println(min.get());
        Optional<Integer> max= Arrays.stream(numbers).boxed().max((val1, val2)->{return val1.compareTo(val2);});
        System.out.println(max.get());


    }



}
