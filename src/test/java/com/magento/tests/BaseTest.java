package com.magento.tests;

import com.magento.pages.HomePage;
import com.magento.pages.LoginPage;
import com.magento.pages.RegisterPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;
    //protected RegisterPage registerPage;
    protected LoginPage loginPage;
    //protected HomePage homePage;
    @BeforeMethod
    public void setup(){
        driver= new FirefoxDriver();//instanciando el objeto driver
        //homePage= new HomePage(driver);
        //registerPage=new RegisterPage(driver) ;
        loginPage=new LoginPage(driver);

    }

    @AfterMethod
    public void teardown(){
        if (driver!=null){
            driver.quit();
        }

    }

}
