Mini-App Final — Técnicas de Producción Industrial de Software I

Profesor: Juan José Santos
Estudiante: Stefany Hernández
Fecha: 07/12/2025
Reto elegido: # VisitApp — Registro de visitas (Check-in / Check-out)


## 📌 Descripción del proyecto

VisitApp es una aplicación móvil diseñada para gestionar el registro de visitas dentro de instalaciones, oficinas o instituciones educativas.
Permite realizar check-in y check-out de visitantes, almacenando información como nombre, hora de entrada, hora de salida y motivo de visita.
Está dirigida a recepcionistas o personal administrativo que necesita un control simple, rápido y digital de las entradas y salidas.
El proyecto resuelve el problema de depender de registros manuales en papel, reduciendo errores humanos y facilitando la consulta de historial.

## 🛠️ Tecnologías utilizadas

-Kotlin
-Android Studio (versión recomendada: Flamingo / Hedgehog)
-Jetpack Compose
-Navigation Compose
-Room (persistencia local)
-ViewModel + StateFlow


## 📂 Estructura del proyecto

El proyecto sigue una arquitectura simple basada en separación por capas:
-data/ → Entidades, DAOs y base de datos Room.
-ui/ → Componentes visuales reutilizables en Compose.
-ui.screens/ → Pantallas principales: listado, formulario, check-in, check-out.
-viewmodel/ → Lógica de negocio, manejo de estado y comunicación con data/.

## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio: git clone https://github.com/stefanyhndz/App-de-registro-de-visitas-check-in-check-out-.git
2. Abrir la carpeta del proyecto en Android Studio.
3. Permitir que Gradle sincronice automáticamente.
4. Ejecutar la app en un emulador o dispositivo físico.
5. Room generará la base de datos local al iniciar la app.

## 📜 Checklist de entrega
- [ ] App compila correctamente  
- [ ] Persistencia implementada  
- [ ] Navegación funcional  
- [ ] Video grabado con rostro visible  
- [ ] README completo  
- [ ] Repositorio con al menos 5 commits  
- [ ] Carpeta OneDrive creada y compartida  

**💡 Mejoras futuras**

-Exportar historial de visitas a PDF o Excel.
-Agregar autenticación para administradores.
-Implementar filtros y búsqueda avanzada.
-Sincronización en la nube para múltiples dispositivos.
-Notificaciones para recordar check-out pendiente.
