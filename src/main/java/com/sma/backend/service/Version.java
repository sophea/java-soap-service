package com.sma.backend.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Version utility class
 * 
 * This class will try to read version number from manifest of a property called "Implementation-Version".<br/>
 * To have this property properly written in the manifest of a war file, you will need to use maven-war-plugin.<br/>
 * See pom.xml for reference. This class is not very generic.
 * 
 * @author gekko
 */
public class Version {
    /** Logger for debug logging */
    private static final Logger logger = LoggerFactory.getLogger(Version.class);

    /**
     * Get version number from manifest file
     * 
     * @param sc
     *            servlet context
     * @return version as string
     */
    public static String getVersion(ServletContext sc) {

        Properties prop = new Properties();

        InputStream in = null;
        try {
            in = sc.getResourceAsStream("/META-INF/MANIFEST.MF");
            prop.load(in);
        }
        catch (IOException e) {
            logger.error("Cannot read file /META-INF/MANIFEST.MF", e);
            return "-";
        }
        catch (Exception e) {
            return "-";
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                }
                catch (IOException ex) {
                }
            }
        }

        // for(Object s : prop.keySet()) {
        // logger.debug("Key :" + (String) s + prop.getProperty((String) s));
        // }

        return prop.getProperty("Implementation-Version");
    }

}
