package cn.staynoob.social.share

import com.mashape.unirest.http.HttpResponse

internal val <T : Any> HttpResponse<T>.successBody: T
    get() {
        if (this.status < 200 || status >= 300)
            throw HttpException(status, statusText)
        return body
    }
