package cn.staynoob.social.provider.facebook.autoconfigure;

import cn.staynoob.social.share.ProxyProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "social.facebook")
public class FacebookProperties {

    @NotNull
    private String clientId;
    @NotNull
    private String clientSecret;
    @Valid
    private ProxyProperties proxy;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public ProxyProperties getProxy() {
        return proxy;
    }

    public void setProxy(ProxyProperties proxy) {
        this.proxy = proxy;
    }

}
