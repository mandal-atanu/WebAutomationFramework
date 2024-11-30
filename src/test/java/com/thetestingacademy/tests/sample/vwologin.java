package com.thetestingacademy.tests.sample;

import com.thetestingacademy.driver.drivermanager;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class vwologin {

    @BeforeTest
    public void setup(){
        drivermanager.init();
    }

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void testvwologinnegative()  {

        WebDriver driver = drivermanager.getDriver();
        driver.get("https://app.vwo.com/#/login");

        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        WebElement emailinputbox = driver.findElement(By.id("login-username"));
        emailinputbox.sendKeys("admin@admin.com");

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("password@321");

        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement error_msg = driver.findElement(By.id("js-notification-box-msg"));
        Assert.assertEquals(error_msg.getText(),"Your email, password, IP address or location did not match");
        System.out.println(error_msg.getText());

        //driver.quit();




    }
}
