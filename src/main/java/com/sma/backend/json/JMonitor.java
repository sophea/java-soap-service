/***/
package com.sma.backend.json;

/**
 * @author sophea <a href='mailto:sm@goldengekko.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2012
 */
public class JMonitor {
    private Long   millis;
    private String version;
    private String ip;

    public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
     * @return the millis
     */
    public Long getMillis() {
        return millis;
    }

    /**
     * @param millis the millis to set
     */
    public void setMillis(Long millis) {
        this.millis = millis;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

}
