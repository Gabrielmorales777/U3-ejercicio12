# U3-ejercicio12
# 🔒 Control de Acceso a una Caja Fuerte Digital

Ejercicio de **Programación Orientada a Objetos en Java** que modela una caja fuerte electrónica aplicando el principio de **encapsulamiento**. La combinación secreta, el estado de bloqueo y el contador de intentos fallidos son privados: ninguna clase externa puede conocer la clave, y la única forma de interactuar con la caja es mediante métodos que verifican cada intento y bloquean el dispositivo tras tres errores consecutivos.

## 🎯 Objetivo

Proteger la combinación de una caja fuerte y aplicar una política de seguridad de bloqueo por intentos fallidos, sin exponer nunca la clave ni permitir modificarla sin conocer la actual.

## ✨ Características

- Atributos privados: combinación secreta, estado de bloqueo, contador de intentos fallidos y estado de apertura.
- `abrir(String intentoClave)`: valida la clave, cuenta los errores y bloquea la caja al tercer error consecutivo.
- `cambiarCombinacion(String claveActual, String nuevaCombinacion)`: exige la clave actual y valida la nueva.
- Un acierto reinicia el contador, por lo que solo los errores **consecutivos** bloquean la caja.
- Una caja bloqueada rechaza cualquier intento, incluso con la clave correcta.
- Sin `getCombinacion()`: la clave nunca sale del objeto ni aparece en el estado informado.
- Lógica de seguridad centralizada en un método privado reutilizado por las operaciones públicas.



## 📚 Conceptos aplicados

Encapsulamiento · Ocultación de información · Modificadores de acceso · Control de estado · Validación de datos · Constructores · Métodos privados

![U3 ejercicio12](U3%20ejercicio12.png)
