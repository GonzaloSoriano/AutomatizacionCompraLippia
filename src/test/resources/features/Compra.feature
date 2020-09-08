Feature: Como usuario registrado quiero agregar articulos al carrito de compra para realizar la compra

  @Smoke @Compra
  Scenario: El cliente agrega articulos al carrito y finaliza la compra
    Given El cliente esta en el Home
    When selecciona el articulo: Blouse
    Then es redirigido a la pantalla Article

    And clickea el boton Add to cart
    And clickea el boton Proceed to checkout
    Then es redirigido a la pantalla Shopping Cart

    And clickea la cantidad de 2 articulos
    And clickea el boton Proceed to checkout
    Then es redirigido a la pantalla Login

    And ingresa su email: gonza@gonzalo.com.ar y contraseña: 123456
    And clickea el boton Sign In
    Then es redirigido a la pantalla Addresses

    And clickea el boton Proceed to checkout
    Then es redirigido a la pantalla Shipping

    And clickea el boton Terminos y Servicios
    And clickea el boton Proceed to checkout
    Then es redirigido a la pantalla Payment Method

    And clickea el boton Pay by bank wire
    Then es redirigido a la pantalla Order Summary

    And clickea el boton I confirm my order
    Then es redirigido a la pantalla Order Confirmation