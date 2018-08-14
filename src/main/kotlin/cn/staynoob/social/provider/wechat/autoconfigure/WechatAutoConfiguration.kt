package cn.staynoob.social.provider.wechat.autoconfigure

import cn.staynoob.social.provider.wechat.WechatService
import cn.staynoob.social.provider.wechat.WechatServiceImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(prefix = "social.wechat", name = ["app-id"])
@EnableConfigurationProperties(WechatProperties::class)
class WechatAutoConfiguration(
        private val properties: WechatProperties
) {
    @Bean
    @ConditionalOnMissingBean(WechatService::class)
    fun wechatService(): WechatService {
        return WechatServiceImpl()
    }
}