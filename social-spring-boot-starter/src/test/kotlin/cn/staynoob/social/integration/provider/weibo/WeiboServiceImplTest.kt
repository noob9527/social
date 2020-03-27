package cn.staynoob.social.integration.provider.weibo

import cn.staynoob.social.IntegrationTestBase
import cn.staynoob.social.provider.weibo.WeiboCode2TokenRequest
import cn.staynoob.social.provider.weibo.WeiboService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.core.env.Environment

@Disabled
@EnableAutoConfiguration // somehow we need this to run the test
class WeiboServiceImplTest : IntegrationTestBase() {
    @Autowired
    private lateinit var service: WeiboService

    @Autowired
    private lateinit var env: Environment

    @Test
    @Disabled
    @DisplayName("get token test")
    fun test100() {
        val request = WeiboCode2TokenRequest(
                code = env.getProperty("social.weibo.code")!!,
                redirect_uri = env.getProperty("social.weibo.redirect-uri")!!
        )
        val res = service.code2token(request)
        println(res)
        assertThat(res.access_token).isNotBlank()
    }

    @Test
    @Disabled
    @DisplayName("getUserInfo test")
    fun test200() {
        val accessToken = env.getProperty("social.weibo.accessToken")!!
        val res = service.getUserInfo(accessToken)
        println(res)
        assertThat(res).isNotNull
    }
}
