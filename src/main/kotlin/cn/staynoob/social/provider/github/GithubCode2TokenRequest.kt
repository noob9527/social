package cn.staynoob.social.provider.github

data class GithubCode2TokenRequest(
        val code: String,
        val redirect_uri: String? = null,
        val state: String? = null
)

internal data class InternalGithubCode2TokenRequest(
        val code: String,
        val redirect_uri: String? = null,
        val state: String? = null,

        val client_id: String,
        val client_secret: String
)
