# Analizador :octopus:
Repositorio que contiene el Examen Mercadolibre

# Configuracion :wrench: 
Para ejecutar la app, es necesario modificar los accesso a BD, se ultilizo MARIADB, en el archivo:

application.properties

Valores a modificar:
spring.datasource.url=URL_DE_ACCESO</br>
spring.datasource.username=USUARIO_BD</br>
spring.datasource.password=PASSWORD</br>

En el script.sql esta la  estructura de BD(MARIADB), necesaria para la aplicacion.

# Acceder a la APP :rocket:
Una vez realizada las configuraciones necesarias y desplegado el componente en el servidor (en el caso de que desees desplegar el jar), sino puedes ejecutarlo desde tu IDE de programación.

Acceder

Para ejecutar la aplicacion acceder a la url: http://IP:PUERTO/mutant  por medio del metodo GET allí encontraras el listado de adn analizados

En la url:  http://IP:PUERTO/mutant/ podras realizar una comprobacion de algun adn, ejecutando el metodo POST y enviando un JSON con la siguiente estructura:

{
    "dna": [
        "ATGCTA",
        "CAGTGC",
        "TTATGT",
        "AGAAGa",
        "CTCCTA",
        "TCACTG"
    ]
}

Para conocer las estadisticas de los adns registrados, podemos acceder a la sig url http://IP:PUERTO/mutant/stats a traves del metodo GET

:tada:
:end:

Carlos A. Contreras R.
