package cn.staynoob.social.provider.weibo

import cn.staynoob.social.provider.weibo.model.WeiboUserInfo
import cn.staynoob.social.share.ApiException
import cn.staynoob.social.share.initUnrest
import cn.staynoob.social.share.objectMapper
import cn.staynoob.social.share.successBody
import com.fasterxml.jackson.module.kotlin.readValue
import com.mashape.unirest.http.Unirest

class WeiboServiceImpl : WeiboService {

    companion object {
        init {
            initUnrest()
        }

        private const val API_URL = "https://api.weibo.com/2"
    }

    private data class UidResponse(val uid: String)

    private fun getUid(accessToken: String): String {
        val res = Unirest.get("$API_URL/account/get_uid.json")
                .queryString("access_token", accessToken)
                .asString()
                .successBody

        val map = objectMapper.readValue<Map<String, Any?>>(res)

        if (map.containsKey("error_code")) {
            throw ApiException(
                    map["error_code"].toString(),
                    map["error"].toString()
            )
        } else {
            return objectMapper.readValue<UidResponse>(res).uid
        }
    }

    override fun getUserInfo(accessToken: String): WeiboUserInfo {
        val uid = getUid(accessToken)
        val res = Unirest.get("$API_URL/users/show.json")
                .queryString("access_token", accessToken)
                .queryString("uid", uid)
                .asString()
                .successBody

        val map = objectMapper.readValue<Map<String, Any?>>(res)

        if (map.containsKey("error_code")) {
            throw ApiException(
                    map["error_code"].toString(),
                    map["error"].toString()
            )
        } else {
            return objectMapper.readValue<WeiboUserInfo>(res)
        }
    }
}