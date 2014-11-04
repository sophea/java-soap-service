package com.sma.backend.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sma.backend.json.JMonitor;
import com.sma.backend.service.Version;

/**
 * Display application status such as the version number of the application.
 * 
 * @author sm
 */
@Controller
@RequestMapping("monitor")
public class MonitorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorController.class);

    @RequestMapping(value = "v10", method = RequestMethod.GET)
    public ResponseEntity<JMonitor> monitor(HttpServletRequest request) {
        LOGGER.info("/monitor/v10");

        final JMonitor monitor = new JMonitor();
        final String version = Version.getVersion(request.getSession().getServletContext());
        monitor.setVersion(version);
        monitor.setMillis(System.currentTimeMillis());
        monitor.setIp(request.getRemoteAddr());
        return new ResponseEntity<JMonitor>(monitor, HttpStatus.OK);
    }
}
