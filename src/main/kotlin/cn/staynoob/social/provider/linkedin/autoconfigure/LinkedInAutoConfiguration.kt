package cn.staynoob.social.provider.linkedin.autoconfigure

import cn.staynoob.social.provider.linkedin.LinkedInServiceImpl
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(prefix = "social.linkedin", name = ["client-id"])
@EnableConfigurationProperties(LinkedInProperties::class)
@ImportAutoConfiguration(LinkedInServiceImpl::class)
class LinkedInAutoConfiguration
