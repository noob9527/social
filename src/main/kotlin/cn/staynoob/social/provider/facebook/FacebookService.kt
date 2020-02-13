package cn.staynoob.social.provider.facebook

interface FacebookService {
    /**
     * note that refresh_token can be null
     * check out the official doc for further detail
     * - [Step 5: Exchange authorization code for refresh and access tokens](https://developers.facebook.com/identity/protocols/OAuth2WebServer?hl=en#exchange-authorization-code)
     */
    fun code2token(request: FacebookCode2TokenRequest): FacebookToken

    /**
     * Note that the token permission scope should at least have
     * 'email', 'public_profile'
     */
    fun getUserInfo(accessToken: String): FacebookUserInfo
}
