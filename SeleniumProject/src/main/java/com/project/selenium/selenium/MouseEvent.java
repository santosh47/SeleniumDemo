package com.project.selenium.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static com.project.selenium.base.Base.driver;

public class MouseEvent {

    @Test
    public void mouse(){

        WebElement clickable = driver.findElement(By.id("click"));
        new Actions(driver)
                .click(clickable)
                .perform();

        new Actions(driver)
                .contextClick(clickable)
                .perform();

        new Actions(driver)
                .doubleClick(clickable)
                .perform();
        new Actions(driver)
                .moveToElement(clickable)
                .perform();

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();
    }

}
