package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class MyAccountPage extends PageBaseShop{

    public MyAccountPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    private final String H1_TITLE_CSS_SELECTOR = "#center_column > h1";

    public void go(){ navigateToCompleteURL(); }

    public void verificarMyAccount(){
        Assert.assertTrue(isElementPresentAndDisplayed(By.cssSelector(H1_TITLE_CSS_SELECTOR)),"El elemento no esta visible");
    }
}
