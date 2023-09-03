## Ejemplos

### Listar usuarios

- **URL**: `/api/users`
- **Método**: `GET`
- **Respuesta exitosa**:

```json
[
    {
        "id": 1,
        "name": "Peter",
        "username": "peter12",
        "email": "peter@gmail.com",
        "phone": "45633212"
    },
    {
        "id": 2,
        "name": "Jhon",
        "username": "jhonf22",
        "email": "jhonf22@gmail.com",
        "phone": "45129632"
    },
    {
        "id": 3,
        "name": "Donny",
        "username": "don8",
        "email": "donny@gmail.com",
        "phone": "63215896"
    }
]
```

### Obtener usuario por ID

- **URL**: `/api/users/:id`
- **Método**: GET
- **Cuerpo de la Solicitud:**

```json
{
    "name": "Donny",
    "username": "don8",
    "email": "donny@gmail.com",
    "phone": "63215896"
}
```

### Crear usuario

- **URL**: `/api/users`
- **Método**: POST
- **Cuerpo de la Solicitud:**

```json
{
    "name": "Donny",
    "username": "don8",
    "email": "donny@gmail.com",
    "phone": "63215896"
}
```

### Actualizar usuario por ID

- **URL**: `/api/users/:id`
- **Método**: PUT
- **Cuerpo de la Solicitud:**

```json
{
    "name": "Donny",
    "username": "don8",
    "email": "donny@gmail.com",
    "phone": "63215896"
}
```

### Eliminar usuario por ID

- **URL**: `/api/users/:id`
- **Método**: DELETE
- **Respuesta exitosa**:

```json
{
    "mensaje": "User :id deleted successfully"
}
```

# Spring Boot, MySQL, JPA, Error Handling, Pagination, Rest API

## Introducción
Bienvenido a la documentación de la API REST. Esta es una API REST básica para administrar clientes. Permite realizar operaciones simples relacionadas con la gestión de clientes. A continuación, encontrarás información detallada sobre cómo utilizar la API, los endpoints disponibles y ejemplos de solicitud y respuesta.

## Configuración
Para utilizar la API REST en tu entorno local, sigue estos pasos:

1. Clona este repositorio: `git clone https://github.com/ale94/rest-api-crud-user-example.git)`
2. Crear base de datos MySQL: `create database db_example`
3. Cambie el nombre de usuario y la contraseña de MySQL según su instalación:
    - open src/main/resources/application.properties
    - change spring.datasource.username and spring.datasource.password as per your mysql installation
4. Compile y ejecute la aplicación usando maven: `mvn spring-boot:run`
5. La aplicación comenzará a ejecutarse en http://localhost:8080.

## Endpoints
- **Listar clientes**: `GET /api/customers`
- **Listar clientes**: `GET /api/customers/page/:page`
- **Obtener cliente por ID**: `GET /api/customers/:id`
- **Crear cliente**: `POST /api/customers`
- **Actualizar cliente por ID**: `PUT /api/customers/:id`
- **Eliminar cliente por ID**: `DELETE /api/customers/:id`
    
## Ejemplos de uso
### Listar clientes

- **URL**: `/api/customers`
- **Método**: `GET`
- **Respuesta exitosa**:

```json
[
    {
        "id": 1,
        "firstName": "Andrés",
        "lastName": "Guzmán",
        "email": "profesor@bolsadeideas.com",
        "createAt": "2018-01-01"
    },
    {
        "id": 2,
        "firstName": "Mr. John",
        "lastName": "Doe",
        "email": "john.doe@gmail.com",
        "createAt": "2018-01-02"
    },
    {
        "id": 3,
        "firstName": "Linus",
        "lastName": "Torvalds",
        "email": "linus.torvalds@gmail.com",
        "createAt": "2018-01-03"
    }
]
```
## Manejo de errores
## Contribuciones
## Contacto

