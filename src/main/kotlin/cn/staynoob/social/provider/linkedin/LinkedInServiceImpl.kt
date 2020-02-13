package cn.staynoob.social.provider.linkedin

import cn.staynoob.social.provider.linkedin.autoconfigure.LinkedInProperties
import cn.staynoob.social.share.ApiException
import cn.staynoob.social.share.SharedUnirest
import cn.staynoob.social.share.successBody
import kong.unirest.HttpResponse
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
@ConditionalOnProperty(prefix = "social.linkedin", name = ["client-id"])
class LinkedInServiceImpl(
        private val properties: LinkedInProperties
) : LinkedInService {

    companion object {
        private val logger = LoggerFactory.getLogger(LinkedInServiceImpl::class.java)
        private const val TOKEN_ENDPOINT = "https://www.linkedin.com/oauth/v2/accessToken"
    }

    @PostConstruct
    fun postConstruct() {
        logger.info("register linkedin service, clientId=${properties.clientId}")
    }

    internal fun <T : Any> HttpResponse<T>.linkedinSuccessBody(): T {
        return this.successBody(LinkedInErrorResponse::class) {
            throw ApiException(message = "error=${it.error}, error_description=${it.error_description}")
        }
    }

    override fun code2token(request: LinkedInCode2TokenRequest): LinkedInToken {
        val req = SharedUnirest.post(TOKEN_ENDPOINT)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .field("code", request.code)
                .field("client_id", properties.clientId)
                .field("client_secret", properties.clientSecret)
                .field("redirect_uri", request.redirect_uri)
                .field("grant_type", "authorization_code")

        return req.asObject(LinkedInToken::class.java).linkedinSuccessBody()
    }

    override fun getUserInfo(accessToken: String): LinkedInUserInfo {
        val email = getEmailAddress(accessToken)
        val emailAddress = email.elements
                .firstOrNull {
                    it.primary
                            && it.type == "EMAIL"
                            && it.handle_ != null
                }
                ?.handle_
                ?.emailAddress
                ?: ""

        val req = SharedUnirest.get("https://api.linkedin.com/v2/me?projection=(id,localizedFirstName,localizedLastName,profilePicture(displayImage~:playableStreams))")
                .header("Authorization", "Bearer $accessToken")
        return req.asObject(LinkedInUserInfo::class.java)
                .linkedinSuccessBody()
                .apply {
                    this.unstableEmailAddress = emailAddress
                }
    }

    private fun getEmailAddress(accessToken: String): LinkedInEmail {
        val req = SharedUnirest.get("https://api.linkedin.com/v2/clientAwareMemberHandles?q=members&projection=(elements*(primary,type,handle~))")
                .header("Authorization", "Bearer $accessToken")
        return req.asObject(LinkedInEmail::class.java).linkedinSuccessBody()
    }
}
