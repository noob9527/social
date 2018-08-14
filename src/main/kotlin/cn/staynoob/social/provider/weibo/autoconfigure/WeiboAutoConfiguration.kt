package cn.staynoob.social.provider.weibo.autoconfigure

import cn.staynoob.social.provider.weibo.WeiboService
import cn.staynoob.social.provider.weibo.WeiboServiceImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(prefix = "social.weibo", name = ["app-id"])
@EnableConfigurationProperties(WeiboProperties::class)
class WeiboAutoConfiguration(
        private val properties: WeiboProperties
) {
    @Bean
    @ConditionalOnMissingBean(WeiboService::class)
    fun weiboService(): WeiboService {
        return WeiboServiceImpl()
    }
}