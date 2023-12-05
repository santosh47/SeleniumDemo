package com.project.selenium.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListToArray {

    public static void main(String[] args) throws IOException {
        //Lits to array

        List<String> l = new ArrayList<>();
        String[] str = l.toArray(new String[0]);

        //array to list

        int a[] = new int[2];
        List<int[]> list = List.of(a);
    }
}