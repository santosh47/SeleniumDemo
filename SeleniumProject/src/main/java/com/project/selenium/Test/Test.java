package com.project.selenium.Test;

import io.cucumber.java.eo.Se;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PaneInformation;
import org.apache.xpath.objects.XString;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Test {

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