package cn.staynoob.social.provider.google

data class GoogleCode2TokenRequest(
        val code: String,
        val redirect_uri: String
)
