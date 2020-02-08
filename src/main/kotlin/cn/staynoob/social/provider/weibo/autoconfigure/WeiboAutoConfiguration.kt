package cn.staynoob.social.provider.weibo.autoconfigure

import cn.staynoob.social.provider.weibo.WeiboServiceImpl
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(prefix = "social.weibo", name = ["client-id"])
@EnableConfigurationProperties(WeiboProperties::class)
@ImportAutoConfiguration(WeiboServiceImpl::class)
class WeiboAutoConfiguration
