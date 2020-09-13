package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class CatalogPage extends PageBaseShop{


    public CatalogPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    private final String BUTTON_TSHIRTS_CSS_SELECTOR = "#block_top_menu > ul > li:nth-child(3)";
    private final String BUTTON_ITEMNAME_CSS_SELECTOR = "#center_column > ul > li > div > div.right-block > h5 > a";
    private final String DIV_CONTENTSCENE_XPATH = "//*[@id=\"center_column\"]/div[1]/div";

    public void verificarCatalog(){
          Assert.assertTrue(isElementPresentAndDisplayed(By.xpath(DIV_CONTENTSCENE_XPATH)), "El elemento no esta visible");
    }

    public void clickBoton(){
        clickElement(By.cssSelector(BUTTON_TSHIRTS_CSS_SELECTOR));
    }


    public void clickItem(){
        //button_productname_tshirts = CSS:#center_column > ul > li > div > div.right-block > h5 > a
        //click("store.button_productname_tshirts");
        if(isElementPresentAndDisplayed(By.cssSelector(BUTTON_ITEMNAME_CSS_SELECTOR))){
            clickElement(By.cssSelector(BUTTON_ITEMNAME_CSS_SELECTOR));
        }

    }

}
