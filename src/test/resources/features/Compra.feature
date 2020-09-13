Feature: Como cliente, quiero agregar articulos al carrito de compra, para realizar la compra

  @Smoke @Compra @CompraSinLogin
  Scenario: El cliente sin iniciar sesion agrega articulos al carrito y realiza la compra
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


  @Smoke @Compra @CompraConLogin
  Scenario: El cliente inicia sesion en el sitio y realiza una compra
    Given El cliente esta en el Home
    When clickea el boton Sign In
    Then es redirigido a la pantalla Login

    And ingresa su email: gonza@gonzalo.com.ar y contraseña: 123456
    And clickea el boton Sign In
    Then es redirigido a la pantalla My Account

    And clickea el boton T-SHIRTS
    Then es redirigido a la pantalla Catalog

    And clickea el boton Nombre Articulo
    Then es redirigido a la pantalla Article

    And clickea el boton Add to cart
    And clickea el boton Proceed to checkout
    Then es redirigido a la pantalla Shopping Cart

    And clickea la cantidad de 2 articulos
    And clickea el boton Proceed to checkout
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