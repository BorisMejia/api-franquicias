# 🚀 Guía de Instalación - API Franquicias

> Guía simple y directa para instalar y ejecutar el proyecto

---

## 📋 Requisitos

- **Java 17+**
- **Docker Desktop**
- **Git**

## 📚 Tecnologías

- Spring Boot 3.5.4 + WebFlux
- R2DBC PostgreSQL
- Docker + Docker Compose
- Clean Architecture
- AWS RDS

---

Verificar instalaciones:
```powershell
java -version
docker --version
git --version
```

---

## 🔧 Instalación

### 1. Clonar el Proyecto

```powershell
git clone https://github.com/BorisMejia/api-franquicias.git
cd api-franquicias
```

### 2. Configurar Base de Datos

Edita el archivo `.env`:

```bash
# Para Docker (usa el nombre del servicio)
DB_HOST=postgres
DB_PORT=5432
DB_NAME=franquicia_db
DB_USERNAME=franquicia_user
DB_PASSWORD=franquicia_pass

# Para AWS RDS (cambiar por tu endpoint real)
# DB_HOST=tu-instancia.region.rds.amazonaws.com
# DB_PASSWORD=tu_password_real
```

> **Nota:** Si no defines estas variables, se usarán los valores por defecto (localhost, franquicia_db, etc.)

#### ⚠️ Configuración SSL (Importante)

**Para desarrollo local con Docker:**
- Deja **comentada** la línea de SSL en `PostgreSQLConnectionPool.java`:
```java
//                .sslMode(SSLMode.REQUIRE)
```

**Para conectar a AWS RDS:**
- **Descomenta** la línea de SSL en `PostgreSQLConnectionPool.java`:
```java
                .sslMode(SSLMode.REQUIRE)
```

> **Ubicación del archivo:** `infrastructure/driven-adapters/r2dbc-postgresql/src/main/java/co/com/franquicias/r2dbc/config/PostgreSQLConnectionPool.java`

### 3. Compilar el Proyecto


```powershell
.\gradlew clean build -x test
```

Verifica que se generó el JAR:
```powershell
ls applications\app-service\build\libs\api-franquicias.jar
```

### 4. Ejecutar con Docker

```powershell
docker-compose up --build
```

---

## ✅ Verificación

```powershell
# Ver logs
docker-compose logs -f api-franquicia

# Probar health
curl http://localhost:8080/actuator/health

# Probar API swagger
http://localhost:8080/swagger
```

**Swagger:** http://localhost:8080/swagger

---

## 🛠️ Comandos Útiles

```powershell
# Detener
docker-compose down

# Ver logs
docker-compose logs -f

# Reiniciar
docker-compose restart

# Ver contenedores
docker ps
```

---

## 📌 Endpoints Principales

```http

POST     /franquicia/register
PATCH    /franquicia/update
POST     /franquicia/get-producto-max-stock

POST     /franquicia/sucursal/register
PATCH    /franquicia/sucursal/update

POST     /franquicia/sucursal/producto/create
DELETE   /franquicia/sucursal/productos/delete
PATCH    /franquicia/sucursal/productos/update-stock
PATCH    /franquicia/sucursal/productos/update-nombre-producto
```

---

## 🔍 Solución de Problemas

### Puerto 8080 en uso
```powershell
netstat -ano | findstr :8080
taskkill /PID <PID> /F
docker-compose up -d
```

### Error de conexión a BD
```powershell
docker-compose down
docker-compose up -d postgres
# Esperar 10 segundos
docker-compose up -d api-franquicia
```

### Recompilar desde cero
```powershell
docker-compose down -v
.\gradlew clean build -x test
docker-compose build --no-cache
docker-compose up -d
```

---


## 📞 Repositorio

**GitHub:** https://github.com/BorisMejia/api-franquicias

---

**✅ Listo!** La API está corriendo en http://localhost:8080/swagger
