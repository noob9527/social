package cn.staynoob.social.provider.facebook

/**
 * e.g.
 * ```json
 * {
 *     "access_token":"1/fFAGRNJru1FTz70BzhT3Zg",
 *     "expires_in":3920,
 *     "token_type":"Bearer",
 *     "refresh_token":"1/xEoDL4iW3cxlI7yDbSRFYNG01kVKM2C-259HOF2aQbI"
 * }
 * ```
 * reference:
 * - https://developers.facebook.com/identity/protocols/OAuth2WebServer?hl=en#exchange-authorization-code
 */
data class FacebookToken(
        val access_token: String,
        val expires_in: Int,
        /**
         * Bearer
         */
        val token_type: String,
        /**
         * as the doc says:
         * > this field is only present in this response if you set the access_type parameter to offline in the initial request to Facebook's authorization server.
         */
        val refresh_token: String?,
        /**
         * https://developers.facebook.com/identity/protocols/OpenIDConnect#obtainuserinfo
         */
        val id_token: String?
)
