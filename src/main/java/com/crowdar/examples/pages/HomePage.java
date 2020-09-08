package com.crowdar.examples.pages;

import com.crowdar.core.actions.ActionManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.List;

public class HomePage extends PageBaseShop {

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    private final String SLIDER_HOME_ID="slider_row";



    public void go(){ navigateToCompleteURL(); }

    public void verificarHome(){
        Assert.assertTrue(isElementPresentAndDisplayed(By.id(SLIDER_HOME_ID)), "El elemento no es visible");
    }

    public void clickBotonSignIn(){

        click("store.button_signin_home");
    }

    public void buscarArticulo(String nombreArticulo){
        List<WebElement> listaProductos = getWebElements(By.className("product-name"));

        for(WebElement elemento:listaProductos){
            if(elemento.getAttribute("title").contains(nombreArticulo)){
                elemento.click();
                break;
            }
        }
    }



}
