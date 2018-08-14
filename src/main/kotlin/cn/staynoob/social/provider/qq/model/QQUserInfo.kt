package cn.staynoob.social.provider.qq.model

import cn.staynoob.social.share.model.Gender

class QQUserInfo(
        val nickname: String,
        gender: String?,
        val figureurl: String?,
        val figureurl_1: String?,
        val figureurl_2: String?,
        val figureurl_qq_1: String?,
        val figureurl_qq_2: String?,
        val vip: Int?,
        val level: Int?
) {
    lateinit var openId: String
        internal set

    val gender: Gender? = gender?.let {
        if (it == "女") Gender.FEMALE else Gender.MALE
    }

    override fun toString(): String {
        return "QQUserInfo(nickname='$nickname', figureurl=$figureurl, figureurl_1=$figureurl_1, figureurl_2=$figureurl_2, figureurl_qq_1=$figureurl_qq_1, figureurl_qq_2=$figureurl_qq_2, vip=$vip, level=$level, openId='$openId', gender=$gender)"
    }


}