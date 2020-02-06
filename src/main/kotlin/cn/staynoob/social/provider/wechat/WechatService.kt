package cn.staynoob.social.provider.wechat

interface WechatService {
    fun getUserInfo(accessToken: String, openId: String): WechatUserInfo
}
