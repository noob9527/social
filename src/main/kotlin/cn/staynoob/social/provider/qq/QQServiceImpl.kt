package cn.staynoob.social.provider.qq

import cn.staynoob.social.provider.qq.autoconfigure.QQProperties
import cn.staynoob.social.provider.qq.model.QQUserInfo
import cn.staynoob.social.share.ApiException
import cn.staynoob.social.share.initUnrest
import cn.staynoob.social.share.objectMapper
import cn.staynoob.social.share.successBody
import com.fasterxml.jackson.module.kotlin.readValue
import com.mashape.unirest.http.Unirest

class QQServiceImpl(
        properties: QQProperties
) : QQService {

    companion object {
        init {
            initUnrest()
        }

        private const val API_URL = "https://graph.qq.com"
    }

    val appId: String = properties.appId!!

    val appSecret: String = properties.appSecret!!

    private val regex = """\{.*\}""".toRegex()

    private fun getOpenId(accessToken: String): String {
        val res = Unirest.get("$API_URL/oauth2.0/me")
                .queryString("access_token", accessToken)
                .asString()
                .successBody

        val jsonStr = regex.find(res)!!.value

        val map = objectMapper.readValue<Map<String, Any?>>(jsonStr)

        if (map.containsKey("error")) {
            throw ApiException(map["error"].toString(), map["error_description"].toString())
        } else {
            return map["openid"].toString()
        }
    }

    override fun getUserInfo(accessToken: String): QQUserInfo {
        val openId = getOpenId(accessToken)
        val res = Unirest.get("$API_URL/user/get_user_info")
                .queryString("access_token", accessToken)
                .queryString("openid", openId)
                .queryString("oauth_consumer_key", appId)
                .asObject(QQUserInfo::class.java)

        return res.successBody.apply { this.openId = openId }
    }
}