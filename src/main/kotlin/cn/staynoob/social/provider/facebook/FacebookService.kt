package cn.staynoob.social.provider.facebook

interface FacebookService {
    /**
     * note that refresh_token can be null
     * check out the official doc for further detail
     * - [Step 5: Exchange authorization code for refresh and access tokens](https://developers.facebook.com/identity/protocols/OAuth2WebServer?hl=en#exchange-authorization-code)
     */
    fun code2token(request: FacebookCode2TokenRequest): FacebookToken

    /**
     * - [Refreshing an access token (offline access)](https://developers.facebook.com/identity/protocols/OAuth2WebServer?hl=en#offline)
     */
    fun refreshToken(request: FacebookRefreshTokenRequest): FacebookToken

    /**
     * - [Revoking a token] (https://developers.facebook.com/identity/protocols/OAuth2WebServer?hl=en#offline)
     */
    fun revokeToken(token: String)

    fun getUserInfo(accessToken: String): FacebookUserInfo
}
