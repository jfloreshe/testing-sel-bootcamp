package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.lang.model.element.Element;
import java.util.List;

public class VistaPostEmisionPage extends BasePage {
    By imprimirA4Button = By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/div/div/div/div/div/smrt-cntdocumentos/app-vista-documento-contable/app-card/div/div/div/div[1]/div/div[2]/div/div[3]/button");
    By preloaderDiv = By.id("preloader");

    public VistaPostEmisionPage(WebDriver driver) {
        super(driver);
    }

    public void esperarCargaPdf() {
        wait.until( d -> {
            try {
                d.findElement(imprimirA4Button);
                return true;
            } catch (Exception ex) {
                return false;
            }
        });
    }
}