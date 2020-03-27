package cn.staynoob.social.provider.github

import cn.staynoob.social.share.ApiException
import cn.staynoob.social.share.configUnirest
import cn.staynoob.social.share.successBody
import kong.unirest.HttpResponse
import kong.unirest.Unirest
import kong.unirest.UnirestInstance
import org.slf4j.LoggerFactory

class GithubServiceImpl(
        private val properties: GithubProperties
) : GithubService {

    companion object {
        private val logger = LoggerFactory.getLogger(GithubServiceImpl::class.java)
        private const val TOKEN_ENDPOINT = "https://github.com/login/oauth/access_token"
    }

    private val githubUnirest: UnirestInstance

    init {
        logger.info("register github service, clientId=${properties.clientId}")
        githubUnirest = Unirest.spawnInstance().apply {
            configUnirest(this)
            if (properties.proxy != null) {
                config().proxy(properties.proxy.host, properties.proxy.port)
            }
        }
    }

    internal fun <T : Any> HttpResponse<T>.githubSuccessBody(): T {
        return this.successBody(GithubErrorResponse::class) {
            throw ApiException(message = "error=${it.error}, error_description=${it.error_description}")
        }
    }

    override fun code2token(request: GithubCode2TokenRequest): GithubToken {
        val internalReq = InternalGithubCode2TokenRequest(
                request.code,
                request.redirect_uri,
                request.state,
                properties.clientId,
                properties.clientSecret
        )
        val req = githubUnirest.post(TOKEN_ENDPOINT)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(internalReq)
        return req.asObject(GithubToken::class.java).githubSuccessBody()
    }

    override fun getUserInfo(accessToken: String): GithubUserInfo {
        val req = githubUnirest.get("https://api.github.com/user")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "token $accessToken")
        return req.asObject(GithubUserInfo::class.java).githubSuccessBody()
    }
}
