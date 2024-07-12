package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacturaNuevaPage extends BasePage {
    By numeroDocumentoReceptor = By.id("dniRuc");
    By nombreReceptor = By.id("RazonSocial");
    By buscarEntidadReceptorButton = By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/div/div/div/div/div/smrt-cntdocumentos/app-documento-factura-boleta/app-card/div/div/div/div[3]/div/div[1]/app-cabecera-documento-common/div[1]/div[1]/app-card/div/div[2]/div/form/div/div[2]/div[1]/button");
    By servicioManualButton = By.id("04010103010_btnAgregarItemmanual");
    By descripcionItemManualModal = By.id("descripcion");
    By aceptarButtonItemManualModal = By.xpath("/html/body/ngb-modal-window/div/div/app-agregar-item-manual/div[3]/div/div[1]/button");
    By emitirButton = By.id("0401010302_frBusquedaItem_btnEmitir");

    public FacturaNuevaPage(WebDriver driver) {
        super(driver);
    }

    public void fillReceptorData() {
        type(numeroDocumentoReceptor, "10721901861");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        click(buscarEntidadReceptorButton);
//        wait.until( x -> {
//            driver.findElement(nombreReceptor).
//            driver.findElement(nombreReceptor).isDisplayed();
//        });
    }

    public void fillItemManualModal() {
        click(servicioManualButton);
        type(descripcionItemManualModal, "Test item manual");
        click(aceptarButtonItemManualModal);
    }
    public void emitirComprobante() {
        click(emitirButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }
}
