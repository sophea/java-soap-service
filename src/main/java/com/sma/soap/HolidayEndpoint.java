package com.sma.soap;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint 
public class HolidayEndpoint {
    private static final String NAMESPACE_URI = "http://mycompany.com/hr/schemas";

    private XPath startDateExpression;

    private XPath endDateExpression;

    private XPath nameExpression;

    private HumanResourceService humanResourceService;

    @Autowired
    public HolidayEndpoint(HumanResourceService humanResourceService)                      
        throws JDOMException {
      this.humanResourceService = humanResourceService;

      Namespace namespace = Namespace.getNamespace("hr", NAMESPACE_URI);

      startDateExpression = XPath.newInstance("//hr:StartDate");
      startDateExpression.addNamespace(namespace);

      endDateExpression = XPath.newInstance("//hr:EndDate");
      endDateExpression.addNamespace(namespace);

      nameExpression = XPath.newInstance("concat(//hr:FirstName,' ',//hr:LastName)");
      nameExpression.addNamespace(namespace);
      
      System.out.print("================================service started==============" + humanResourceService.toString());
      
      
    }

    @PayloadRoot(namespace=NAMESPACE_URI,localPart="HolidayRequest")
    public void handle(@RequestPayload Element holidayRequest)    throws Exception {
//        
       System.out.println("================================handleHolidayRequest============="+ holidayRequest);
//        
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date startDate = dateFormat.parse(startDateExpression.valueOf(holidayRequest));
      Date endDate = dateFormat.parse(endDateExpression.valueOf(holidayRequest));
      String name = nameExpression.valueOf(holidayRequest);

      humanResourceService.bookHoliday(startDate, endDate, name);
    }
    
}
