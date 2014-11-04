java-soap-service
=================

Create Soap Service with Spring web service ( maven , springframe , jdk 1.6 to up)

maven Dependency
================
<dependency>
   <groupId>org.springframework.ws</groupId>
   <artifactId>spring-ws-core</artifactId>
   <version>2.1.4.RELEASE</version>
 </dependency>
 
  <dependency>
    <groupId>org.jdom</groupId>
    <artifactId>jdom</artifactId>
    <version>2.0.2</version>
  </dependency>
  <dependency>
    <groupId>jaxen</groupId>
    <artifactId>jaxen</artifactId>
    <version>1.1</version>
  </dependency>
  <dependency>
    <groupId>org.springframework.ws</groupId>
    <artifactId>spring-xml</artifactId>
    <version>2.0.2.RELEASE</version>
  </dependency>
     <!-- Logging -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.6.1</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.6.4</version>
            <scope>runtime</scope>
        </dependency>

mvn eclipse:eclipse  ( prepare classpath)

mvn clean jetty:run ( startup with jetty)

Test Look up wsdl files :
 ==============================
 
1 - http://localhost:8080/soapService/hr.wsdl

2 - http://localhost:8080/soapService/partnerCallbackService.wsdl

3 - http://localhost:8080/soapService/order.wsdl


