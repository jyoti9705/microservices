`# microservices

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
           handleException method which will take webRequest and exception as input
        2. Create our custom exception Response
        3. Return the exception response
        4. Specify the Exception Class for which we want to handle the custom exception handler