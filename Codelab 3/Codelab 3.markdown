### ¿Cuál es el propósito principal de Clean Architecture en el desarrollo de software?

El propósito principal de **Clean Architecture** es lograr una estructura de software **modular, mantenible y escalable**, mediante la separación de responsabilidades entre las diferentes capas del sistema. Busca que:

- La lógica de negocio (dominio) esté **aislada de detalles técnicos** como frameworks, bases de datos o controladores.
- El código sea **fácil de probar y modificar**, sin que un cambio en la infraestructura afecte el núcleo del negocio.
- Se facilite la reutilización, la inversión de dependencias y el cumplimiento de principios SOLID.
- Cada capa tenga una **única responsabilidad** y dependa solo de abstracciones.

Esto permite construir sistemas que resisten mejor al paso del tiempo y al cambio de tecnologías.

### ¿Qué beneficios aporta Clean Architecture a un microservicio en Spring Boot?

Aplicar Clean Architecture en un microservicio con Spring Boot aporta varios beneficios:

- **Separación de responsabilidades**: Cada capa (dominio, aplicación, infraestructura, presentación) tiene un propósito claro, lo que facilita la organización del código.
- **Desacoplamiento**: La lógica de negocio no depende de frameworks ni de detalles técnicos como JPA o controladores REST, lo que permite cambiar tecnologías sin afectar el núcleo del sistema.
- **Escalabilidad**: Al tener casos de uso independientes, es más fácil agregar nuevas funcionalidades sin romper lo existente.
- **Mantenibilidad**: El código es más fácil de entender, modificar y extender.
- **Reusabilidad**: Las reglas de negocio pueden ser reutilizadas en otros contextos sin la necesidad de duplicar código y lógica.
- **Testabilidad**: Las capas internas se pueden probar sin necesidad de cargar infraestructura pesada.

### ¿Cuáles son las principales capas de Clean Architecture y qué responsabilidad tiene cada una?

Clean Architecture se organiza en cuatro capas principales, cada una con una responsabilidad clara:

1. **Dominio (Enterprise Business Rules)**  
   - Contiene las entidades y objetos de valor con las reglas de negocio más puras.  
   - No depende de frameworks, bases de datos ni tecnologías externas.

2. **Aplicación (Application Business Rules)**  
   - Define los casos de uso del sistema y orquesta la lógica entre entidades y servicios.  
   - Usa interfaces (puertos) y no se acopla a la infraestructura.

3. **Infraestructura (Adapters & Frameworks)**  
   - Implementa los detalles técnicos: repositorios JPA, integración con APIs externas, bases de datos, etc.  
   - Contiene la configuración de Spring Boot y adaptadores concretos.

4. **Presentación (Delivery Mechanisms)**  
   - Gestiona la entrada y salida de datos, como controladores REST.
   - Se encarga de la serialización, validación, autenticación y autorización.

Cabe destacar que capa depende solo de la capa inmediatamente interna, promoviendo el principio de inversión de dependencias.


### ¿Por qué se recomienda desacoplar la lógica de negocio de la infraestructura en un microservicio?

Se recomienda desacoplar la lógica de negocio de la infraestructura para mantener un sistema **modular, mantenible y adaptable** al cambio. Esto ayuda a: 

- **Evitar dependencias rígidas**: La lógica de negocio no debe depender de frameworks, bases de datos ni tecnologías específicas. Esto permite cambiar tecnologías sin afectar las reglas del negocio.
  
- **Facilitar las pruebas**: Al no depender de infraestructura, los casos de uso se pueden probar con mocks, sin necesidad de arrancar toda la aplicación.
  
- **Mejor mantenimiento y evolución**: Cambiar la base de datos, el sistema de mensajería o la forma de exponer APIs es más sencillo si la lógica de negocio está desacoplada.
  
- **Claridad y separación de responsabilidades**: Cada capa cumple una función específica. Esto reduce la complejidad y aumenta la comprensión del código.
  
- **Reutilización**: Las reglas de negocio pueden reutilizarse en otros contextos (por ejemplo, en otro microservicio o interfaz) sin duplicarlas.

### ¿Cuál es el rol de la capa de aplicación y qué tipo de lógica debería contener?

La **capa de aplicación**  tiene como rol principal **orquestar los casos de uso** del sistema, conectando la lógica del dominio con la infraestructura sin tener en cuenta detalles más técnicos.

Debe contener:

- **Casos de uso**: Representan acciones específicas del negocio, como listar productos, o registrar pedidos.
- **Servicios de aplicación**: Coordinan el flujo entre entidades del dominio y adaptadores externos.
- **Interfaces (puertos)**: Para comunicarse con repositorios o servicios sin depender de implementaciones concretas.

Esta capa no debe contener lógica de persistencia, controladores ni detalles de frameworks. Su función es organizar la lógica de aplicación, aplicando las reglas del dominio y delegando la implementación técnica a otras capas de la app.

### ¿Qué diferencia hay entre un UseCase y un Service en Clean Architecture?

En Clean, la diferencia entre un **UseCase** y un **Service** radica en su ubicación y propósito dentro de la arquitectura:

- **UseCase**: 
  - Se ubica en la **capa de aplicación**.
  - Representa una **acción específica del negocio**, como listar productos o registrar un pedido.
  - Define la lógica entre el dominio y la infraestructura, sin depender de detalles técnicos.
  - Contiene lógica de aplicación que responde a una necesidad del usuario o sistema.

- **Service**:
  - Puede existir tanto en la **capa de dominio** (para lógica de negocio compleja y reutilizable) como en la **infraestructura** (para servicios técnicos como enviar correos o acceder a la base de datos).
  - En la capa de dominio, encapsula reglas de negocio puras.
  - En la infraestructura, implementa interfaces usadas por los casos de uso.

Esto nos indica que: 
- El **UseCase** coordina una operación del sistema (qué hacer).
- El **Service** implementa una parte de esa operación (cómo se hace), dependiendo de su capa.

### ¿Por qué se recomienda definir Repositories como interfaces en la capa de dominio en lugar de usar directamente JpaRepository?

Esto se hace para seguir los principios de **desacoplamiento** y **inversión de dependencias** de Clean Architecture. Las razones son:

- **Evitar acoplamiento con JPA o frameworks**: JpaRepository pertenece a Spring Data, que es parte de la infraestructura. Si se usa directamente en la lógica de negocio, se rompe la independencia del dominio.

- **Facilitar pruebas y simulaciones**: Al usar interfaces, es fácil sustituir la implementación concreta por mocks en pruebas unitarias.

- **Cumplir con el principio de inversión de dependencias (D de SOLID)**: El dominio no debe depender de detalles técnicos, sino que la infraestructura debe implementar lo que el dominio necesita.

- **Mayor flexibilidad**: Si en el futuro se cambia la base de datos, solo se modifica la implementación en la infraestructura, no el dominio.

### ¿Cómo se implementa un UseCase en un microservicio con Spring Boot y qué ventajas tiene?


```java
// domain/model/Producto.java
public class Producto {
    private Long id;
    private String nombre;
    private double precio;
    // Getters y setters
}

// domain/repository/ProductoRepository.java
public interface ProductoRepository {
    List<Producto> findAll();
}

2. **Definir el modelo y repositorio en la capa de dominio:**

@Service
public class ListarProductosUseCase {
    private final ProductoRepository productoRepository;

    public ListarProductosUseCase(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> ejecutar() {
        return productoRepository.findAll();
    }
}

3. Implementar el caso de uso:
// application/usecase/ListarProductosUseCase.java
@Service
public class ListarProductosUseCase {
    private final ProductoRepository productoRepository;

    public ListarProductosUseCase(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> ejecutar() {
        return productoRepository.findAll();
    }
}

4. Implementar el repositorio en la capa de infraestructura:
// infrastructure/persistence/ProductoRepositoryImpl.java
@Repository
public class ProductoRepositoryImpl implements ProductoRepository {
    private final JpaProductoRepository jpaProductoRepository;

    public ProductoRepositoryImpl(JpaProductoRepository jpaProductoRepository) {
        this.jpaProductoRepository = jpaProductoRepository;
    }

    @Override
    public List<Producto> findAll() {
        return jpaProductoRepository.findAll();
    }
}

5. Implementar el controlador en la capa de presentación:
// delivery/ProductoController.java
@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ListarProductosUseCase listarProductosUseCase;

    public ProductoController(ListarProductosUseCase listarProductosUseCase) {
        this.listarProductosUseCase = listarProductosUseCase;
    }

    @GetMapping
    public List<Producto> obtenerProductos() {
        return listarProductosUseCase.ejecutar();
    }
}

```

# ¿Qué problemas podrían surgir si no aplicamos Clean Architecture en un proyecto de microservicios?

1. **Acoplamiento excesivo**  
   Si la lógica de negocio depende directamente de frameworks, controladores o bases de datos, si se cambia la tecnología habrá problemas de compatibilidad, y esto representa modificación en muchas partes del sistema.

2. **Dificultad para realizar pruebas**  
   Al no tener separación de responsabilidades, los tests se vuelven complejos y lentos, ya que deben levantar componentes innecesarios como controladores o acceso a datos.

3. **Baja mantenibilidad**  
   Sin una estructura clara, es difícil entender dónde hacer cambios o cómo agregar nuevas funcionalidades sin romper el código.

4. **Duplicación de lógica**  
   La falta de una capa de aplicación (UseCases) puede llevar a la duplicación de código en múltiples componentes.

5. **Problemas de escalabilidad**  
   Con el crecimiento del sistema, el código mal estructurado se vuelve difícil de extender, afectando la capacidad del equipo para agregar nuevos microservicios o escalar los existentes.

6. **Difícil adaptación tecnológica**  
   Si el acceso a la base de datos está mezclado con la lógica de negocio, cambiar de motor de base de datos o de ORM requiere reescribir una buena parte del código.

7. **Violación del principio de responsabilidad única (SRP)**  
   Las clases tienden a hacer demasiado: consultar datos, aplicar lógica de negocio, manejar excepciones, etc, esto las hace más frágiles y difíciles de mantener.

# ¿Cómo Clean Architecture facilita la escalabilidad y mantenibilidad en un entorno basado en microservicios?

Clean Architecture facilita la escalabilidad y la mantenibilidad en un entorno de microservicios porque separa claramente las responsabilidades del sistema en capas independientes.

- **Escalabilidad**: Al estar bien organizado, cada microservicio puede crecer de forma independiente. Es posible agregar nuevas funcionalidades creando nuevos casos de uso o módulos sin tocar lo que ya funciona.

- **Mantenibilidad**: Al tener una estructura clara, es más sencillo identificar dónde hacer cambios. Por ejemplo, si se necesita modificar una regla de negocio, se hace en la capa de aplicación o dominio sin tocar controladores o la base de datos.

- **Pruebas más fáciles**: Al no depender directamente de frameworks o bases de datos, se pueden hacer pruebas unitarias sobre la lógica de negocio sin necesidad de configurar todo el entorno.

- **Reemplazo de tecnología sin impacto mayor**: Si se cambia de base de datos o se actualiza un framework, los cambios se hacen solo en la capa de infraestructura, sin afectar la lógica central.

