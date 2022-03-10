# Lab_5_CVDS

##Parte I

## Parte II
### 6. Observe que el Servlet ‘SampleServlet’ acepta peticiones GET, y opcionalmente, lee el parámetro ‘name’.
![Sample Servlet](https://github.com/CarlosOrduz777/Lab05_CVDS/blob/ramitos/imagenes/parteII-2.PNG)
### 15. Probando funcionalidades
- Prueba Id existente
![Id Existente](https://github.com/CarlosOrduz777/Lab05_CVDS/blob/ramitos/imagenes/parteIII-3.PNG)
- Prueba Id no existente
![Id no Existente](https://github.com/CarlosOrduz777/Lab05_CVDS/blob/ramitos/imagenes/parteII-3.PNG)
- Prueba sin especificar Id
![Sin especificar Id](https://github.com/CarlosOrduz777/Lab05_CVDS/blob/ramitos/imagenes/parteII-4.PNG)


## Parte III

### Recompile y ejecute la aplicación. Abra en su navegador en la página del formulario, y rectifique que la página hecha anteriormente sea mostrada. Ingrese los datos y verifique los resultados. Cambie el formulario para que ahora en lugar de POST, use el método GET . Qué diferencia observa?

Podemos evidenciar que el usando el GET nos muestra por completo el path, es decir el id usado, mientras que usando el post no se nos muestra ninguna info del id, aunque el contenido mostrado en la pagina es exactamente el mismo (debido a que el metodo es exactamente igual)

### ¿Qué se está viendo? Revise cómo están implementados los métodos de la clase Service.java para entender el funcionamiento interno.

Cuando se ingresa en el espacio un valor diferente a un número válido se muestra una advertencia indicándonos que el valor ingresado no es un valor de tipo numérico. Si el valor ingresado es válido se muestran los datos solicitados como se ve a continuación:

### 18. Prueba del Formulario usando el método post
![post](https://github.com/CarlosOrduz777/Lab05_CVDS/blob/ramitos/imagenes/parteIII-2.PNG)
### 21. ¿Qué se está viendo?
![id formulario](https://github.com/CarlosOrduz777/Lab05_CVDS/blob/ramitos/imagenes/parteIII-1.PNG)
![id form](https://github.com/CarlosOrduz777/Lab05_CVDS/blob/ramitos/imagenes/parteIII-3.PNG)
## Parte IV
### Prueba de Ejecución
![Prueba de Ejecucion](https://github.com/CarlosOrduz777/Lab05_CVDS/blob/ramitos/imagenes/parteIV.PNG)
### Usando Chrome y ApplicationScoped
![Ap Chrome](https://github.com/CarlosOrduz777/Lab05_CVDS/blob/ramitos/imagenes/parteIV-1.PNG)
### Usando Edge y ApplicationScoped
![Ap Edge](https://github.com/CarlosOrduz777/Lab05_CVDS/blob/ramitos/imagenes/parteIV-2.PNG)
#### Se cambió el valor de la media en Edge y se reflejan los cambios en Chrome (Usando ApplicationScoped)
### Usando Chrome y SessionScoped
![Se Chrome](https://github.com/CarlosOrduz777/Lab05_CVDS/blob/ramitos/imagenes/parteIV-4.PNG)
### Usando Edge y SessionScoped
![Se Edge](https://github.com/CarlosOrduz777/Lab05_CVDS/blob/ramitos/imagenes/parteIV-3.PNG)
#### Se cambió el valor de la media en Edge y no se reflejan los cambios en Chrome (Usando SessionScoped)
[![CircleCI](https://circleci.com/gh/CarlosOrduz777/Lab05_CVDS/tree/master.svg?style=svg)](https://circleci.com/gh/CarlosOrduz777/Lab05_CVDS/tree/master)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/5a7b649284a142fdaa2daf01ebc4f917)](https://www.codacy.com/gh/CarlosOrduz777/Lab05_CVDS/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=CarlosOrduz777/Lab05_CVDS&amp;utm_campaign=Badge_Grade)
### HEROKU link
[Calculadora](https://lab06-ramos-orduz.herokuapp.com/)
