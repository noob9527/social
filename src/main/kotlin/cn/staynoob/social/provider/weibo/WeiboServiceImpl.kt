package cn.staynoob.social.provider.weibo

import cn.staynoob.social.share.ApiException
import cn.staynoob.social.share.SharedUnirest
import cn.staynoob.social.share.successBody
import kong.unirest.HttpResponse

class WeiboServiceImpl(
        private val properties: WeiboProperties
) : WeiboService {

    companion object {
        private const val API_URL = "https://api.weibo.com/2"
    }

    private data class UidResponse(val uid: String)

    internal fun <T : Any> HttpResponse<T>.weiboSuccessBody(): T {
        return this.successBody(WeiboErrorResponse::class) {
            throw ApiException(
                    code = it.error_code.toString(),
                    message = it.error
            )
        }
    }

    override fun code2token(request: WeiboCode2TokenRequest): WeiboToken {
        val req = SharedUnirest.post("https://api.weibo.com/oauth2/access_token")
                .header("Accept", "application/json")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .field("code", request.code)
                .field("client_id", properties.clientId)
                .field("client_secret", properties.clientSecret)
                .field("redirect_uri", request.redirect_uri)
                .field("grant_type", "authorization_code")
        return req.asObject(WeiboToken::class.java).weiboSuccessBody()
    }

    private fun getUid(accessToken: String): String {
        val res = SharedUnirest.get("$API_URL/account/get_uid.json")
                .queryString("access_token", accessToken)
                .asObject(UidResponse::class.java)
                .weiboSuccessBody()
        return res.uid
    }

    override fun getUserInfo(accessToken: String): WeiboUserInfo {
        val uid = getUid(accessToken)
        return SharedUnirest.get("$API_URL/users/show.json")
                .queryString("access_token", accessToken)
                .queryString("uid", uid)
                .asObject(WeiboUserInfo::class.java)
                .weiboSuccessBody()
    }
}
