package cn.staynoob.social.provider.wechat.model

import cn.staynoob.social.share.model.Gender

class WechatUserInfo(
        val openid: String,
        val nickname: String,
        sex: Int? = null,
        val province: String? = null,
        val city: String? = null,
        val headimgurl: String? = null,
        val unionid: String? = null
) {
    val gender: Gender? = sex?.let {
        if (it == 2) Gender.FEMALE else Gender.MALE
    }

    override fun toString(): String {
        return "WechatUserInfo(openid='$openid', nickname='$nickname', province=$province, city=$city, headimgurl=$headimgurl, unionid=$unionid, gender=$gender)"
    }


}