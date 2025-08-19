# Foro Hub - API REST

Proyecto desarrollado en **Spring Boot** como parte del curso de Alura.  
El objetivo es implementar un **foro de discusión** con autenticación JWT, manejo de tópicos y usuarios.

---

## 🚀 Tecnologías utilizadas
- Java 17+
- Spring Boot 3
- Spring Web
- Spring Security
- Spring Data JPA + Hibernate
- Base de datos MySQL / H2 (dependiendo de la configuración)
- JWT (JSON Web Token)
- Maven

---

## 📌 Funcionalidades principales
- **Autenticación con JWT**
  - Endpoint `/login` para obtener el token.
  - Validación automática de peticiones con `Bearer Token`.

- **Gestión de tópicos**
  - Crear nuevos tópicos.
  - Consultar tópicos por ID.
  - Listar tópicos con filtros (`curso`, `año`).
  - Actualizar información de un tópico.
  - Borrado lógico (soft delete).

- **Usuarios**
  - Registro de usuarios con contraseñas encriptadas con **BCrypt**.
  - Autenticación vía **Username y Password**.

---

## ⚙️ Configuración del proyecto

### 1. Clonar repositorio
```bash
git clone https://github.com/Honor91/Alura-hub.git
cd foro_hub
