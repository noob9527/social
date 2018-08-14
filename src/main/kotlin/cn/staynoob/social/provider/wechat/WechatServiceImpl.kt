package cn.staynoob.social.provider.wechat

import cn.staynoob.social.provider.wechat.model.WechatUserInfo
import cn.staynoob.social.share.ApiException
import cn.staynoob.social.share.initUnrest
import cn.staynoob.social.share.objectMapper
import cn.staynoob.social.share.successBody
import com.fasterxml.jackson.module.kotlin.readValue
import com.mashape.unirest.http.Unirest

class WechatServiceImpl : WechatService {

    companion object {
        init {
            initUnrest()
        }

        private const val API_URL = "https://api.weixin.qq.com"
    }

    override fun getUserInfo(accessToken: String, openId: String): WechatUserInfo {
        val res = Unirest.get("$API_URL/sns/userinfo")
                .queryString("access_token", accessToken)
                .queryString("openid", openId)
                .asString()
                .successBody

        val map = objectMapper.readValue<Map<String, Any?>>(res)

        if (map.containsKey("errcode")) {
            throw ApiException(
                    map["errcode"].toString(),
                    map["errmsg"].toString()
            )
        } else {
            return objectMapper.readValue<WechatUserInfo>(res)
        }

    }
}