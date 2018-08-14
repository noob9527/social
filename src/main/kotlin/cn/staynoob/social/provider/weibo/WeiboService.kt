package cn.staynoob.social.provider.weibo

import cn.staynoob.social.provider.weibo.model.WeiboUserInfo

interface WeiboService {
    fun getUserInfo(accessToken: String): WeiboUserInfo
}