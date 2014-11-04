package com.sma.soap;
//package com.goldengekko.soap;
//
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.ws.soap.Addressing;
//
//import org.springframework.ws.server.endpoint.annotation.Endpoint;
//import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
//import org.springframework.ws.server.endpoint.annotation.RequestPayload;
//import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
//import com.goldengekko.jaxb.FailurePayment;
//import com.goldengekko.jaxb.FailurePaymentRequest;
//import com.goldengekko.jaxb.FailurePaymentResponse;
//
//@Endpoint
//public class CallBackEndpointSaop11 {
//
//    private static final String NAMESPACE_URI = "http://tempuri.org/";
//    
//    @PayloadRoot(localPart = "FailurePaymentRequest", namespace = NAMESPACE_URI)
//    @ResponsePayload
//    public FailurePaymentResponse doFailuredPamentRequest(@RequestPayload FailurePaymentRequest request) throws Exception {
//        
//        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
//        System.out.println("====================================");
//        System.out.println(String.format("%s ,  %s , %s ", request.getPaymentTransactionNumber() , request.getErrorDesc() , request.getCallbackData()));
//        System.out.println("====================================");
//        Element response = document.createElementNS(NAMESPACE_URI, "orderResponse");
//        
//        FailurePaymentResponse response2 = new FailurePaymentResponse();
//        
//        
//        return response2;
//    }
//    
//    @PayloadRoot(localPart = "FailurePayment", namespace = NAMESPACE_URI)
//    @ResponsePayload
//    @Addressing(enabled=false)
//    public FailurePaymentResponse doFailuredPament(@RequestPayload FailurePayment request) throws Exception {
//        
//        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
//        System.out.println("====================================");
//        System.out.println(String.format("%s ,  %s , %s ", request.getPaymentTransactionNumber() , request.getErrorDesc() , request.getCallbackData()));
//        System.out.println("====================================");
//        
//        FailurePaymentResponse response2 = new FailurePaymentResponse();
//        
//        
//        return response2;
//    }
//    
//    private Element addElementWithValue(Document document, String element, String value){
//        Element child = document.createElementNS(NAMESPACE_URI, element);
//        child.appendChild(document.createTextNode(value));
//        return child;
//    }
//    
//}
