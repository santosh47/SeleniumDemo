package com.project.selenium.Test;

import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Xl {

    public static void main(String[] rgs) throws IOException {

    String filePath = "path/to/your/excel/file.xlsx";
    FileInputStream file=new FileInputStream(filePath);
    Workbook workbook= new XSSFWorkbook(file);
        Sheet sheet=workbook.getSheetAt(0);
        for (Row row:sheet){
            for (Cell cell:row){

         switch (cell.getCellType()){
             case  STRING :
                 System.out.println(cell.getStringCellValue());
                 break;
             case NUMERIC:
                 System.out.println(cell.getNumericCellValue());
                 break;
             case BOOLEAN:
                 System.out.println(cell.getBooleanCellValue());
             default:
                 System.out.println();
         }

                }
            }
        }


}
