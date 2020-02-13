package cn.staynoob.social.share;

import javax.validation.constraints.NotNull;

public class ProxyProperties {

    @NotNull
    private String host;
    @NotNull
    private Integer port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

}
