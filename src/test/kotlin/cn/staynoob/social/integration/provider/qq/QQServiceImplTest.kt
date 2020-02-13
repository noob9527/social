package cn.staynoob.social.integration.provider.qq

import cn.staynoob.social.provider.qq.QQService
import cn.staynoob.social.support.IntegrationTestBase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment

@Disabled
class QQServiceImplTest : IntegrationTestBase() {
    @Autowired
    private lateinit var service: QQService

    @Autowired
    private lateinit var env: Environment

    @Test
    @DisplayName("getUserInfo test")
    fun test100() {
        val accessToken = env.getProperty("social.qq.accessToken")!!

        val res = service.getUserInfo(accessToken)

        assertThat(res).isNotNull()
    }
}
