Feature: Como cliente quiero ingresar las credenciales de mi cuenta para iniciar sesion

  @Login
  Scenario: El cliente inicia sesion en el sitio de compras
    Given El cliente esta en el Home
    When clickea el boton Sign In
    Then es redirigido a la pantalla Login

    When ingresa su email: gonza@gonzalo.com.ar y contraseña: 123456
    And clickea el boton Sign In
    Then es redirigido a la pantalla My Account