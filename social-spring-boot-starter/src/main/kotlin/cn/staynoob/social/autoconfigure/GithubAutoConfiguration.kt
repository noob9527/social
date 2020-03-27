package cn.staynoob.social.autoconfigure

import cn.staynoob.social.provider.github.GithubProperties
import cn.staynoob.social.provider.github.GithubService
import cn.staynoob.social.provider.github.GithubServiceImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.validation.annotation.Validated

@Configuration
@ConditionalOnProperty(prefix = "social.github", name = ["client-id"])
class GithubAutoConfiguration {
    @Bean
    @Validated
    @ConfigurationProperties(prefix = "social.github")
    fun githubProperties(): GithubProperties {
        return GithubProperties()
    }

    @Bean
    @ConditionalOnMissingBean
    fun githubService(githubProperties: GithubProperties): GithubService {
        return GithubServiceImpl(githubProperties)
    }
}
