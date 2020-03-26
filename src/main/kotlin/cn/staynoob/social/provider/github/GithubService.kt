package cn.staynoob.social.provider.github

interface GithubService {
    /**
     * note that refresh_token can be null
     * check out the official doc for further detail
     * - [Step 5: Exchange authorization code for refresh and access tokens](https://developers.github.com/identity/protocols/OAuth2WebServer?hl=en#exchange-authorization-code)
     */
    fun code2token(request: GithubCode2TokenRequest): GithubToken

    /**
     * Note that the token permission scope should at least have
     * 'profile', 'email'
     */
    fun getUserInfo(accessToken: String): GithubUserInfo
}
