package cn.staynoob.social.provider.facebook

data class FacebookCode2TokenRequest(
        val code: String,
        val redirect_uri: String
)
