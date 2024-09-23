# TPIYCS
Repositorio para la materia ing y calidad de software
# Sistema de Gestión de la Configuración (SGC)

Este proyecto es un ejemplo de implementación de un sistema de control de versiones utilizando **Git** y **Gitflow** como flujo de trabajo. El proyecto está diseñado para demostrar cómo gestionar versiones, preparar releases, solucionar errores y agregar nuevas funcionalidades de manera controlada.

## Tecnologías Utilizadas

- Lenguaje: Java (puedes especificar otro si utilizas otro lenguaje)
- Sistema de control de versiones: Git
- Flujo de trabajo: Gitflow
- Plataforma: GitHub

## Requisitos

- [Git](https://git-scm.com/) instalado en tu sistema
- Cuenta de [GitHub](https://github.com/)
- (Opcional) [Maven](https://maven.apache.org/) si usas Java
- (Opcional) [Docker](https://www.docker.com/) si implementas contenedores

## Instalación y Configuración

1. Clonar el repositorio en tu máquina local:
    ```bash
    git clone https://github.com/usuario/repo.git
    ```

2. Acceder al directorio del proyecto:
    ```bash
    cd repo
    ```

3. Configurar el archivo `.gitignore` para evitar subir archivos innecesarios al repositorio:
    ```bash
    echo "*.class" >> .gitignore
    echo "/target/" >> .gitignore
    ```

## Flujo de trabajo con Gitflow

Este proyecto sigue el flujo de trabajo **Gitflow**. Los pasos básicos que debes seguir son:

1. **Crear una rama de desarrollo**:
    ```bash
    git checkout -b feature/new-feature
    ```

2. **Hacer modificaciones** en la rama:
    ```bash
    git add .
    git commit -m "Nueva funcionalidad"
    ```

3. **Fusionar los cambios a la rama principal** una vez que estén listos:
    ```bash
    git checkout main
    git merge feature/new-feature
    ```

4. **Publicar los cambios en GitHub**:
    ```bash
    git push origin main
    ```

## Estructura del Proyecto

```bash
├── src/
│   ├── main/
│   └── test/
├── .gitignore
├── README.md
├── pom.xml (si usas Maven)
└── Dockerfile (si usas Docker)
