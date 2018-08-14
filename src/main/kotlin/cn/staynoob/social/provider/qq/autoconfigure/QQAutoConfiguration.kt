package cn.staynoob.social.provider.qq.autoconfigure

import cn.staynoob.social.provider.qq.QQService
import cn.staynoob.social.provider.qq.QQServiceImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(prefix = "social.qq", name = ["app-id"])
@EnableConfigurationProperties(QQProperties::class)
class QQAutoConfiguration(
        private val properties: QQProperties
) {
    @Bean
    @ConditionalOnMissingBean(QQService::class)
    fun qqService(): QQService {
        return QQServiceImpl(properties)

    }
}