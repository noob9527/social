package cn.staynoob.social.provider.weibo;


import javax.validation.constraints.NotNull;

public class WeiboProperties {

    @NotNull
    private String clientId;
    @NotNull
    private String clientSecret;

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

}
