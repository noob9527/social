package cn.staynoob.social.provider.weibo.model

import cn.staynoob.social.share.model.Gender

class WeiboUserInfo(
        val id: Long,
        val idstr: String,
        val screen_name: String,
        val province: Int? = null,
        gender: String? = null,
        val city: Int? = null,
        val location: String? = null,
        val description: String? = null,

        val avatar_hd: String? = null,
        val avatar_large: String? = null,
        val profile_image_url: String? = null,
        val created_at: String? = null
) {
    val gender: Gender? = gender?.let {
        when (it) {
            "m" -> Gender.MALE
            "f" -> Gender.FEMALE
            else -> null
        }
    }

    override fun toString(): String {
        return "WeiboUserInfo(id=$id, idstr='$idstr', screen_name='$screen_name', province=$province, city=$city, location=$location, description=$description, avatar_hd=$avatar_hd, avatar_large=$avatar_large, profile_image_url=$profile_image_url, created_at=$created_at, gender=$gender)"
    }

}