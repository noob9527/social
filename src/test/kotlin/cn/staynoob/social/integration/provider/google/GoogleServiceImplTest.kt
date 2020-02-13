package cn.staynoob.social.integration.provider.google

import cn.staynoob.social.provider.google.GoogleCode2TokenRequest
import cn.staynoob.social.provider.google.GoogleRefreshTokenRequest
import cn.staynoob.social.provider.google.GoogleService
import cn.staynoob.social.support.IntegrationTestBase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment

@Disabled
class GoogleServiceImplTest : IntegrationTestBase() {
    @Autowired
    private lateinit var service: GoogleService
    @Autowired
    private lateinit var env: Environment

    @Test
    @Disabled
    @DisplayName("get token test")
    fun test100() {
        val request = GoogleCode2TokenRequest(
                code = env.getProperty("social.google.code")!!,
                redirect_uri = env.getProperty("social.google.redirect-uri")!!
        )
        val res = service.code2token(request)
        println(res)
        assertThat(res.access_token).isNotBlank()
    }

    @Test
    @Disabled
    @DisplayName("refresh token test")
    fun test200() {
        val request = GoogleRefreshTokenRequest(
                refreshToken = env.getProperty("social.google.refresh-token")!!
        )
        val res = service.refreshToken(request)
        println(res)
        assertThat(res.access_token).isNotBlank()
        assertThat(res.refresh_token).isNull()
    }

    @Test
    @Disabled
    @DisplayName("get user info")
    fun test300() {
        val res = service.getUserInfo(
                accessToken = env.getProperty("social.google.access-token")!!
        )
        println(res)
    }
}
