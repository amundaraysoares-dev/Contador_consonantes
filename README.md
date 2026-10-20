# 🔤 Contador de Consonantes Multihilo en Java

---

### 1. Clase `hilo` (Extiende de `Thread`)


* **Variables principales** (recibe una instancia de `contador_total` para la gestión global):
    * `String[] texto;`
    * `Character consonante;`
    * `int contador;`
    * `contador_total C_contador;`

* **Funcionamiento (`run`)**:
    1. Recorre el array de texto palabra por palabra.
    2. Utiliza un segundo bucle con `charAt()` para analizar letra por letra y comprobar si coincide con la consonante asignada.
    3. Si hay coincidencia, incrementa el contador local.
    4. Envía el resultado al objeto compartido `contador_total`.
    5. Utiliza un bloque `synchronized` en la salida por consola para evitar que los mensajes de los diferentes hilos se mezclen de forma desordenada.

![Código de la clase Hilo](fotos/Captura%20de%20pantalla%202026-10-20%20133203.png)

---

### 2. Clase `contador_total`


* **Variables y Métodos**:
    * Variable `total` para acumular el recuento global.
    * Método `incrementar()` protegido con `synchronized` para evitar condiciones de carrera (Race Conditions) al actualizar el total.
    * Método `get_total()` para consultar el resultado final desde el hilo principal (`main`).

![Código de la clase Contador Total](fotos/Captura%20de%20pantalla%202026-10-20%20133157.png)

---

### 3. Clase Principal (`contador_Caracteres`)


* **Flujo de ejecución**:
    1. **Entrada de consonantes**: Mediante un `Scanner` y un bucle, solicita al usuario introducir consonantes hasta completar un total de 5 válidas (validadas contra una lista de caracteres permitidos).
    2. **Entrada de texto**: Pide una frase o texto, el cual se procesa usando `trim()` y `split(" ")` para dividirlo en palabras y almacenarlo en un array/lista.
    3. **Lanzamiento de hilos**: Crea un bucle que instancia un hilo por cada consonante seleccionada, pasándole su respectivo fragmento de trabajo, y los almacena en una lista.
    4. **Sincronización (`join`)**: Recorre la lista de hilos esperando a que todos terminen su ejecución (`join()`).
    5. **Resultado**: Muestra por pantalla el resultado global llamando al getter de la clase `contador_total`.

![Código Principal - Parte 1](fotos/Captura%20de%20pantalla%202026-10-20%20133214.png)
![Código Principal - Parte 2](fotos/Captura%20de%20pantalla%202026-10-20%20133216.png)

---

## 🚀 Comprobación y Ejecución

![Captura de ejecución](fotos/Captura%20de%20pantalla%202026-10-20%20130051.png)