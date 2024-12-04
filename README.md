# Tienda Avvale

Este proyecto es una prueba de concepto que incluye un frontend, una API y una base de datos. A continuación, se detallan los pasos necesarios para instalar las dependencias, configurar la base de datos y ejecutar el proyecto.

## Tecnologías Utilizadas

- **API:** Java con Spring Boot.
- **Frontend:** HTML, CSS y JavaScript.
- **Base de Datos:** MySQL.

## Requisitos Previos

1. Instalar **Java JDK 11** o superior (En mi caso utilizo **Java JDK 21**).
2. Instalar **Maven**.
3. Instalar **MySQL Server**.
4. Tener un servidor local o una herramienta como **XAMPP** o **Docker** para gestionar MySQL. En mi caso utilizo IntellJ IDEA para iniciar la API y Visual Studio COde con la extensión Live Server para iniciar el front

## Pasos de Instalación

### Backend (API)

1. Navega a la carpeta `APITienda`.
2. Ejecuta el siguiente comando para instalar las dependencias:
   mvn clean install
3. Para iniciar el proyecto ejecuta mvn spring-boot:run

### Base de Datos

1. Crea una nueva base de datos en MySQL.
2. Ejecuta los scripts SQL en el siguiente orden:
    - CreacionTablas.sql: Crea las tablas necesarias.
    - PoblarTablas.sql: Llena las tablas con datos iniciales.
    - (Opcional) LimpiarTablas.sql: Limpia los datos si es necesario.
   Puedes usar herramientas como MySQL Workbench o ejecutar los comandos directamente en tu terminal.

### FrontEnd

Se recomienda instalar Visual Studio Code junto con la extensión live server

## Ejecución de FrontEnd

1. Abre la carpeta FrontAvvaleTienda en Visual Studio Code.
2. Utiliza la extensión Live Server para iniciar un servidor local en el puerto 5500
3. Se abre en tu navegador predeterminado el archivo home.html

###Notas

- Si deseas modificar la configuración de conexión a la base de datos, edita el archivo application.properties en la carpeta src/main/resources del backend.
- Para cualquier problema o sugerencia, puedes contactar al autor del proyecto.
