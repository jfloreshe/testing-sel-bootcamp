package com.magento.tests;

import com.magento.pages.FacturaNuevaPage;
import com.magento.pages.HomePage;
import com.magento.pages.LoginPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacturaTest extends BaseTest{

    @Test
    public void doEmitirFacturaSimpleConItemManual(){
        loginPage.fillOutForm();
        loginPage.submitData();
        homePage.goToNewFactura();

        facturaNuevaPage.fillReceptorData();
        facturaNuevaPage.fillItemManualModal();
        facturaNuevaPage.emitirComprobante();

        try{
            Thread.sleep(3000);
        } catch (Exception e) {

        }
    }
}
