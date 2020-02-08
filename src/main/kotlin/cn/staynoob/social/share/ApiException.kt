package cn.staynoob.social.share

class ApiException(
        val code: String? = null,
        message: String? = null
) : RuntimeException(message)
