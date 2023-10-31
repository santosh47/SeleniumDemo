package com.tutorialsninja.automation.test;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.*;
import java.util.stream.Collectors;

public class javapractice {



    @Test
    public void test()
    {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        List<WebElement> listd=driver.findElements(By.xpath("//div[@id='nav-xshop']//a"));

        for(WebElement element:listd)
        {
            String ele=element.getText();
            System.out.println(ele);
        }


    }

    @Test
    public static void prime() {


        int prime[] = {1, 2, 3};

        List<Integer> list = Arrays.asList(1, 5, 46, 8);
        List<Integer> number = list.stream().filter(javapractice::primeNumber).collect(Collectors.toList());
        System.out.println(number);
    }

    public static boolean primeNumber(int number) {

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }

        }
        return true;
    }

    @Test

    public void reverseString() {
        String originalString = "GadaG";
        String reverse = "";
        for (int i = originalString.length() - 1; i >= 0; i--) {
            System.out.println(originalString.charAt(i));
            reverse = reverse + originalString.charAt(i);
        }
        if (reverse.equalsIgnoreCase(originalString)) {

            System.out.println("originalString");
        } else
            System.out.println("Not originalString");
    }


    @Test
    public void alphaNumeric() {

        String originalString = "dhjj&6";


        StringBuffer alpha = new StringBuffer(), numeric = new StringBuffer(), special = new StringBuffer();
        for (int i = 0; i < originalString.length(); i++) {
            if (Character.isAlphabetic(originalString.charAt(i)))
                alpha.append(originalString.charAt(i));

            else if (Character.isDigit(originalString.charAt(i)))
                numeric.append(originalString.charAt(i));
            else
                special.append(originalString.charAt(i));
        }

        System.out.println(alpha);
        System.out.println(numeric);
        System.out.println(special);
    }

    @Test
    public void duplicate() {
        List<Integer> list = Arrays.asList(1, 2, 1, 4, 4, 5);
        Set<Integer> set = new HashSet<>();
        Set<Integer> dup = new HashSet<>();
        for (Integer str : list) {

            if (!set.add(str))
                dup.add(str);

        }

        System.out.println(dup);
    }

    @Test
    public void swap() {
        int x = 10, y = 6;
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println(x + "" + y);

        int temp;
        temp = x;
        x = y;
        y = temp;
        System.out.println(x + "" + y);
    }


    @Test
    public void fib() {

        int n = 5;
        int a = 0, b = 1, c = 1;
        for (int i = 1; i <= n; i++) {

            System.out.print(a + ",");
            a = b;
            b = c;
            c = a + b;
        }
    }


    @Test
    public void palindrom() {

        int n = 121;
        int temp = n;
        int sum = 0;

        while (n != 0) {
            int rem = n % 10;
            sum = sum * 10 + rem;

            n = n / 10;

        }
        if (temp == sum)
            System.out.println("palindrome");
    }

    @Test
    public void stringCount() {

        String str = "test test santosh santosh";

        String word[] = str.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String count : word) {
            if (map.containsKey(word)) {
                map.put(count, map.get(count) + 1);
            } else
                map.put(count, 1);
        }
        System.out.println(map);
    }


    @Test
public void substring(){

        String str="AA BB CC DD";
        int index=str.indexOf("DD");
        if(index!=0)
        {
            String extractedString=str.substring(index);
            System.out.println(extractedString);
        }
        else
            System.out.println("String Not found");
}


@Test
public  void duplicateElement(){

    int[] array = new int[]{2, 4, 7, 2, 11, 5, 7, 14, 22, 11, 49, 58, 14, 101, 1, 3, 205, 49, 101, 12};

    for (int i = 0; i < array.length; i++) { // outer loop
        for (int j = i + 1; j < array.length; j++) { // inner loop
            if (i != j && array[i] == array[j]) {
                System.out.println("Duplicate element found:" + array[i]);
            }
        }
    }
}

@Test
public void secodMaximumNumber(){

        int max[]={10,4,7,8,9};
        int size=max.length;
       int a= Arrays.stream(max).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
    System.out.println(a);


    for(int i=0;i<size;i++) {
        for (int j = i + 1; j < size; j++) {
            if (max[i] > max[j]) {
                int temp;
                temp = max[i];
                max[i] = max[j];
                max[j] = temp;
            }

        }
    }
    System.out.println(max[size-1]);

}

    @Test
        public static void stringcount(){
            String inputString = "Hello, Hello, World! Hello!";
            String targetSubstring = "Hello";

            int count = countOccurrences(inputString, targetSubstring);

            System.out.println("The substring '" + targetSubstring + "' appears " + count + " times.");
        }

        public static int countOccurrences(String input, String target) {
            int count = 0;
            int index = input.indexOf(target);

            while (index != -1) {
                count++;
                index = input.indexOf(target, index + 1);
            }

            return count;
        }

@Test


    public void StringManipulation (){

            String input = "aca bb cc ddd";
            String output = "";

            // Split the input string by spaces
            String[] parts = input.split(" ");

            // Iterate through the parts and append the first character of each part to the output
            for (String part : parts) {
                if (!part.isEmpty()) {  // Check if the part is not empty
                    output += part.charAt(0);
                }
            }

            // Print the output
            System.out.println("Output: " + output);
        }
    }
