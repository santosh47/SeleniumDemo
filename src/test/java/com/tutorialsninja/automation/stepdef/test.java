package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.base.Base;
import io.cucumber.java.en.Given;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import java.util.Iterator;
import java.util.Set;

public class test {
    //@Given("navigate url")
    static Set<String> all;



        @Given("singleton dessign")
        public void singletonDessign() throws InterruptedException {


        System.out.println("testing cc");
        Base.driver.get("https://www.softwaretestingo.com/ust-global-interview-questions/");


       // Base.driver.get(Base.reader.getUrl());
        all = Base.driver.getWindowHandles();
        Base.driver.switchTo().newWindow(WindowType.WINDOW);
        Base.driver.get("https://www.softwaretestingo.com/ust-global-interview-questions/");
        Base.driver.switchTo().newWindow(WindowType.TAB);
        handle("UST Global New & Useful Testing Interview Questions 2023");


    }

    public static void handle(String title) throws InterruptedException {
        Iterator<String> i = all.iterator();
        while (i.hasNext()) {
            String win = i.next();
            Base.driver.switchTo().window(win);
            if (Base.driver.getTitle().equals(title)) ;
            System.out.println("pass");
            Thread.sleep(6000);
            break;
        }
    }
}
