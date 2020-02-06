package cn.staynoob.social.provider.wechat

data class WechatUserInfo(
        val openid: String = "",
        val nickname: String = "",
        val sex: Int? = null,
        val province: String? = null,
        val city: String? = null,
        val headimgurl: String? = null,
        val unionid: String? = null
)
