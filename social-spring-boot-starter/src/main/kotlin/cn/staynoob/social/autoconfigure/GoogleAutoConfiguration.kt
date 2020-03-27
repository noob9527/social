package cn.staynoob.social.autoconfigure

import cn.staynoob.social.provider.google.GoogleProperties
import cn.staynoob.social.provider.google.GoogleService
import cn.staynoob.social.provider.google.GoogleServiceImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.validation.annotation.Validated

@Configuration
@ConditionalOnProperty(prefix = "social.google", name = ["client-id"])
class GoogleAutoConfiguration {
    @Bean
    @Validated
    @ConfigurationProperties(prefix = "social.google")
    fun googleProperties(): GoogleProperties {
        return GoogleProperties()
    }

    @Bean
    @ConditionalOnMissingBean
    fun googleService(googleProperties: GoogleProperties): GoogleService {
        return GoogleServiceImpl(googleProperties)
    }
}
