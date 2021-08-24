# Analizador :octopus:
Repositorio que contiene el Examen Mercadolibre


Para ejecutar la app, es necesario modificar los accesso a BD, se ultilizo MARIADB, en el archivo:

application.properties

Valores a modificar:
spring.datasource.url=URL_DE_ACCESO
spring.datasource.username=USUARIO_BD
spring.datasource.password=PASSWORD

En el script.sql esta la  estructura de BD(MARIADB), necesaria para la aplicacion.

Una vez realizada las configuraciones necesarias, podemos acceder :rocket:

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


