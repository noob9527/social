package cn.staynoob.social.provider.github

/**
 * reference:
 * - https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/
 */
data class GithubToken(
        val access_token: String,
        /**
         * Bearer
         */
        val token_type: String,
        val scope: String
)
