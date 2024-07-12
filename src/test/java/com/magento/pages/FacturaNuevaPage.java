package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FacturaNuevaPage extends BasePage {
    By preloaderDiv = By.id("preloader");
    By numeroDocumentoReceptorInput = By.id("dniRuc");
    By tipoDocumentoReceptorSelectBox = By.id("tipoDocumentoCliente");
    By nombreReceptorInput = By.id("RazonSocial");
    By buscarEntidadReceptorButton = By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/div/div/div/div/div/smrt-cntdocumentos/app-documento-factura-boleta/app-card/div/div/div/div[3]/div/div[1]/app-cabecera-documento-common/div[1]/div[1]/app-card/div/div[2]/div/form/div/div[2]/div[1]/button");
    By servicioManualButton = By.id("04010103010_btnAgregarItemmanual");
    By descripcionItemManualInputModal = By.id("descripcion");
    By aceptarItemManualButtonModal = By.xpath("/html/body/ngb-modal-window/div/div/app-agregar-item-manual/div[3]/div/div[1]/button");
    By emitirButton = By.id("0401010302_frBusquedaItem_btnEmitir");

    public FacturaNuevaPage(WebDriver driver) {
        super(driver);
    }

    public void fillReceptorData() {
        wait.until( d -> {
            try {
                WebElement element = d.findElement(preloaderDiv);
                return "none".equals(element.getCssValue("display"));
            } catch (Exception ex) {
                return true;
            }
        });

        wait.until( d -> {
            try {
                WebElement selectElement = d.findElement(tipoDocumentoReceptorSelectBox);
                Select select = new Select(selectElement);
                List<WebElement> options = select.getOptions();
                for(WebElement option : options) {
                    if (option.getText().equalsIgnoreCase("RUC")) {
                        type(numeroDocumentoReceptorInput, "10721901861");
                        return true;
                    }
                }

                return false;
            } catch (Exception ex) {
                return true;
            }
        });


        click(buscarEntidadReceptorButton);

        wait.until( d -> {
            try{
                WebElement element = d.findElement(nombreReceptorInput);
                String nombreReceptorValue = element.getAttribute("value");
                return !nombreReceptorValue.isEmpty();
            } catch (Exception ex) {
                return true;
            }
        });
    }

    public void fillItemManualModal() {
        wait.until( d -> {
            try{
                WebElement element = d.findElement(nombreReceptorInput);
                String nombreReceptorValue = element.getAttribute("value");
                return !nombreReceptorValue.isEmpty();
            } catch (Exception ex) {
                return true;
            }
        });

        click(servicioManualButton);
        type(descripcionItemManualInputModal, "Test item manual");
        click(aceptarItemManualButtonModal);
    }
    public void emitirComprobante() {
        click(emitirButton);

    }
}
