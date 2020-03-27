package cn.staynoob.social.provider.weibo

data class WeiboToken(
        val access_token: String,
        val remind_in: String,
        val expires_in: Int
)
