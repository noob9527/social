package cn.staynoob.social.provider.weibo.autoconfigure

import cn.staynoob.social.kotlin.KotlinAllOpen
import cn.staynoob.social.kotlin.NoArgConstructor
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotNull

@Validated
@KotlinAllOpen
@NoArgConstructor
@ConfigurationProperties(prefix = "social.weibo")
class WeiboProperties(
        @get: NotNull
        var appId: String? = null,
        @get: NotNull
        var appSecret: String? = null
)