package cn.staynoob.social.provider.facebook


data class FacebookUserInfo(
        val id: String = "",
        val name: String? = null,
        val email: String? = null,

        val first_name: String? = null,
        val last_name: String? = null,

        val picture: FacebookPicture? = null
) {

    val unstablePictureUrl = picture
            ?.data
            ?.url

    data class FacebookPicture(
            val data: FacebookPictureData? = null
    )

    data class FacebookPictureData(
            val url: String? = null,
            val width: String? = null,
            val height: String? = null
    )
}
