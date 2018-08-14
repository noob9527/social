package cn.staynoob.social.provider.qq

import cn.staynoob.social.provider.qq.model.QQUserInfo

interface QQService {
    fun getUserInfo(accessToken: String): QQUserInfo
}