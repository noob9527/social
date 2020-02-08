package cn.staynoob.social.provider.wechat.autoconfigure

import cn.staynoob.social.provider.wechat.WechatServiceImpl
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(prefix = "social.wechat", name = ["client-id"])
@EnableConfigurationProperties(WechatProperties::class)
@ImportAutoConfiguration(WechatServiceImpl::class)
class WechatAutoConfiguration(
        private val properties: WechatProperties
)
