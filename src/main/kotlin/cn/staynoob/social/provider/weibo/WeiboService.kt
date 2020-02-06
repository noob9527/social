package cn.staynoob.social.provider.weibo

interface WeiboService {
    fun getUserInfo(accessToken: String): WeiboUserInfo
}
