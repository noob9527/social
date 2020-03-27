package cn.staynoob.social.provider.weibo

data class WeiboCode2TokenRequest(
        val code: String,
        val redirect_uri: String
)
