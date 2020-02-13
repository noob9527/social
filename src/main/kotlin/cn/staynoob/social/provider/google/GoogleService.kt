package cn.staynoob.social.provider.google

interface GoogleService {
    /**
     * note that refresh_token can be null
     * check out the official doc for further detail
     * - [Step 5: Exchange authorization code for refresh and access tokens](https://developers.google.com/identity/protocols/OAuth2WebServer?hl=en#exchange-authorization-code)
     */
    fun code2token(request: GoogleCode2TokenRequest): GoogleToken

    /**
     * - [Refreshing an access token (offline access)](https://developers.google.com/identity/protocols/OAuth2WebServer?hl=en#offline)
     */
    fun refreshToken(request: GoogleRefreshTokenRequest): GoogleToken

    /**
     * - [Revoking a token] (https://developers.google.com/identity/protocols/OAuth2WebServer?hl=en#offline)
     */
    fun revokeToken(token: String)

    /**
     * Note that the token permission scope should at least have
     * 'profile', 'email'
     */
    fun getUserInfo(accessToken: String): GoogleUserInfo
}
