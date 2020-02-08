package cn.staynoob.social.provider.google


data class GoogleUserInfo(
        val id: String = "",
        val name: String? = null,
        val given_name: String? = null,
        val family_name: String? = null,
        val email: String? = null,
        val verified_email: Boolean = false,
        val gender: String? = null,
        val picture: String? = null,
        val link: String? = null,
        val hd: String? = null,
        val locale: String? = null,

        val etag: String? = null
)
