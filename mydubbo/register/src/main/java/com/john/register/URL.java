package com.john.register;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-26 15:35
 */
public class URL implements Serializable {

    private String hostName;
    private Integer port;

    public URL(String hostName, Integer port) {
        this.hostName = hostName;
        this.port = port;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof URL))
            return false;
        URL url = (URL) obj;
        return this.hostName.equals(url.getHostName()) && this.port.equals(url.getPort());
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostName, port);
    }
}
