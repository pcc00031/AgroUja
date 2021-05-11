# CHANGELOG - AGROUJA

## [1.0.0] - 2021-05-15
#### Added

- Agregados productos destacados a la página principal - @pcc00031
- Integración de AngularJS Material - @pcc00031 , @cmp00070 , @jgr00059 , @cga00037
- Mensajes de error y ventanas emergentes para operaciones con Producto agregados - @pcc00031
- Mensajes de error y ventanas emergentes para operaciones con Usuario agregados - @jgr00059
- Mensajes de error y ventanas emergentes para operaciones con Formulario agregados - @cga00037
- Mensajes de error y ventanas emergentes para operaciones con Comentario agregados - @cmp00070
- Implementación de servicios REST
- Conexiones asíncronas con el servidor
- Comprobación de favoritos añadidos por un usuario establecida - @cmp00070  

### Fixed

- Relación de Favoritos corregida, Entidad Favorito creada - @cmp00070
- Relaciones entre entidades corregidas - @cmp00070
- Entidad Comentario corregida - @pcc00031
- Filtrado de productos corregido - @pcc00031

## [0.0.4] - 2021-05-03
#### Added

- Relaciones entre entidades (claves foráneas implementadas) - @pcc00031 , @cmp00070 , @jgr00059 , @cga00037
- Añadidas listas ocultas con acceso solo para administradores - @cga00037
- Entidad Comentario agregada + métodos JPA - @pcc00031
- Relación de Comentario con las demás entidades - @pcc00031
- Asignación de productos a Usuarios - @pcc00031
- Ocultación de métodos para que sólo el usuario que posee ese producto pueda borrar/editar - @pcc00031
- Asignación de formularios a Usuarios - @cga00037
- Asignación de comentarios a Productos y Usuarios - @pcc00031 
- Añadidos métodos de edición y borrado de fomularios - @cga00037
- Añadidos métodos generales de Comentario - @pcc00031
- Agregadas fotos de perfil a Administradores - @pcc00031 , @cmp00070 , @jgr00059 , @cga00037

### Fixed

- Botón para hacer logout - @pcc00031
- Autenticación implementada en el back-end - @pcc00031 , @cmp00070 , @jgr00059 , @cga00037
- Restricción de vistas para usuarios y administradores (comprobaciones previas) - @pcc00031 , @cmp00070 , @jgr00059 , @cga00037
- Registro de usuario solucionado - @jgr00059
- Validación en formularios de contacto agregada - @cga00037
- Optimizado bean de usuario - @pcc00031
- Editar y borrar de Usuario solucionados - @cmp00070
- Vista de mostrar usuario mejorada visualmente - @pcc00031 , @cmp00070
- Corrección general y optimizado de métodos - @pcc00031 , @cmp00070 , @jgr00059 , @cga00037
- Vista principal de la aplicación mejorada visualmente (index) - @pcc00031

### To Do

- Métodos JPA en productos de filtrado - @pcc00031

## [0.0.3] - 2021-04-19
#### Added

- clases java: ProductosDAOJpa & ProductosDAOMap - @pcc00031
- clases java: UsuarioDAOJpa & UsuarioDAOMap - @cmp00070 
- clases java: FormularioDAOJpa, FormularioDAOMap - @cga00037
- clases java: UsuarioIdentityStore, UsuarioLoginController, AppConfig - @jgr00059
- Implementación de security-role y security-constraint para control de acceso a recursos en web.xml - @jgr00059
- Implementación de formulario estándar de autenticación en vista login.xhtml - @jgr00059
- qualifiers: DAOJpa & DAOMap - @pcc00031 , @cmp00070 , @jgr00059 , @cga00037

### Fixed

- Organización paquetes AgroUja - @pcc00031 , @cmp00070 , @jgr00059 , @cga00037
- Corrección clases .java correspondientes a Usuario - @cmp00070
- Cambio de nombre FormularioController -> ContactoController - @cga00037
- Atributos excesivos de ProductoController pasados al bean de Productos - @pcc00031
- SelectOneMenu & SelecOneView eliminadas - @pcc00031 , @cmp00070 , @jgr00059 , @cga00037
- Creación de usuario corregida - @cmp00070

### To Do

- Algunos métodos JPA en productos - @pcc00031

## [0.0.2] - 2021-04-05
#### Added

- clases java: Producto, ProductosDAO & ProductosController - @pcc00031
    - Buscar por nombre, marca y categoría
    - Alta, borrado y edición de producto
    - 8 productos agregados
    - Agregar comentarios a un producto
- clases java: Usuario, UsuariosDAO & UsuariosController - @cmp00070 , @jgr00059
    - Alta, borrado, edición y recuperación de cuenta
    - 4 usuarios agregados
- clases java: Formulario, FormulariosDAO & FormulariosController - @cga00037
    - Crear y visualizar formularios

### Fixed

- correcto uso de etiquetas semánticas
- carousel de la página principal
- apartados visuales: posicionamiento de header y footer

## [0.0.1] - 2021-03-22
#### Added

- algunas clases java auxiliares - @cga00037, @cmp00070
- vista principal de productos (/productos/index) - @pcc00031
- vista de agregar producto (/productos/agregar) - @pcc00031
- vista de ver producto (/productos/visualizar) - @pcc00031
- vista principal (/index) - @cmp00070
- vista de registro (/registro) - @cmp00070
- vista de iniciar sesión (/login) - @cmp00070
- vista de contacto (/contacto) - @cga00037
- vista de editar producto (/productos/editar) - @cga00037
- vista visualizar usuario (/usuario/index)- @jgr00059
- vista de editar usuario (/usuario/editar) - @jgr00059
- layouts y archivos .css - @pcc00031 , @cmp00070 , @cga00037 , @jgr00059

### Fixed

- solapamiento de funciones .css
- apartados visuales 


