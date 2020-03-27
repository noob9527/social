package cn.staynoob.social.autoconfigure

import cn.staynoob.social.provider.linkedin.LinkedInProperties
import cn.staynoob.social.provider.linkedin.LinkedInService
import cn.staynoob.social.provider.linkedin.LinkedInServiceImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.validation.annotation.Validated

@Configuration
@ConditionalOnProperty(prefix = "social.linkedin", name = ["client-id"])
class LinkedInAutoConfiguration {
    @Bean
    @Validated
    @ConfigurationProperties(prefix = "social.linkedin")
    fun linkedInProperties(): LinkedInProperties {
        return LinkedInProperties()
    }

    @Bean
    @ConditionalOnMissingBean
    fun linkedInService(linkedInProperties: LinkedInProperties): LinkedInService {
        return LinkedInServiceImpl(linkedInProperties)
    }
}
