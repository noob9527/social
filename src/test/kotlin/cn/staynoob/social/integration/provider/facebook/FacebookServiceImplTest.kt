package cn.staynoob.social.integration.provider.facebook

import cn.staynoob.social.provider.facebook.FacebookCode2TokenRequest
import cn.staynoob.social.provider.facebook.FacebookService
import cn.staynoob.social.support.IntegrationTestBase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment

class FacebookServiceImplTest : IntegrationTestBase() {
    @Autowired
    private lateinit var service: FacebookService
    @Autowired
    private lateinit var env: Environment

    @BeforeEach
    fun setUp() {
        System.setProperty("http.proxyHost", "localhost")
        System.setProperty("http.proxyPort", "1081")
        System.setProperty("https.proxyHost", "localhost")
        System.setProperty("https.proxyPort", "1081")
    }

    @Test
    @Disabled
    @DisplayName("get token test")
    fun test100() {
        val request = FacebookCode2TokenRequest(
                code = env.getProperty("social.facebook.code")!!,
                redirect_uri = env.getProperty("social.facebook.redirect-uri")!!
        )
        val res = service.code2token(request)
        println(res)
        assertThat(res.access_token).isNotBlank()
    }

    @Test
    @Disabled
    @DisplayName("get user info")
    fun test300() {
        val res = service.getUserInfo(
                accessToken = env.getProperty("social.facebook.access-token")!!
        )
        println(res)
    }
}