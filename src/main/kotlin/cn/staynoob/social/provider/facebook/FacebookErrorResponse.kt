package cn.staynoob.social.provider.facebook

data class FacebookErrorResponse(
        val error: FacebookError
) {
    data class FacebookError(
            val message: String?,
            val type: String?,
            val code: Int?,
            val error_subcode: Int?
    )
}
