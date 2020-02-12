package cn.staynoob.social.provider.linkedin

data class LinkedInCode2TokenRequest(
        val code: String,
        val redirect_uri: String
)
