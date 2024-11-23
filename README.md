Link al repositorio: https://github.com/Oyupa/PDE_Saludo_Sensores.git
Trabajo realizado por: Adrián Puyo Olías

# **Aplicación de Saludo con Lista de Contactos y Sensores**

## **Descripción**
Esta es una aplicación interactiva que permite a los usuarios gestionar contactos y explorar funcionalidades basadas en sensores de su dispositivo. Incluye una lista de contactos personalizable que también se muestra como un widget en la pantalla de inicio. Además, integra una flecha interactiva que apunta al norte y cambia de color según los niveles de luminosidad detectados por el sensor del dispositivo.
(Típica chapa de chatgpt)
---

## **Características**

### **1. Gestión de Contactos**
- **Lista de contactos**: Visualiza todos los contactos añadidos.
- **Detalles de contactos**: Al seleccionar un contacto en la lista, se muestran todos sus detalles.
- **Añadir contactos**: Los usuarios pueden agregar contactos nuevos fácilmente.
- **Widget dinámico**: Los contactos añadidos se actualizan automáticamente en un widget de la pantalla de inicio, lo que permite un acceso rápido a la lista.
- ⚠️ No está implementado ningún sistema de guardado ya que no se requería. Por lo tanto los contactos desaparecerán en cuanto la aplicación se cierre. ⚠️
---

### **2. Funcionalidades de Sensores**
- **Flecha que no apunta al Norte**: ¿Por qué no apunta al Norte? Porque la de Jack Sparrow tampoco lo hacía. Utiliza el acelerómetro y el sensor magnético para mostrar una flecha que se mueve en función de la dirección del teléfono.
- **Cambio de color dinámico**: La flecha cambia de color (Rojo, Amarillo, Verde y Azúl) en función de la luminosidad captada por el sensor de luz. 

---

## **Cómo Usar la Aplicación**

### **Saludo**

1. **Visualización del saludo**
    - Sale un saludo en función de la hora del día. No tiene mucho misterio

### **Gestión de Contactos**

1. **Visualizar contactos**:
    - En la actividad principal, verás una lista de contactos que incluye solo los nombres.
    - Haz clic en un nombre para ver más detalles sobre el contacto.

2. **Añadir contactos**:
    - Pulsa el botón "Añadir contacto" para abrir el formulario.
    - Introduce el nombre del contacto y guárdalo.
    - El contacto se añadirá automáticamente a la lista y al widget.

3. **Widget de contactos**:
    - Ve a la pantalla de inicio de tu dispositivo.
    - Agrega el widget "Lista de Contactos" desde el menú de widgets.
    - El widget mostrará la lista más reciente de contactos.
    - Hasta mi abuela sabe hacerlo

---

### **Brújula de Jack**
1. **Navegar con la flecha**:
    - Abre la pantalla de sensores.
    - La flecha apuntará automáticamente a alguna parte en función de la posición del teléfono.
    - La mejor manera de probar esta funcionalidad es poner los parámetros del campo magnético a (0,10,10) y los ejes en: 60º el 'X', 0º el 'Y' y rotar el eje 'Z' viendo como se mueve la brújula.
    - También se le puede hacer cambiar de color cambiando los valores del sensor de luz.


---

## **Tecnologías Usadas**
- **Kotlin**: Lenguaje principal para la implementación.
- **Fragmentos**: Para dividir y gestionar la interfaz de usuario.
- **Widget**: Para mostrar contactos en la pantalla de inicio.
- **Sensores Android**: Integración de acelerómetro, sensor magnético y sensor de luz.
- **SharedPreferences**: Para el almacenamiento ligero de contactos y sincronización con el widget.

---

Rubén, si has llegado hasta aquí, espero (por mi bien) por lo menos que hayas tenido tiempo de salir con la moto a despejarte.
