package cn.staynoob.social.provider.github

data class GithubErrorResponse(
        val error: String,
        val error_description: String? = null
)
