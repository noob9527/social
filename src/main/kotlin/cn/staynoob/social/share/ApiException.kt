package cn.staynoob.social.share

class ApiException(
        val code: String?,
        message: String?
) : RuntimeException(message)