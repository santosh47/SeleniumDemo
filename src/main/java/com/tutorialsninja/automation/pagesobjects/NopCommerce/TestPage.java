package com.tutorialsninja.automation.pagesobjects.NopCommerce;

import com.tutorialsninja.automation.base.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class TestPage extends BaseClass {


    public TestPage(){
        PageFactory.initElements(driver,this);
    }
    public void Test()
    {
                System.out.println("hello");
    }
}
