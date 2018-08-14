package cn.staynoob.social.integration.provider.wechat

import cn.staynoob.social.provider.wechat.WechatService
import cn.staynoob.social.support.IntegrationTestBase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment

class WechatServiceImplTest : IntegrationTestBase() {
    @Autowired
    private lateinit var service: WechatService

    @Autowired
    private lateinit var env: Environment

    @Test
    @DisplayName("getUserInfo test")
    fun test100() {
        val accessToken = env.getProperty("social.wechat.accessToken")
        val openId = env.getProperty("social.wechat.openId")

        val res = service.getUserInfo(accessToken, openId)

        assertThat(res).isNotNull()
    }
}