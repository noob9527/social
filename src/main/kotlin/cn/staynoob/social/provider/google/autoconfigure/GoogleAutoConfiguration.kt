package cn.staynoob.social.provider.google.autoconfigure

import cn.staynoob.social.provider.google.GoogleServiceImpl
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(prefix = "social.google", name = ["client-id"])
@EnableConfigurationProperties(GoogleProperties::class)
@ImportAutoConfiguration(GoogleServiceImpl::class)
class GoogleAutoConfiguration
