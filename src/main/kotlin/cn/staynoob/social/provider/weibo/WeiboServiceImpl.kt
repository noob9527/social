package cn.staynoob.social.provider.weibo

import cn.staynoob.social.share.ApiException
import cn.staynoob.social.share.successBody
import kong.unirest.HttpResponse
import cn.staynoob.social.share.Unirest

class WeiboServiceImpl : WeiboService {

    companion object {
        private const val API_URL = "https://api.weibo.com/2"
    }

    private data class UidResponse(val uid: String)

    internal fun <T : Any> HttpResponse<T>.successBody(): T {
        return this.successBody(WeiboErrorResponse::class) {
            throw ApiException(
                    code = it.error_code.toString(),
                    message = it.error
            )
        }
    }

    private fun getUid(accessToken: String): String {
        val res = Unirest.get("$API_URL/account/get_uid.json")
                .queryString("access_token", accessToken)
                .asObject(UidResponse::class.java)
                .successBody()
        return res.uid
    }

    override fun getUserInfo(accessToken: String): WeiboUserInfo {
        val uid = getUid(accessToken)
        return Unirest.get("$API_URL/users/show.json")
                .queryString("access_token", accessToken)
                .queryString("uid", uid)
                .asObject(WeiboUserInfo::class.java)
                .successBody()
    }
}
