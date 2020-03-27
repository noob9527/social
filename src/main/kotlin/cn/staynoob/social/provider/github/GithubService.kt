package cn.staynoob.social.provider.github

interface GithubService {
    fun code2token(request: GithubCode2TokenRequest): GithubToken
    fun getUserInfo(accessToken: String): GithubUserInfo
}
