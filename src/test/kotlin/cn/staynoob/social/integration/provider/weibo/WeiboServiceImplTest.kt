package cn.staynoob.social.integration.provider.weibo

import cn.staynoob.social.provider.weibo.WeiboService
import cn.staynoob.social.support.IntegrationTestBase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment

class WeiboServiceImplTest : IntegrationTestBase() {
    @Autowired
    private lateinit var service: WeiboService

    @Autowired
    private lateinit var env: Environment

    @Test
    @DisplayName("getUserInfo test")
    fun test100() {
        val accessToken = env.getProperty("social.weibo.accessToken")

        val res = service.getUserInfo(accessToken)

        assertThat(res).isNotNull()
    }
}