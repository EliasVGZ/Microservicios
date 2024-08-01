# Microservicios con Spring Boot - Proyecto de Práctica 🚀

Este repositorio contiene un mini proyecto de práctica de microservicios desarrollado con **Spring Boot**. El proyecto está inspirado y guiado por el contenido del canal de YouTube [La Tecnología Avanza](https://www.youtube.com/@latecnologiaavanza).

## 📄 Descripción

El proyecto consta de tres microservicios independientes que se comunican entre sí utilizando **FeignClient** y **RestTemplate**:

1. **👤 Usuario Service:** Gestiona la información de los usuarios.
2. **🚗 Carro Service:** Gestiona la información de los coches.
3. **🏍️ Moto Service:** Gestiona la información de las motos.

Estos servicios permiten realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y están diseñados para interactuar entre ellos, ofreciendo una práctica completa de integración de microservicios.

## 🛠️ Tecnologías y Herramientas

- **☕ Spring Boot**
- **🌩️ Spring Cloud OpenFeign**
- **🔄 Spring RestTemplate**
- **🗄️ H2 Database (opcional)** para persistencia de datos
- **📦 Maven** para la gestión de dependencias
- **💻 IntelliJ IDEA** como entorno de desarrollo integrado (IDE)

## 📂 Estructura del Proyecto

- `👤 usuario-service`: Servicio para la gestión de usuarios.
- `🚗 carro-service`: Servicio para la gestión de coches.
- `🏍️ moto-service`: Servicio para la gestión de motos.

Cada microservicio tiene su propio conjunto de endpoints y se comunican entre sí para cumplir con los requisitos del negocio.

## 🔗 Uso de FeignClient y RestTemplate

- **🌐 FeignClient:** Se utiliza para la comunicación entre los microservicios `usuario-service` y `carro-service`, así como `usuario-service` y `moto-service`.
- **🔀 RestTemplate:** También se utiliza como alternativa para realizar llamadas HTTP entre microservicios, lo que permite comparar ambos enfoques y entender sus diferencias.

## 🎓 Créditos

Este proyecto ha sido desarrollado como parte de las prácticas propuestas por el canal de YouTube **[La Tecnología Avanza](https://www.youtube.com/@latecnologiaavanza)**, donde se exploran conceptos fundamentales y avanzados de microservicios con Spring Boot.

---

<p align="center">
  <img src="https://img.icons8.com/clouds/100/000000/github.png" alt="GitHub"/>
</p>
