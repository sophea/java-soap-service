/***/
package com.sma.soap;


import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sma.jaxb.OrderRequest;

/**
 * @author sophea <a href='mailto:sm@goldengekko.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2014
 */
@Endpoint
public class OrderEndpoint {

    private static final String NAMESPACE = "http://tempuri.org/";
    
    @PayloadRoot(localPart = "orderRequest", namespace = NAMESPACE)
    @ResponsePayload
    public Element processOrder(@RequestPayload OrderRequest request) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        System.out.println("====================================");
        System.out.println(request);
        System.out.println("====================================");
        Element response = document.createElementNS(NAMESPACE, "orderResponse");
        response.appendChild(addElementWithValue(document, "item", "Item1"));
        response.appendChild(addElementWithValue(document, "quantity", "2"));
        response.appendChild(addElementWithValue(document, "city", "Ahmedabad"));
        response.appendChild(addElementWithValue(document, "country", "India"));
        response.appendChild(addElementWithValue(document, "price", "200.00"));
        response.appendChild(addElementWithValue(document, "isDeliver", "true"));
        return response;
    }
   
    private Element addElementWithValue(Document document, String element, String value){
        Element child = document.createElementNS(NAMESPACE, element);
        child.appendChild(document.createTextNode(value));
        return child;
    }
}
