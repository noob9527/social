package cn.staynoob.social.provider.wechat

import cn.staynoob.social.provider.wechat.model.WechatUserInfo

interface WechatService {
    fun getUserInfo(accessToken: String, openId: String): WechatUserInfo
}