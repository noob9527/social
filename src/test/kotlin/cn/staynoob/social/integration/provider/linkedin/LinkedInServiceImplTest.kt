package cn.staynoob.social.integration.provider.linkedin

import cn.staynoob.social.provider.linkedin.LinkedInCode2TokenRequest
import cn.staynoob.social.provider.linkedin.LinkedInService
import cn.staynoob.social.support.IntegrationTestBase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment

@Disabled
class LinkedInServiceImplTest : IntegrationTestBase() {
    @Autowired
    private lateinit var service: LinkedInService
    @Autowired
    private lateinit var env: Environment

    @Test
    @Disabled
    @DisplayName("get token test")
    fun test100() {
        val request = LinkedInCode2TokenRequest(
                code = env.getProperty("social.linkedin.code")!!,
                redirect_uri = env.getProperty("social.linkedin.redirect-uri")!!
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
                accessToken = env.getProperty("social.linkedin.access-token")!!
        )
        println(res)
        println(res.unstablePictureUrls)
        assertThat(res.id).isNotBlank()
    }
}
