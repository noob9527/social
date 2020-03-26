package cn.staynoob.social.provider.github.autoconfigure

import cn.staynoob.social.provider.github.GithubServiceImpl
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(prefix = "social.github", name = ["client-id"])
@EnableConfigurationProperties(GithubProperties::class)
@ImportAutoConfiguration(GithubServiceImpl::class)
class GithubAutoConfiguration
