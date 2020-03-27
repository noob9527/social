package cn.staynoob.social.provider.weibo

interface WeiboService {
    fun code2token(request: WeiboCode2TokenRequest): WeiboToken
    fun getUserInfo(accessToken: String): WeiboUserInfo
}
