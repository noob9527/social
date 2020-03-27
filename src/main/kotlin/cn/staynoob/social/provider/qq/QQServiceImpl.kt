package cn.staynoob.social.provider.qq

import cn.staynoob.social.share.ApiException
import cn.staynoob.social.share.SharedUnirest
import cn.staynoob.social.share.objectMapper
import cn.staynoob.social.share.successBody
import com.fasterxml.jackson.module.kotlin.readValue
import kong.unirest.HttpResponse

class QQServiceImpl(
        private val properties: QQProperties
) : QQService {

    companion object {
        private const val API_URL = "https://graph.qq.com"
    }

    internal fun <T : Any> HttpResponse<T>.qqSuccessBody(): T {
        return this.successBody(String::class) {
            throw ApiException(message = it)
        }
    }

    private fun getOpenId(accessToken: String): String {
        val res = SharedUnirest.get("$API_URL/oauth2.0/me")
                .queryString("access_token", accessToken)
                .asString()
                .qqSuccessBody()
        val pattern = """\{.*\}""".toRegex()
        val jsonStr = pattern.find(res)!!.value

        val map = objectMapper.readValue<Map<String, Any?>>(jsonStr)

        if (map.containsKey("error")) {
            throw ApiException(map["error"].toString(), map["error_description"].toString())
        } else {
            return map["openid"].toString()
        }
    }

    override fun getUserInfo(accessToken: String): QQUserInfo {
        val openId = getOpenId(accessToken)
        val res = SharedUnirest.get("$API_URL/user/get_user_info")
                .queryString("access_token", accessToken)
                .queryString("openid", openId)
                .queryString("oauth_consumer_key", properties.clientId)
                .asObject(QQUserInfo::class.java)

        return res.qqSuccessBody().copy(openId = openId)
    }
}
