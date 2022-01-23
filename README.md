~~`# microservices

1. Spring Cloud does auto scaling and Load Balancing
2. It provided dynamic scale up and scale down with help up of Eureka
3. Spring Cloud does configuration management between applications and provides visibility to us in the applications
4. Spring Cloud helps us to manage applications by giving us feasibility to increase resilience and fault tolerance of
   application with help of Circuit Breaker in Hysterix , Fallback method in Hysterix and many other properties.
5. Visibility and monitoring can be established using Zipkin Distributed Tracing

WebServices

1. System designed to support machine to machine interaction over a network
2. keys
    1. Designed for application to application interaction
    2. It should be interoperable
        1. All types of application should be able to connect to the application whether it is written in .NET , Spring
           ,php
    3. It should allow communication over the network
3. How does data exchange between application takes place?
    1. Application A makes request to webservices and webservice will return response for that request
4. For making webservices platform independent the request should also be platform independent;

Key Terminologies related to WebServices

1. Request
    1. Input to webservice
2. Response
    1. Output from a webservice
3. Message Exchange format
    1. Can we XML or JSON
4. Service Provider
    1. WebService is the service provider for Application
5. Service Consumer
    1. Application acts as service consumer for WebServices
6. Service Definition
    1. Contract between Service Provider and Consumer . Contains information like
        1. Request/Response Format
        2. Request Structure
        3. Response Structure
        4. EndPoint
7. Transport
    1. How can service be called Http or MQ.

Types of WebServices

1. SOAP
    1. Simple Object Access Protocol
    2. Specifies a specific way of building webservices
    3. SOAP makes used of XML Request and Response structure
    4. We will create a SOAP Envelope which will contain SOAP Header and Body
    5. SOAP Header is optional
    6. Summarizing
        1. SOAP Provide XML Request and Response Format
        2. SOAP has no restrictions on transport of the messages
            1. Call can be done using both MQ and Http
        3. Service Definition is done using
            1. WSDL stands for Web Service Definition Language
            2. WSDL defines
                1. Endpoints
                2. All the operations that are exposed
                3. Specified request and response format
2. REST
    1. REST stands for Representation State Transfer
    2. REST makes maximum use of HTTP Protocols
    3. We can specify the request method using HTTP Request methods
        1. GET
        2. POST
        3. PUT
        4. DELETE
    4. Response can be specified using HTTP Codes
    5. Resource
        1. Resource is anything that we want to expose to the consumer
        2. Resource has a URI , URI is identifier for the application that is exposed to other applications
    6. In case of REST the transport is only HTTP
    7. there are no restrictions on data exchange format any can be used XML or JSON
    8. No Standard Definition
        1. Swagger can be used for defining webservices

Difference between REST and SOAP

1. SOAP is used to add restrictions the request and response vs REST is more of an architectural approach
2. In SOAP the Data Exchange Format is always XML and both Request and Response should adhere to XML Format vs Rest has
   no restrictions on the Data Exchange Format both JSON and XML can be used , However JSON is the popular Exchange
   format in REST
3. SOAP used WSDL for Service Definition vs REST makes use of WADL however it is not as popularly used
4. SOAP has no restrictions on the transport both MQ and HTTP can be used , However REST makes used of HTTP
5. REST is easy to implement and does not require service definition and no request and response parsing is required in
   REST as compared to SOAP

RestFul Webservices with SpringBoot

1. @RestController
    1. It is used to specify that the controller or the class will accept rest calls
2. @RequestMapping
    1. It is used to specify the type of request a particular method can accept
    2. instead of using @RequestMapping we can make use of more specific mappings like
        1. @GetMapping
        2. @PutMapping
        3. @PostMapping
        4. @DeleteMapping
3. AutoConfiguration
    1. SpringBootStarter web has dependency over Spring as a result of which we get DispatcherServlet
    2. AutoConfiguration looks at maven dependencies and jar which we have added in the application and default
       configures bean for us
4. DispatcherServlet
    1. Dispatcher Servlet is our front controller
    2. Whenever request is received it first comes to DispatcherServlet
    3. Dispatcher Servlet knows where rest of controller are present with help of @RestController Annotation
    4. It looks at the URI and the request method
    5. @ResponseBody is part of RestController which converts the bean to json format and returns the response back
5. ServletURIComponentBuilder
    1. It is used to build URI from CurrentRequest and used to specify location from where object was created or
       modified
6. @ControllerAdvice
    1. If we have multiple controller, and we want to share items across all controllers then we make use of above
       annotation
7. ErrorHandling
    1. SpringBoot autoconfigured some default error handling for us
    2. It is important to have consistent error message throughout the application
    3. Create CustomExceptionFile
    4. We can also create Exception structure adhering to our use
    5. To Create CustomExceptionHandler and override the existing ResponseEntityExceptionHandler provided by SpringBoot
       below steps needs to be followed
        1. Create CustomExceptionHandler which will extend ResponseEntityExceptionHandler and provide implementation for
           handlexException method which will take webRequest and exception as input
        2. Create our custom exception Response
        3. Return the exception response
        4. Specify the Exception Class for which we want to handle the custom exception handler
8. Validations in SpringBoot
    1. To add validations in Springboot Applications we will have to add dependency of starter validations
    2. Dependency to be added
        1. GroupId : org.springframework.boot
        2. ArtifactId : spring-boot-starter-validation
    3. Restart our applications
    4. Use @Valid annotation on the call
    5. On Attributes add the validation
    6. When binding for any application fails handleMethodArgumentNotValid is triggered
    7. We can override above method to provide our implementation
    8. We can also provide custom message and tweak details to just send default message on validation
9. HATEOAS
    1. Hypermedia as the engine of Application State
    2. Dependency to be added in the pom.xml
        1. groupId : org.springframework.hateoas
        2. artifactId : spring-hateoas
    3. HateOAS can be used to provide resource with links using EntityModel
    4. We can make use of class provided by HateOAS i.e. WebMVCLinkBuilder to build links
    5. we can provide links to self and other methods
    6. In earlier versions of HATEOAS Resource and ControllerLinkBuilder were used instead of EntityModel and
       WebMvcLinkBuilder accordingly
10. Content Negotiation using SpringBoot
    1. We can make our webservices return xml response instead of JSON for that all we need to do is specify xml
       dependency in pom.xml
    2. Dependency to be added
        1. GroupId : com.fasterxml.jackson.dataformat
        2. ArtifactId : jackson-dataformat-xml
    3. In Header, we can specify what return type we want as xml or json
11. If we want our consumers to use the response and api's we can document our rest-apis with help of Open API
    Specification
    1. Spring Doc Open API
        1. It analyzes the application runtime and auto generates documentations
        2. We can add dependency in pom.xml
        3. GroupId : org.springdoc
        4. ArtifactId : springdoc-openapi-ui
        5. Once the dependency is added we can restart our application and go to browser and type
            1. http://localhost:8080/swagger-ui.html
        6. Consumer can now get details of request and response format and try apis from swagger ui by providing inputs
        7. Swagger UI is generated by open api documentation that was added in dependency
        8. We can see api docs for our application by clicking on the URL below swagger icon
        9. We can see more structured and detailed information by clicking on the URL of api docs
        10. In previous versions of swagger @APIModel and @APIProperty annotations were required which are not used
            anymore

12. Spring Boot Actuator
    1. It includes no of additional features that help you monitor and manage applications when pushed to production
    2. Dependency to be added in pom.xml
        1. GroupId : org.springframework.boot
        2. ArtifactId : spring-boot-starter-actuator
    3. We can go to url : http://localhost:8080/actuator and see defaults features provided by actuator after adding
       dependency and restarting application
    4. We can assess other features as well by specifying features to included in application.properties
        1. management.endpoints.web.exposure.include=*
    5. Restart application to see rest of the features provided by actuator
    6. By Default
        1. Self
        2. Health-path
        3. Health URLS are exposed with actuator
13. HAL Explorer
    1. HAL Explorer helps us to visually explore our application in easy way
    2. All we need to do is add Hal Dependency
    3. groupId : org.springframework.data
    4. artifactId : spring-data-rest-hal-explorer
    5. Restart the application
    6. Type in browser http://localhost:(port on which application is running)
14. If we want a particular field to be ignored in response because it may be important, and we do not want to send it
    to end user we can add @JsonIgnore Annotation over the field, and it will be ignored in the response
15. We can also ignore them by adding @JsonIgnoreProperties on top of class and specify the values we want to filter in
    it
16. Implementation Dynamic Filtering
    1. Dynamic filter is implemented at method sending the response
    2. We will create instance of SimpleBeanPropertyFilter and provide all the value that we do not want to filter
    3. Then create FilterProvider for SimpleBeanPropertyFilter object and add above filter
    4. Create instance of MappingJacksonValue and provide object name on which we want to do filter
    5. Provide filter name on model class
    6. return MappingJacksonValue
17. Versioning
    1. Versioning can be done using URL
    2. Headers
    3. Parameters
    4. Content Negotiation
    5. Few factors to consider while versioning our application is
        1. URL Pollution
        2. Misuse of HttpHeaders
        3. Caching
        4. Can we execute request on browser
        5. API Documentation
18. To enable basic security in the application we can simply add dependency of spring boot starter security in pom.xml
    1. Each time application starts a security code is printed on the console
    2. We can take this security code and pass from postman
    3. We can select basic auth in Authorization and type the pass we received on the console
    4. Default username is user
    5. Once spring boot starter security is added as the dependency in the pom.xml none of the URLs can be accessed
       without security code
    6. if we do not want our security code to change often we can add username in application.properties, and we can
       also add password in application.properties
    7. security.user.name=username
    8. security.user.pass=pass
    9. From spring 2.0.0 the properties name have changed too
    10. spring.security.user.name=username
    11. spring.security.user.pass=pass
    12. GroupId of Dependency : org.springframework.boot
    13. ArtifactId : spring-boot-starter-security
19. To connect our application with database we can make use of Spring starter jpa
    1. Dependency of Spring Starter JPA can be added in pom.xml
        1. GroupId : org.springframework.data
        2. ArtifactId : spring-boot-starter-data-jpa
    2. We can make use of embedded database h2 by adding its dependency in pom.xml
        1. GroupId : com.h2database
        2. ArtifactId : h2
        3. Appropriate version
        4. Scope : runtime
    3. JPA makes easy for us to interact with database
    4. All we need to do is provide the annotations to identify the Class for which we want table to be created, Id
       attribute for the class and columns in it
    5. JPA performs ORM mapping for us, and we need not write jdbc classes to interact with database
    6. JPA also helps us with list of predefined method that can be made used of by creating repositories which can
       extend JPA or CRUD Repository all we need to provide is class name and id acting as primary key
    7. We can see sql triggered by application for table creation or any database operation by adding below command in
       application.properties
        1. spring.jpa.show-sql=true
    8. h2 can be enabled by adding below command in application.properties
        1. spring.h2.console.enabled=true
    9. @Id
        1. This annotation is mandatory for entities
        2. It should be assigned to attribute that will act as primary key of the application
        3. @GeneratedValue helps JPA identify how value of Id column will be generated
            1. @GenerationType gives us 4 ways to generate values for Id column
                1. IDENTITY : Using a table Identity Column , Batches cannot be executed using Identity Identifier
                2. SEQUENCE : Using database sequence to generate values for identifier , this is the best identity
                   generation strategy as per JPA and Hibernate.
                    1. We can specify name of the sequence generator using generator="<seq_name>"
                    2. @SequenceGenerator
                        1. We can specify the name of the sequence to be generated using name="<seq_name>"
                        2. allocationSize: To define the size of the sequence
                        3. We can specify the initial value of sequence using initialValue=<value>
                3. AUTO : picks any of the previous strategy based on the underlying database capabilities
                4. TABLE : The row-level locking solution employed by the TABLE generator incurs a serialization portion
                   which hinders concurrency
20. In the example I have used Generation Type Sequence
21. To access any values from database we can create a repository that extends another JPA Repository
    1. two values are required for repository
        1. Id
        2. Class Name
22. OneToMany Mapping
    1. Model User will have one to Many Mapping with Post as user can have more than one post
    2. We need to specify the name of field with which we want to map the user with attribute in Post Class
23. ManyToOne Mapping
    1. Model Post will have Many to One Mapping with User as Multiple Posts can be linked to a single user.
    2. We can add FetchType Lazy to avoid fetching data when not required.
24. Richardson Maturity Model
    1. This model helps you evaluate how restful our services are with different levels
        1. Level0
            1. Expose soap services in rest style
        2. Level1
            1. Expose your resources with proper URL
        3. Level2
            1. User proper use of HttpMethods
        4. Level3
            1. Level2 + HATEOAS
            2. Data + Next Possible Actions
25. Best Practices
    1. Consumer First
    2. Make it simple for Consumer to understand your API
    3. Have proper API Definitions and Documentation
    4. Use proper response status
    5. Ensure No Secure Information are going into the URIS
    6. Use Plurals
26. Microservices with Spring Cloud
    1. Introduction to Microservices
        1. Services exposed by Rest, small deployable units and cloud enabled 2.Challenges with Microservices
        4. Deciding the Boundaries for MicroServices
        5. Configuration Management
        6. Establishing technologies to Dynamic Scaleup and Scale Down
        7. If not well-designed they will be nothing but pack of cards
        8. Fault Tolerance is required to handle all the configurations and environments
        9. Visibility is required on all the microservices

27. Spring Cloud
    1. Spring Cloud helps us to manage the challenges that we face in Microservices
    2. All the Configurations related to microservices can be stored in one place and SpringCloudServer can be used to
       expose these services to other components this makes us easy to handle all the configurations related to
       microservices
    3. SpringCloudLoadBalancer can be used to distribute load between all the instances of the Microservice
        1. All the instance of all the applications will be registered with naming server that is Eureka Server
        2. Naming Server when asked will provide the instance of the application
        3. Ribbon makes sure that the load is evenly distributed at client side load balancing
    4. Visibility and Monitoring can be done on Microservices using
        1. Zipkin Distributed Tracing
        2. Netflix API Gateway
    5. Resilience4J can be used to include FaultTolerance
    6. Microservices evolve quickly and important updates are
       1. SpringCloudLoadBalancer would be used to balance load instead of Ribbon 
          1. In previous versions of Microservices Ribbon was used for Load Balancing
       2. Resilience4J can be used for implementing fault tolerance in cloud rather than Hysterix
       3. SpringCloudGateway can be used instead of Zuul for Visibility

28. Setting up Spring CLoud Config Server
    1. 