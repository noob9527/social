package cn.staynoob.social.provider.qq

data class QQUserInfo(
        val nickname: String = "",
        val gender: String? = null,
        val figureurl: String? = null,
        val figureurl_1: String? = null,
        val figureurl_2: String? = null,
        val figureurl_qq_1: String? = null,
        val figureurl_qq_2: String? = null,
        val vip: Int? = null,
        val level: Int? = null,
        val openId: String = ""
)
