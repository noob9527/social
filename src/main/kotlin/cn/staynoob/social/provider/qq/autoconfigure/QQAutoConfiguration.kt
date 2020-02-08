package cn.staynoob.social.provider.qq.autoconfigure

import cn.staynoob.social.provider.qq.QQServiceImpl
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(prefix = "social.qq", name = ["client-id"])
@EnableConfigurationProperties(QQProperties::class)
@ImportAutoConfiguration(QQServiceImpl::class)
class QQAutoConfiguration(
        private val properties: QQProperties
)
