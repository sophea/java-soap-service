java-soap-service
=================

Create Soap Service with Spring web service ( maven , springframeworkd , jdk 1.6 to up)
================================

```java
    
mvn eclipse:eclipse  ( prepare classpath)

mvn clean jetty:run ( startup with jetty)

Test Look up wsdl files :
 ==============================
 
1 - http://localhost:8080/soapService/hr.wsdl

2 - http://localhost:8080/soapService/partnerCallbackService.wsdl

3 - http://localhost:8080/soapService/order.wsdl


Client testing with SoapUI no response back : http://localhost:8080/soapService/hr.wsdl


Request :  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="http://mycompany.com/hr/schemas">
   <soapenv:Header/>
   <soapenv:Body>
      <sch:HolidayRequest>
         <!--You may enter the following 2 items in any order-->
         <sch:Holiday>
            <sch:StartDate>20-10-2013</sch:StartDate>
            <sch:EndDate>20-10-2014</sch:EndDate>
         </sch:Holiday>
         <sch:Employee>
            <sch:Number>012959601</sch:Number>
            <sch:FirstName>sophea</sch:FirstName>
            <sch:LastName>mak</sch:LastName>
         </sch:Employee>
      </sch:HolidayRequest>
   </soapenv:Body>
</soapenv:Envelope>

Server Log
================

 Returning cached instance of singleton bean 'holidayEndpoint'
================================handleHolidayRequest=============[Element: <sch:HolidayRequest [Namespace: http://mycompany.com/hr/schemas]/>]
Booking holiday for [Fri Apr 05 00:00:00 ICT 26-Sat Apr 06 00:00:00 ICT 26] for [sophea mak] 
DEBUG 2014-11-04 10:35:41 org.springframework.ws.server.MessageDispatcher:187
 - MessageDispatcher with name 'spring-ws' sends no response for request [SaajSoapMessage {http://mycompany.com/hr/schemas}HolidayRequest]
DEBUG 2014-11-04 10:35:41 org.springframework.web.servlet.FrameworkServlet:913
 - Successfully completed request




2 http://localhost:8080/soapService/partnerCallbackService.wsdl with response object back

Request :
==================
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tem="http://tempuri.org/">
   <soapenv:Header/>
   <soapenv:Body>
      <tem:FailurePaymentRequest>
         <tem:paymentTransactionNumber>1232321</tem:paymentTransactionNumber>
         <tem:callbackData>2342344</tem:callbackData>
         <tem:errorDesc>error</tem:errorDesc>
      </tem:FailurePaymentRequest>
   </soapenv:Body>
</soapenv:Envelope>

Soap Response
=========================
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:FailurePaymentResponse xmlns:ns2="http://tempuri.org/"/>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>

Server Log
=====================
DEBUG 2014-11-04 10:38:39 org.springframework.ws.server.endpoint.adapter.method.jaxb.AbstractJaxb2PayloadMethodProcessor:127
 - Unmarshalled payload request to [com.sma.jaxb.FailurePaymentRequest@16514a37]
DEBUG 2014-11-04 10:38:39 org.springframework.beans.factory.support.AbstractBeanFactory:245
 - Returning cached instance of singleton bean 'http://www.w3.org/2003/05/soap/bindings/HTTP/'
====================================
1232321 ,  error , 2342344 
====================================
DEBUG 2014-11-04 10:38:39 org.springframework.ws.server.endpoint.adapter.method.jaxb.AbstractJaxb2PayloadMethodProcessor:88
 - Marshalling [com.sma.jaxb.FailurePaymentResponse@29e0e7f7] to response payload
DEBUG 2014-11-04 10:38:39 org.springframework.ws.server.MessageDispatcher:182
 - Sent response [SaajSoapMessage {http://tempuri.org/}FailurePaymentResponse] for request [SaajSoapMessage {http://tempuri.org/}FailurePaymentRequest]
DEBUG 2014-11-04 10:38:39 org.springframework.web.servlet.FrameworkServlet:913
 - Successfully completed request

===========================================
3- http://localhost:8080/soapService/order.wsdl with response object back

soap Request
=============
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tem="http://tempuri.org/">
   <soapenv:Header/>
   <soapenv:Body>
      <tem:orderRequest>
         <tem:item>test</tem:item>
         <tem:quantity>1</tem:quantity>
         <tem:city>PP</tem:city>
         <tem:country>KH</tem:country>
      </tem:orderRequest>
   </soapenv:Body>
</soapenv:Envelope>

soap response
======================
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <orderResponse xmlns="http://tempuri.org/">
         <item>Item1</item>
         <quantity>2</quantity>
         <city>Ahmedabad</city>
         <country>India</country>
         <price>200.00</price>
         <isDeliver>true</isDeliver>
      </orderResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>

Server log
====================
- Testing endpoint adapter [org.springframework.ws.server.endpoint.adapter.DefaultMethodEndpointAdapter@17ace898]
DEBUG 2014-11-04 10:40:57 org.springframework.ws.server.endpoint.adapter.method.jaxb.AbstractJaxb2PayloadMethodProcessor:127
 - Unmarshalled payload request to [test, 1, PP , KH]
DEBUG 2014-11-04 10:40:57 org.springframework.beans.factory.support.AbstractBeanFactory:245
 - Returning cached instance of singleton bean 'orderEndpoint'
====================================
test, 1, PP , KH
====================================
DEBUG 2014-11-04 10:40:57 org.springframework.ws.server.MessageDispatcher:182
 - Sent response [SaajSoapMessage {http://tempuri.org/}orderResponse] for request [SaajSoapMessage {http://tempuri.org/}orderRequest]
DEBUG 2014-11-04 10:40:57 org.springframework.web.servlet.FrameworkServlet:913
 - Successfully completed request


```




