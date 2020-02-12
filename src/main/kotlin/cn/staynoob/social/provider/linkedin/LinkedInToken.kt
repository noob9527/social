package cn.staynoob.social.provider.linkedin

/**
 * reference:
 * - https://docs.microsoft.com/zh-cn/linkedin/shared/authentication/authorization-code-flow?context=linkedin/context#step-3-exchange-authorization-code-for-an-access-token
 */
data class LinkedInToken(
        val access_token: String,
        val expires_in: Int
)
