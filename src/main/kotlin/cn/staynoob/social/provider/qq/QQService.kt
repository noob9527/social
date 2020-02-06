package cn.staynoob.social.provider.qq

interface QQService {
    fun getUserInfo(accessToken: String): QQUserInfo
}
