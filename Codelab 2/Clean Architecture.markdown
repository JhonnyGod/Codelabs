### 1. ¿Qué es Attribute-Driven Design (ADD) y cuál es su propósito en el diseño de software?

Es un método que se centra en los atributos de calidad, como rendimiento, escalabilidad, seguridad, entre otros del sistema. Su proposito es guiar el proceso de diseño tomando decisiones en base a los atributos previamente mecionados, así como también en los requerimientos funcionales y las restricciones.

ADD descompone el sistema en subsistemas o módulos, eligiendo estilos arquitectónicos, patrones y tecnologías que permitan satisfacer los atributos de calidad definidos.

#### Objetivos clave de ADD:
- Alinear la arquitectura con los requisitos no funcionales (atributos de calidad).
- Producir una estructura comprensible del sistema.
- Tomar decisiones de diseño fundamentadas y en base a los requerimientos.

## 2. ¿Cómo se relaciona ADD con Clean Architecture en el proceso de diseño de sistemas?

Mientras que ADD determina la toma de decisiones sobre que arquitectura se debe aplicar, como por ejemplo el uso de capas, microservicios, entre otros, Clean Architecture indica una forma de estructurar el sistema resultante, maximizando la mantenibilidad, testabilidad y la claridad del sistema.

## 3. ¿Cuáles son los pasos principales del método ADD para definir una arquitectura de software?

#### **1. Definir los atributos de calidad y restricciones**  
**Metodología ADD**  

- Identificar los requisitos del sistema.
- Definir atributos de calidad prioritarios (por ejemplo: rendimiento, seguridad, disponibilidad).
- Establecer restricciones tecnológicas (por ejemplo: uso de microservicios, base de datos SQL, etc.).

---

#### **2. Diseñar la arquitectura con base en atributos de calidad**  
**Metodología ADD**  
- Seleccionar tácticas arquitectónicas para cada atributo de calidad:
  - Rendimiento: caching, consultas optimizadas.
  - Seguridad: autenticación, encriptación.
  - Escalabilidad: balanceadores de carga, autoescalado.
- Establecer los módulos principales del sistema.
- Definir la interacción entre componentes (por ejemplo: cómo se comunican los servicios, si hay orquestadores, etc.).

---

#### **3. Implementar siguiendo Clean Architecture**  

**Metodología Clean Architecture**  

- Organizar el código en capas bien definidas:
  - **Dominio**: entidades y lógica de negocio.
  - **Aplicación**: casos de uso.
  - **Infraestructura**: acceso a datos, frameworks, servicios externos.
  - **Presentación**: API REST, UI, controladores.
- Aplicar la inversión de dependencias: las capas internas no deben depender de las externas; se usan interfaces para abstraer la infraestructura.

---

#### **4. Validar y refinar la arquitectura**  
**Metodología ADD + Clean Architecture**  

- Evaluar si la implementación cumple con los atributos de calidad definidos.
- Aplicar revisiones de arquitectura.
- Optimizar tácticas, código y modularización si es necesario (por ejemplo: mejorar tiempos de respuesta, agregar caching, refactorizar módulos).

## 5. ¿Cómo se identifican los atributos de calidad en ADD y por qué son importantes?

#### ¿Cómo se identifican?
Los atributos de calidad se identifican al inicio del proceso arquitectónico mediante:

- **Análisis de los requisitos del sistema** (funcionales y no funcionales).
- **Entrevistas** con stakeholders (clientes, usuarios, desarrolladores, etc.).
- **Revisión de normativas** del dominio (por ejemplo, requisitos legales, de seguridad, rendimiento).
- **Definición de los atributos que se esperan del sistema** como por ejemplo:
  - *Disponibilidad*: “El sistema debe estar disponible el 99.9% del tiempo”
  - *Rendimiento*: “Las respuestas deben generarse en menos de 2 segundos.”
  - *Seguridad*: “Los datos sensibles deben estar cifrados.”

---

#### ¿Por qué son importantes?
- **Determinan las decisiones**: Permiten seleccionar tácticas, patrones y tecnologías adecuadas.
- **Permiten priorizar**: Ayudan a enfocar el diseño en lo que realmente importa y se espera del sistema.
- **Evitan fallos críticos**: Ignorar atributos como rendimiento o seguridad puede llevar a fallas graves en producción.
- **Sirven como criterios de validación**: Son usados posteriormente para evaluar si la arquitectura cumple.

### 5. ¿Por qué Clean Architecture complementa ADD en la implementación de una solución?

Clean Architecture complementa ADD porque traduce las decisiones arquitectónicas tomadas durante el diseño en un codigo claro y mantenible.

Mientras ADD se enfoca en definir qué componentes va a necesitar el sistema y qué atributos de calidad deberían cumplirse (como rendimiento, seguridad o disponibilidad), Clean Architecture organiza esos componentes en capas separadas, respetando principios como la inversión de dependencias y la separación de responsabilidades.

Esto permite que el sistema sea más fácil de probar y mantener ya que la lógica de negocio queda aislada de detalles como frameworks o bases de datos. En conjunto, ADD guía el *qué* diseñar y Clean Architecture define el *cómo* implementarlo.

## 6. ¿Qué criterios se deben considerar al definir las capas en Clean Architecture en un proceso ADD?

Al integrar Clean en un proceso ADD las capas deben definirse considerando lo siguiente:

1. Cada capa debe tener un propósito claro: 
   - Dominio: lógica y reglas del negocio.
   - Aplicación: coordinación de casos de uso.
   - Infraestructura: detalles técnicos (bases de datos, servicios externos).
   - Presentación: interfaz de usuario o API.

2. Independencia tecnológica:
 Las decisiones sobre frameworks, bases de datos o librerías deben quedar fuera del dominio y la aplicación. Esto permite cambiar herramientas sin afectar la lógica principal.

3.  Las capas internas (dominio y aplicación) no deben depender de las externas. Se deben usar interfaces para las mismas.

4. Atributos de calidad: Se debe facilitar cumplir los atributos de  calidad identificados, como la seguridad, rendimiento, escalabilidad y mantenibilidad de cada capa.

5. Trazabilidad con las decisiones arquitectónicas de ADD:  
   La estructura de capas debe reflejar y soportar las decisiones tomadas durante el diseño, como modularización, puntos de integración, y flujos de datos.

### 7. ¿Cómo ADD ayuda a tomar decisiones arquitectónicas basadas en necesidades del negocio?

1. **Traduce necesidades del negocio en atributos técnicos**  
   Las expectativas del negocio (como rapidez, confiabilidad o seguridad) se transforman en atributos medibles, aplicables al proyecto.

2. **Prioriza según el contexto del negocio**  
   No todos los atributos son igual de importantes. ADD permite enfocarse en lo que realmente es relevante para el negocio, como disponibilidad y seguridad del sistema.

3. **Guía la elección de tácticas y patrones adecuados**  
   Una vez identificados los atributos prioritarios, ADD orienta la selección de estrategias concretas que aseguren su cumplimiento, como el uso de balanceadores de carga y autenticación robusta.
4. **Facilita justificar decisiones técnicas**  
   Las decisiones se toman  en base a las necesidades del negocio y su impacto esperado, lo que mejora la comunicación con stakeholders y la trazabilidad del diseño.

### 8. ¿Cuáles son los beneficios de combinar ADD con Clean Architecture en un sistema basado en microservicios?

Combinar ADD con Clean Architecture en un sistema de microservicios ofrece beneficios clave que mejoran tanto el diseño como la implementación del sistema.


#### 1. **Diseño centrado en requisitos del negocio**
ADD permite definir cada microservicio en función de atributos de calidad específicos (como rendimiento, disponibilidad o seguridad), alineando el diseño con los objetivos del negocio.


#### 2. **Modularidad y responsabilidad clara**
Clean Architecture asegura que cada microservicio tenga capas bien definidas, lo que facilita entender, mantener y escalar cada servicio por separado.

#### 3. **Independencia y despliegue autónomo**
Gracias al enfoque de Clean Architecture, cada microservicio puede desarrollarse, probarse y desplegarse de forma independiente, respetando los principios de desacoplamiento promovidos por ADD.


#### 4. **Adaptabilidad a cambios tecnológicos**
La separación por capas permite reemplazar tecnologías (por ejemplo, la base de datos o el framework web) sin afectar la lógica de negocio, lo cual es clave en entornos distribuidos y en constante evolución.


#### 5. **Mejora en la calidad y mantenibilidad del código**
La aplicación de tácticas desde ADD junto con las buenas prácticas de Clean Architecture resulta en código más limpio, testeable, y alineado con los atributos de calidad esperados.

### 9. ¿Cómo se asegura que la arquitectura resultante cumpla con los atributos de calidad definidos en ADD?

Para garantizar que la arquitectura cumple con los atributos de calidad definidos (como rendimiento, seguridad o disponibilidad), el proceso ADD incluye una fase de validación y mejora continua. 

#### 1. Evaluaciones constantes  
Durante el desarrollo, se revisa si el diseño realmente responde a lo que se planteó al inicio. Se hacen revisiones de arquitectura y se analiza si se están cumpliendo los objetivos de calidad.


#### 2. Pruebas orientadas a calidad  
Se aplican pruebas específicas según cada atributo. Por ejemplo:
- Para rendimiento, se hacen pruebas de carga para medir tiempos de respuesta.
- Para disponibilidad, se simulan caídas para ver cómo reacciona el sistema.
- Para seguridad, se buscan vulnerabilidades y se validan los mecanismos de protección.


#### 3. Detectar y resolver problemas  
Si algo no funciona como se esperaba (por ejemplo, tiempos lentos o módulos que fallan), se identifican esos puntos críticos y se ajusta lo necesario.


#### 4. Mejoras continuas  
En base a lo anterior, se pueden hacer cambios en la arquitectura: optimizar consultas, reorganizar módulos, agregar mecanismos de caching, etc.


#### 5. Conexión con las decisiones iniciales  
Cada cambio o validación se hace con la mirada puesta en lo que se definió al principio: si se prometió que la API debía responder en menos de 2 segundos, todo se orienta a que eso se cumpla.

### 10. ¿Qué herramientas o metodologías pueden ayudar a validar una arquitectura diseñada con ADD y Clean Architecture?

Para validar una arquitectura basada en ADD y Clean Architecture, se puede usar una combinación de herramientas:

- **Pruebas técnicas**: herramientas como JMeter (rendimiento), OWASP ZAP (seguridad).
- **Monitoreo**: usar Prometheus, Grafana para medir el comportamiento del sistema en tiempo real.
- **Análisis de código**: con SonarQube y pruebas automatizadas para asegurar buenas prácticas y modularidad.
- **Prototipos**: crear MVPs o versiones preliminares para validar que la arquitectura responde bien a los requisitos.

