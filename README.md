💱 Conversor de Divisas
Este proyecto es una aplicación pràctica de consola en Java que permite la conversión de monedas utilizando la ExchangeRate-API. La interfaz gráfica está basada en JOptionPane para capturar la entrada del usuario y mostrar los resultados.

🚀 Características
🌍 Conversión entre Dólar (USD), Euro (EUR), Libra esterlina (GBL) y Peso Colombiano (COP).
🎨 Interfaz gráfica basada en JOptionPane para una experiencia interactiva.
🔗 Comunicación con una API externa para obtener tasas de conversión en tiempo real.
⚙️ Funcionalidades
🔄 Convertir entre USD y EUR, GBL, COP y viceversa.
⚠️ Manejo de errores al ingresar opciones inválidas o valores no numéricos.
💬 Mensajes de finalización amigables y claros cuando el usuario decide cerrar la aplicación.
📁 Archivos principales
Logica.java: Gestiona la lógica principal de la aplicación y presenta el menú de opciones.
Api.java: Realiza la solicitud HTTP a la API de ExchangeRate y maneja la conversión de monedas.
Api.java: Esta clase también muestra al usuario el valor convertido después de ingresar la cantidad.
DatosJson.java: Representa el formato JSON que devuelve la API para la conversión.
FinishProgram.java: Muestra mensajes cuando el programa finaliza o cuando se ingresa una opción inválida.
🛠️ Requisitos
Java 8 o superior.
Dependencia de Gson para deserializar la respuesta JSON de la API.
🌐 Conexión a Internet para acceder a la API de conversión.
📖 Uso
Al iniciar la aplicación, se mostrará un menú con las opciones de conversión disponibles.
Selecciona la conversión que deseas realizar ingresando el número correspondiente.
Ingresa la cantidad de dinero a convertir.
El resultado de la conversión se mostrará en un cuadro de diálogo.
Elige "Cancel" o dale a la "X" en el menú para finalizar la aplicación.
📦 Instalación
Clona el repositorio.
Asegúrate de tener Java instalado en tu sistema.
Importa el proyecto en tu IDE preferido.
Añade la biblioteca Gson a tu proyecto.
Ejecuta la clase Conversor-de-monedas.java para iniciar la aplicación.
🌐 API Utilizada
ExchangeRate-API
Clave de API usada: Se necesita registrar dentro de la pagina y te envìa la API al correo.
Esta API es de uso personal y solamente para pruebas.
👤 Autor
Proyecto desarrollado por Luis Urrego.
