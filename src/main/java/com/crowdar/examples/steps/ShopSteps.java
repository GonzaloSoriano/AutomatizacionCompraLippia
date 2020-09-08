package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.examples.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopSteps {
    @Given("El cliente esta en el Home")
    public void elClienteEstaEnElHome() {
        Injector._page(HomePage.class).go();
        Injector._page(HomePage.class).verificarHome();
    }

    @When("selecciona el articulo: (.*)")
    public void seleccionaElArticulo(String articulo) {
        Injector._page(HomePage.class).buscarArticulo(articulo);
    }

    @Then("es redirigido a la pantalla (.*)")
    public void esRedirigidoALaPantalla(String pantalla) {
        switch(pantalla){
            case "Shopping Cart": Injector._page(ShoppingCartPage.class).verificarShoppingCartPage(); break;
            case "Login": Injector._page(LoginPage.class).verificarLoginPage(); break;
            case "My Account": Injector._page(MyAccountPage.class).verificarMyAccount(); break;
            case "Article": Injector._page(ArticlePage.class).verificarProductPage(); break;
            case "Addresses": Injector._page(ShoppingCartPage.class).verificarPantalla(pantalla); break;
            case "Shipping": Injector._page(ShoppingCartPage.class).verificarPantalla(pantalla); break;
            case "Payment Method": Injector._page(ShoppingCartPage.class).verificarPantalla(pantalla); break;
            case "Order Summary": Injector._page(ShoppingCartPage.class).verificarPantalla(pantalla); break;
            case "Order Confirmation": Injector._page(ShoppingCartPage.class).verificarPantalla(pantalla); break;

        }
    }

    @And("clickea el boton (.*)")
    public void clickeaElBoton(String boton) {
        switch (boton){
            case "Sign In": Injector._page(LoginPage.class).clickBotonSignIn(); break;
            case "Add to cart": Injector._page(ArticlePage.class).clickBoton(); break;
            case "Proceed to checkout": Injector._page(ShoppingCartPage.class).clickBoton(boton); break;
            case "Terminos y Servicios": Injector._page(ShoppingCartPage.class).clickBoton(boton); break;
            case "Pay by bank wire": Injector._page(ShoppingCartPage.class).clickBoton(boton); break;
            case "I confirm my order": Injector._page(ShoppingCartPage.class).clickBoton(boton); break;
        }
    }

    @And("clickea la cantidad de (.*) articulos")
    public void clickeaLaCantidadDeArticulos(String cantidad) {
        Injector._page(ShoppingCartPage.class).cantidadArticulos(cantidad);
    }

    @And("ingresa su email: (.*) y contraseña: (.*)")
    public void ingresaEmailyPass(String email, String pass) {
        Injector._page(LoginPage.class).ingresarDatos(email, pass);
    }
}
