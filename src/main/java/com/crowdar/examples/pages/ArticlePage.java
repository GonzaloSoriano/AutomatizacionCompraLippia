package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ArticlePage extends PageBaseShop {

    public ArticlePage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    private final String H3_DATASHEET_CSS_SELECTOR = "#center_column > div > section:nth-child(2) > h3";


    public void verificarProductPage() {
        Assert.assertEquals(getWebElement(By.cssSelector(H3_DATASHEET_CSS_SELECTOR)).getText(), "DATA SHEET");
    }

    public void clickBoton() {
        if (isPresent("store.button_addtocart_article")) {
            click("store.button_addtocart_article");
        }
    }
}