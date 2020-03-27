package cn.staynoob.social.autoconfigure

import cn.staynoob.social.provider.qq.QQServiceImpl
import cn.staynoob.social.provider.qq.QQProperties
import cn.staynoob.social.provider.qq.QQService
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.validation.annotation.Validated

@Configuration
@ConditionalOnProperty(prefix = "social.qq", name = ["client-id"])
class QQAutoConfiguration {

    @Bean
    @Validated
    @ConfigurationProperties(prefix = "social.qq")
    fun qqProperties(): QQProperties {
        return QQProperties()
    }

    @Bean
    @ConditionalOnMissingBean
    fun qqService(qqProperties: QQProperties): QQService {
        return QQServiceImpl(qqProperties)
    }
}
