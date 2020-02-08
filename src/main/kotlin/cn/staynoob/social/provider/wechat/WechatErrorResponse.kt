package cn.staynoob.social.provider.wechat

data class WechatErrorResponse(
        val errcode: String,
        val errmsg: String? = null
)
