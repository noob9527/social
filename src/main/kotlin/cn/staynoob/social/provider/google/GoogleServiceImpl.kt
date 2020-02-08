package cn.staynoob.social.provider.google

import cn.staynoob.social.provider.google.autoconfigure.GoogleProperties
import cn.staynoob.social.share.ApiException
import cn.staynoob.social.share.successBody
import kong.unirest.HttpResponse
import kong.unirest.Unirest
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
@ConditionalOnProperty(prefix = "social.google", name = ["client-id"])
class GoogleServiceImpl(
        private val properties: GoogleProperties
) : GoogleService {

    companion object {
        private val logger = LoggerFactory.getLogger(GoogleServiceImpl::class.java)
        private const val TOKEN_ENDPOINT = "https://oauth2.googleapis.com/token"
    }

    @PostConstruct
    fun postConstruct() {
        logger.info("register google service, clientId=${properties.clientId}")
    }

    internal fun <T : Any> HttpResponse<T>.googleSuccessBody(): T {
        return this.successBody(GoogleErrorResponse::class) {
            throw ApiException(message = "error=${it.error}, error_description=${it.error_description}")
        }
    }

    override fun code2token(request: GoogleCode2TokenRequest): GoogleToken {
        val req = Unirest.post(TOKEN_ENDPOINT)
                .field("code", request.code)
                .field("client_id", properties.clientId)
                .field("client_secret", properties.clientSecret)
                .field("redirect_uri", request.redirect_uri)
                .field("grant_type", "authorization_code")

        return req.asObject(GoogleToken::class.java).googleSuccessBody()
    }

    override fun refreshToken(request: GoogleRefreshTokenRequest): GoogleToken {
        val req = Unirest.post(TOKEN_ENDPOINT)
                .field("refresh_token", request.refreshToken)
                .field("client_id", properties.clientId)
                .field("client_secret", properties.clientSecret)
                .field("grant_type", "refresh_token")

        return req.asObject(GoogleToken::class.java).googleSuccessBody()
    }

    override fun revokeToken(token: String) {
        val req = Unirest.get(TOKEN_ENDPOINT)
                .queryString("token", token)
        req.asEmpty().googleSuccessBody()
    }

    override fun getUserInfo(accessToken: String): GoogleUserInfo {
        val req = Unirest.get("https://www.googleapis.com/oauth2/v2/userinfo")
                .header("Authorization", "Bearer $accessToken")
        return req.asObject(GoogleUserInfo::class.java).googleSuccessBody()
    }
}
