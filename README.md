# Readme

**Table of Contents**

[TOCM]

[TOC]

## Descripción
Uscanga es un Sistema de Gestión de Datos, el cual le da solución a una empresa de Inmobiliaria la cual requería de un sistema para llevar a cabo la gestión de sus clientes. 

## Problema Identificado
Uscanga Inmobiliaria pasaba por una de etapa de crecimiento y un proceso de digitalizar su base de datos. Por lo cual requerían contar con un sistema con el cual pasaran sus registros físicos en papel a digital. Ellos no contaban con una base de datos en MySql.

## Solución
Nosotros le propusimos una aplicación de Java, la cual les apoyaría con la gestión de sus clientes de una mejor manera y poder acceder a ella cuando ellos lo necesitaran. Además de tener un respaldo de su información. Este sistema estaría conectado a una base de datos que nosotros creamos y la cual almacenaría toda la información. Dentro de este sistema se dará la posibilidad de agregar, eliminar, actualizar y mostrar los clientes.

## Arquitectura
El sistema esta construido y diseñado en la arquitectura MVC, elegimos esta arquitectura porque tenia buen desempeño y nos da la posibilidad de agregar mas funcionalidades que se podrán agregar en un futuro.

## Requerimientos
- Contar con una versión de Java superior a la 8.
- Tener algún gestor de Base de Datos y de servidor. Recomendamos XAMPP.

## Instalación
1. Debemos descargar una versión de JDK superior a la 11.
2. Debemos descargar XAMPP. 
3. Debemos descargar el archivo JAR. 

## Configuración
1. Una vez descargado XAMPP configuraremos XAMPP seleccionando solo el módulo de Apache y MySQL.
2. Iniciaremos el Módulo de Apache y MySQL dentro de XAMPP. 
3. Abriremos en el navegador localhost:8080 
4. Nos iremos a PHPMyAdmin. 
5. Crearemos una Base de Datos con los campos necesarios. 
6. Copiaremos los datos de referencia de la Base de Datos. 
7. En nuestro editor de código abiremos el archivo dentro de Modelo/Conexión y cambiaremos el nombre se la base de datos por la que se ha creado  en:
`con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_ejemplo", "root","");`

## Uso
Si eres el usuario final se te asigno un periodo de capacitación para el uso del sistema.
- Si deseas agregar un cliente nuevo, tendrás que llenar los campos del primer bloque, cuando lo termines de llenar tendrás que dar clic en agregar.
- Si deseas actualizar o editar a un cliente, debes seleccionar primero a quien quieres editar, después darás clic al botón editar, y cambiaras los datos que necesites, cuando termines darás al botón de OK para que se guarden tus cambios.
- Si deseas borrar a algún cliente, deberás seleccionar la fina que quieras borrar, después darás clic en el botón de borrar.

## Contribuciones
Si deseas contribuir al proyecto no hay problema, estamos abiertos a recibir contribuciones. 
1. Puedes clonar el proyecto.
2. Crear una rama que se llame Develop.
3. Y es aquí donde puedes experimentar, crear, borrar, modificar el proyecto.
4. Cuando ya estes listo puedes solicitar realizar un pull request.
5. El equipo de desarrollo lo analizara y tomara la decisión si implementarlo o agregarte comentarios si algo está mal.

## Roadmap
En un futuro cercano se tiene esperado y contemplado la implementación de nuevas funciones y más características como:
- Mejorar la interfaz gráfica.
- Agregar más interfaces para realizar cada acción.
- Mejoras de diseño.
- Correcciones de bugs y errores.
