package cn.staynoob.social.provider.facebook

/**
 * e.g.
 * ```json
 * {
 *     "access_token":"...",
 *     "expires_in":3920,
 *     "token_type":"Bearer",
 * }
 * ```
 * reference:
 * - https://developers.facebook.com/docs/facebook-login/manually-build-a-login-flow#confirm
 */
data class FacebookToken(
        val access_token: String,
        val expires_in: Int,
        /**
         * Bearer
         */
        val token_type: String
)
