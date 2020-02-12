package cn.staynoob.social.provider.linkedin

data class LinkedInErrorResponse(
        val error: String,
        val error_description: String? = null
)
