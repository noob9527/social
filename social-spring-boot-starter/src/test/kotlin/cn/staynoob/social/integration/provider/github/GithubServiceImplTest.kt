package cn.staynoob.social.integration.provider.github

import cn.staynoob.social.provider.github.GithubCode2TokenRequest
import cn.staynoob.social.provider.github.GithubService
import cn.staynoob.social.IntegrationTestBase
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment

@Disabled
class GithubServiceImplTest : IntegrationTestBase() {
    @Autowired
    private lateinit var service: GithubService
    @Autowired
    private lateinit var env: Environment

    @Test
    @Disabled
    @DisplayName("get token test")
    fun test100() {
        val request = GithubCode2TokenRequest(
                code = env.getProperty("social.github.code")!!,
                redirect_uri = env.getProperty("social.github.redirect-uri")!!
        )
        val res = service.code2token(request)
        println(res)
        Assertions.assertThat(res.access_token).isNotBlank()
    }

    @Test
    @Disabled
    @DisplayName("get user info")
    fun test200() {
        val res = service.getUserInfo(
                accessToken = env.getProperty("social.github.access-token")!!
        )
        println(res)
    }
}
