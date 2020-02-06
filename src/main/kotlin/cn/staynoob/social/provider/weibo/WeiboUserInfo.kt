package cn.staynoob.social.provider.weibo


data class WeiboUserInfo(
        val id: Long = 0,
        val idstr: String? = "",
        val screen_name: String? = "",
        val province: Int? = null,
        val gender: String? = null,
        val city: Int? = null,
        val location: String? = null,
        val description: String? = null,

        val avatar_hd: String? = null,
        val avatar_large: String? = null,
        val profile_image_url: String? = null,
        val created_at: String? = null
)
