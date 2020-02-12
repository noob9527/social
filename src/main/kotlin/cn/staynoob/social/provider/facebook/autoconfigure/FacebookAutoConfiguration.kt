package cn.staynoob.social.provider.facebook.autoconfigure

import cn.staynoob.social.provider.facebook.FacebookServiceImpl
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(prefix = "social.facebook", name = ["client-id"])
@EnableConfigurationProperties(FacebookProperties::class)
@ImportAutoConfiguration(FacebookServiceImpl::class)
class FacebookAutoConfiguration
