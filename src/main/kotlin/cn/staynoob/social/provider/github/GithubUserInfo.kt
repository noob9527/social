package cn.staynoob.social.provider.github


data class GithubUserInfo(
        val id: String = "",
        val name: String? = null,
        val email: String = "",
        val avatar_url: String? = null,
        val location: String? = null
)
