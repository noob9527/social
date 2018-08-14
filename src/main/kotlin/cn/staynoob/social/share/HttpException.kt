package cn.staynoob.social.share

class HttpException(
        val status: Int,
        val statusText: String,
        cause: Throwable? = null
) : RuntimeException(statusText, cause)