package cn.staynoob.social.autoconfigure

import cn.staynoob.social.provider.facebook.FacebookProperties
import cn.staynoob.social.provider.facebook.FacebookService
import cn.staynoob.social.provider.facebook.FacebookServiceImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.validation.annotation.Validated

@Configuration
@ConditionalOnProperty(prefix = "social.facebook", name = ["client-id"])
class FacebookAutoConfiguration {
    @Bean
    @Validated
    @ConfigurationProperties(prefix = "social.facebook")
    fun facebookProperties(): FacebookProperties {
        return FacebookProperties()
    }

    @Bean
    @ConditionalOnMissingBean
    fun facebookService(facebookProperties: FacebookProperties): FacebookService {
        return FacebookServiceImpl(facebookProperties)
    }
}
