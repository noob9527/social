package cn.staynoob.social.autoconfigure

import cn.staynoob.social.provider.weibo.WeiboProperties
import cn.staynoob.social.provider.weibo.WeiboServiceImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.validation.annotation.Validated

@Configuration
@ConditionalOnProperty(prefix = "social.weibo", name = ["client-id"])
class WeiboAutoConfiguration {

    @Bean
    @Validated
    @ConfigurationProperties(prefix = "social.weibo")
    fun weiboProperties(): WeiboProperties {
        return WeiboProperties()
    }

    @Bean
    @ConditionalOnMissingBean
    fun weiboService(weiboProperties: WeiboProperties): WeiboServiceImpl {
        return WeiboServiceImpl(weiboProperties)
    }
}
