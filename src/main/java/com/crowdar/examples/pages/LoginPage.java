package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class LoginPage extends PageBaseShop {

    public LoginPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    //private final String INPUT_EMAIL_ID= "email";
    //private final String INPUT_PASS_ID="passwd";
    private final String BUTTON_SIGNIN_CSS_SELECTOR ="#SubmitLogin";
    private final String H3_TITLE_CSS_SELECTOR= "#login_form > h3";


    public void verificarLoginPage() {
        Assert.assertEquals(getWebElement(By.cssSelector(H3_TITLE_CSS_SELECTOR)).getText(), "ALREADY REGISTERED?");
    }

    public void ingresarDatos(String email, String pass){
        setInput("store.input_mail_id", email, true);
        setInput("store.input_pass_id", pass, true);
        //completeField(By.id(INPUT_EMAIL_ID), email);
        //completeField(By.id(INPUT_PASS_ID), pass);
    }

    public void clickBotonSignIn(){
        if(isElementPresent(By.cssSelector(BUTTON_SIGNIN_CSS_SELECTOR)) && isPresent("store.button_signin_home")){
            clickElement(By.cssSelector(BUTTON_SIGNIN_CSS_SELECTOR));
        } else {
            click("store.button_signin_home");
        }

    }
}
