package cn.staynoob.social.provider.facebook

import cn.staynoob.social.provider.facebook.autoconfigure.FacebookProperties
import cn.staynoob.social.share.ApiException
import cn.staynoob.social.share.successBody
import kong.unirest.HttpResponse
import cn.staynoob.social.share.Unirest
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
@ConditionalOnProperty(prefix = "social.facebook", name = ["client-id"])
class FacebookServiceImpl(
        private val properties: FacebookProperties
) : FacebookService {

    companion object {
        private val logger = LoggerFactory.getLogger(FacebookServiceImpl::class.java)
        private const val TOKEN_ENDPOINT = "https://oauth2.facebookapis.com/token"
    }

    @PostConstruct
    fun postConstruct() {
        logger.info("register facebook service, clientId=${properties.clientId}")
    }

    internal fun <T : Any> HttpResponse<T>.facebookSuccessBody(): T {
        return this.successBody(FacebookErrorResponse::class) {
            throw ApiException(message = "error=${it.error}, error_description=${it.error_description}")
        }
    }

    override fun code2token(request: FacebookCode2TokenRequest): FacebookToken {
        val req = Unirest.post(TOKEN_ENDPOINT)
                .field("code", request.code)
                .field("client_id", properties.clientId)
                .field("client_secret", properties.clientSecret)
                .field("redirect_uri", request.redirect_uri)
                .field("grant_type", "authorization_code")

        return req.asObject(FacebookToken::class.java).facebookSuccessBody()
    }

    override fun refreshToken(request: FacebookRefreshTokenRequest): FacebookToken {
        val req = Unirest.post(TOKEN_ENDPOINT)
                .field("refresh_token", request.refreshToken)
                .field("client_id", properties.clientId)
                .field("client_secret", properties.clientSecret)
                .field("grant_type", "refresh_token")

        return req.asObject(FacebookToken::class.java).facebookSuccessBody()
    }

    override fun revokeToken(token: String) {
        val req = Unirest.get(TOKEN_ENDPOINT)
                .queryString("token", token)
        req.asEmpty().facebookSuccessBody()
    }

    override fun getUserInfo(accessToken: String): FacebookUserInfo {
        val req = Unirest.get("https://www.facebookapis.com/oauth2/v2/userinfo")
                .header("Authorization", "Bearer $accessToken")
        return req.asObject(FacebookUserInfo::class.java).facebookSuccessBody()
    }
}
