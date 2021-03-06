package cn.staynoob.social.provider.linkedin

interface LinkedInService {
    /**
     * note that refresh_token can be null
     * check out the official doc for further detail
     * - [Step 5: Exchange authorization code for refresh and access tokens](https://developers.linkedin.com/identity/protocols/OAuth2WebServer?hl=en#exchange-authorization-code)
     */
    fun code2token(request: LinkedInCode2TokenRequest): LinkedInToken

    /**
     * Note that the token permission scope should at least have
     * 'r_emailaddress', 'r_liteprofile'
     */
    fun getUserInfo(accessToken: String): LinkedInUserInfo
}
