# Spring Boot, MySQL, JPA, Error Handling, Pagination, Rest API

## Introducción
Bienvenido a la documentación de la API REST. Esta es una API REST básica para administrar clientes. Permite realizar operaciones simples relacionadas con la gestión de clientes. A continuación, encontrarás información detallada sobre cómo utilizar la API, los endpoints disponibles y ejemplos de solicitud y respuesta.

## Configuración
Para utilizar la API REST en tu entorno local, sigue estos pasos:

1. Clona este repositorio: `https://github.com/ale94/rest-api-crud-customer.git`
2. Crear base de datos MySQL: `create database db_example`
3. Cambie el nombre de usuario y la contraseña de MySQL según su instalación:
    - open src/main/resources/application.properties
    - change spring.datasource.username and spring.datasource.password según su instalación de MySQL
4. Compile y ejecute la aplicación usando maven: `mvn spring-boot:run`
5. La aplicación comenzará a ejecutarse en http://localhost:8080.

## Endpoints
- **Listar clientes**: `GET /api/customers`
- **Listar clientes por paginación**: `GET /api/customers/page/:page`
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

### Listar clientes por paginación

- **URL**: `/api/customers/page/:page`
- **Método**: `GET`
- **Respuesta exitosa**:

```json
{
    "content": [
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
    },
    {
        "id": 4,
        "firstName": "Rasmus",
        "lastName": "Lerdorf",
        "email": "rasmus.lerdorf@gmail.com",
        "createAt": "2018-01-04"
    }
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 4,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalElements": 11,
    "totalPages": 3,
    "size": 4,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 4,
    "empty": false
}
```

### Obtener cliente por ID

- **URL**: `/api/customer/:id`
- **Método**: GET
- **Cuerpo de la Solicitud:**

```json
{
    "id": 12,
    "firstName": "Jade",
    "lastName": "Doe",
    "email": "jane.doe@gmail.com",
    "createAt": "2018-03-06"
}
```

### Crear cliente

- **URL**: `/api/customer`
- **Método**: POST
- **Cuerpo de la Solicitud:**

```json
{
    "firstName": "Jade",
    "lastName": "Doe",
    "email": "jane.doe@gmail.com",
    "createAt": "2018-03-06"
}
```

### Actualizar cliente por ID

- **URL**: `/api/customer/:id`
- **Método**: PUT
- **Cuerpo de la Solicitud:**

```json
{
    "firstName": "Jade",
    "lastName": "Doe",
    "email": "jane.doe@gmail.com",
    "createAt": "2018-03-06"
}
```

### Eliminar cliente por ID

- **URL**: `/api/customer/:id`
- **Método**: DELETE
- **Respuesta exitosa**:

```json
{
    "message": "The customer has been successfully deleted"
}
```

