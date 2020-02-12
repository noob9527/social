package cn.staynoob.social.provider.facebook

import cn.staynoob.social.provider.facebook.autoconfigure.FacebookProperties
import cn.staynoob.social.share.ApiException
import cn.staynoob.social.share.Unirest
import cn.staynoob.social.share.successBody
import kong.unirest.HttpResponse
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.primaryConstructor

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
            throw ApiException(message = it.error.message)
        }
    }

    override fun code2token(request: FacebookCode2TokenRequest): FacebookToken {
        val req = Unirest.post("https://graph.facebook.com/v6.0/oauth/access_token")
                .queryString("code", request.code)
                .queryString("client_id", properties.clientId)
                .queryString("client_secret", properties.clientSecret)
                .queryString("redirect_uri", request.redirect_uri)

        return req.asObject(FacebookToken::class.java).facebookSuccessBody()
    }

    override fun getUserInfo(accessToken: String): FacebookUserInfo {
        val fields = FacebookUserInfo::class
                .primaryConstructor!!.parameters
                .joinToString(",") { it.name ?: "" }
//                .declaredMemberProperties
//                .joinToString(",") { it.name }
        val req = Unirest.get("https://graph.facebook.com/v6.0/me")
                .header("Authorization", "Bearer $accessToken")
                .queryString("fields", fields)
        return req.asObject(FacebookUserInfo::class.java).facebookSuccessBody()
    }
}
