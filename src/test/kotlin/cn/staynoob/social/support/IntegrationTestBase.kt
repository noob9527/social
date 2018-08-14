package cn.staynoob.social.support

import cn.staynoob.social.autoconfigure.SocialAutoConfiguration
import cn.staynoob.social.provider.qq.autoconfigure.QQAutoConfiguration
import cn.staynoob.social.provider.wechat.autoconfigure.WechatAutoConfiguration
import cn.staynoob.social.provider.weibo.autoconfigure.WeiboAutoConfiguration
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ImportAutoConfiguration(
        SocialAutoConfiguration::class,
        QQAutoConfiguration::class,
        WechatAutoConfiguration::class,
        WeiboAutoConfiguration::class
)
@ContextConfiguration(initializers = [ConfigFileApplicationContextInitializer::class])
@ActiveProfiles("default", "test-integration")
abstract class IntegrationTestBase
