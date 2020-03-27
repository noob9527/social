package cn.staynoob.social.autoconfigure

import cn.staynoob.social.provider.wechat.WechatProperties
import cn.staynoob.social.provider.wechat.WechatService
import cn.staynoob.social.provider.wechat.WechatServiceImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.validation.annotation.Validated

@Configuration
@ConditionalOnProperty(prefix = "social.wechat", name = ["client-id"])
class WechatAutoConfiguration {

    @Bean
    @Validated
    @ConfigurationProperties(prefix = "social.wechat")
    fun wechatProperties(): WechatProperties {
        return WechatProperties()
    }

    @Bean
    @ConditionalOnMissingBean
    fun wechatService(wechatProperties: WechatProperties): WechatService {
        return WechatServiceImpl(wechatProperties)
    }
}
