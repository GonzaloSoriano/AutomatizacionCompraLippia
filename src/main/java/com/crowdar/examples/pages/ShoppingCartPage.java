package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ShoppingCartPage extends PageBaseShop {



    public ShoppingCartPage(RemoteWebDriver driver) {
        super(driver);
        this.url="";
    }
    //pantalla Summary
    private final String H1_TITLE_ID = "cart_title";
    private final String SPAN_TOTAL_CSS_SELECTOR = "#cart_summary > tfoot > tr:nth-child(7) > td.total_price_container.text-right > span";
    //private final String BUTTON_ADDCANT_CSS_SELECTOR = "#cart_quantity_up_4_16_0_372086 > span > i";
    //private final String BUTTON_PROCEEDCHECKOUT_SUMMARY_CSS_SELECTOR = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium";

    //pantalla addresses
    private final String H1_TITLE_ADDRESSES_CSS_SELECTOR = "#center_column > h1";
    //private final String BUTTON_PROCEEDCHECKOUT_ADDRESSES_CSS_SELECTOR = "#center_column > form > p > button";

    //pantalla shipping
    private final String H1_TITLE_SHIPPING_CSS_SELECTOR = "#carrier_area > h1";
    //private final String INPUT_CHECKBOX_ID = "cgv";
    //private final String BUTTON_PROCEEDCHECKOUT_SHIPPING_CSS_SELECTOR= "#form > p > button";

    //pantalla Payment Method
    private final String H1_TITLE_PAYMENTMETHOD_CSS_SELECTOR = "#center_column > h1";
    private final String BUTTON_PAYMENTMETHOD_CSS_SELECTOR = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a";

    //pantalla Order Summary
    private final String H1_TITLE_ORDERSUMMARY_CSS_SELECTOR = "#center_column > h1";
    private final String BUTTON_ORDERSUMMARY_CSS_SELECTOR = "#cart_navigation > button";

    //pantalla Order Confirmation
    private final String H1_TITLE_ORDERCONFIRMATION_CSS_SELECTOR = "#center_column > h1";

    public void verificarShoppingCartPage() {
        Assert.assertEquals(getWebElement(By.id(H1_TITLE_ID)).getText(), "SHOPPING-CART SUMMARY\n" +
                "Your shopping cart contains: 1 Product");
    }

    public void cantidadArticulos(String cantidad){
        setInput("store.input_cantarticulos_summary", cantidad, true);
        clickElement(By.cssSelector(SPAN_TOTAL_CSS_SELECTOR));
    }

    public void clickBoton(String boton){
        switch (boton){
            case "Proceed to checkout": clickearProceedCheckout(); break;
            case "Terminos y Servicios": click("store.input_checkbox"); break;
            case "Pay by bank wire": clickElement(By.cssSelector(BUTTON_PAYMENTMETHOD_CSS_SELECTOR)); break;
            case "I confirm my order": clickElement(By.cssSelector(BUTTON_ORDERSUMMARY_CSS_SELECTOR)); break;
        }
    }

    public void verificarPantalla(String pantalla){
        switch (pantalla){
            case "Addresses": verificarAddresses(); break;
            case "Shipping": verificarShipping(); break;
            case "Payment Method": verificarPaymentMethod(); break;
            case "Order Summary": verificarOrderSummary(); break;
            case "Order Confirmation": verificarOrderConfirmation(); break;
        }
    }


    //Metodo para clickear todos los botones llamados "Proceed to checkout"
    private void clickearProceedCheckout() {
        if(isPresent("store.button_proceed_shipping")){
            click("store.button_proceed_shipping");
        } else{
            if(isPresent("store.button_proceedcheckout_addresses")){
                click("store.button_proceedcheckout_addresses");
            } else {
                if(isPresent("store.button_proceedcheckout_summary")){
                    click("store.button_proceedcheckout_summary");
                } else{
                    if(isPresent("store.button_proceedcheckout_article")){
                        click("store.button_proceedcheckout_article");
                    }
                }
            }
        }



    }


    //Verificacion de pantallas
    private void verificarOrderConfirmation() {
        Assert.assertEquals(getWebElement(By.cssSelector(H1_TITLE_ORDERCONFIRMATION_CSS_SELECTOR)).getText(),"ORDER CONFIRMATION");

    }

    private void verificarOrderSummary() {
        Assert.assertEquals(getWebElement(By.cssSelector(H1_TITLE_ORDERSUMMARY_CSS_SELECTOR)).getText(),"ORDER SUMMARY");
    }

    private void verificarPaymentMethod() {
        Assert.assertEquals(getWebElement(By.cssSelector(H1_TITLE_PAYMENTMETHOD_CSS_SELECTOR)).getText(),"PLEASE CHOOSE YOUR PAYMENT METHOD");
    }
    private void verificarShipping() {
        Assert.assertEquals(getWebElement(By.cssSelector(H1_TITLE_SHIPPING_CSS_SELECTOR)).getText(),"SHIPPING");
    }

    private void verificarAddresses(){
        Assert.assertEquals(getWebElement(By.cssSelector(H1_TITLE_ADDRESSES_CSS_SELECTOR)).getText(),"ADDRESSES");
    }

    
}
