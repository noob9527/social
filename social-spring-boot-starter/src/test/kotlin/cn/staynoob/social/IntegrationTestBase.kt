package cn.staynoob.social

import cn.staynoob.social.autoconfigure.*
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
        WeiboAutoConfiguration::class,
        GoogleAutoConfiguration::class,
        GithubAutoConfiguration::class,
        LinkedInAutoConfiguration::class,
        FacebookAutoConfiguration::class
)
@ContextConfiguration(initializers = [ConfigFileApplicationContextInitializer::class])
@ActiveProfiles("default", "test-integration")
abstract class IntegrationTestBase
