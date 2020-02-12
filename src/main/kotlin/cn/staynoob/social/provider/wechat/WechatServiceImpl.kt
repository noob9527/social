package cn.staynoob.social.provider.wechat

import cn.staynoob.social.share.ApiException
import cn.staynoob.social.share.successBody
import kong.unirest.HttpResponse
import cn.staynoob.social.share.Unirest

class WechatServiceImpl : WechatService {

    companion object {
        private const val API_URL = "https://api.weixin.qq.com"
    }

    internal fun <T : Any> HttpResponse<T>.wechatSuccessBody(): T {
        return this.successBody(WechatErrorResponse::class) {
            throw ApiException(
                    code = it.errcode,
                    message = it.errmsg
            )
        }
    }

    override fun getUserInfo(accessToken: String, openId: String): WechatUserInfo {
        return Unirest.get("$API_URL/sns/userinfo")
                .queryString("access_token", accessToken)
                .queryString("openid", openId)
                .asObject(WechatUserInfo::class.java)
                .wechatSuccessBody()
    }
}
