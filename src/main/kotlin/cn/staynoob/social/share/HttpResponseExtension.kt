package cn.staynoob.social.share

import kong.unirest.HttpResponse
import kotlin.reflect.KClass

internal fun <T : Any, E : Any> HttpResponse<T>.successBody(
        errorClazz: KClass<E>,
        errorHandler: (E) -> Unit
): T {
    this.ifFailure(errorClazz.java) {
        val error = it?.body
        if (error == null) {
            // if request error, and we cannot get useful hint
            if (this.status < 200 || status >= 300)
                throw HttpException(status, statusText)
            else {
                // request success, we cannot get body
                // highly likely we have a json parse error
                // we don't know how to catch that exception
                throw RuntimeException("unknown exception, maybe the vendor api has benn changed")
            }
        } else {
            errorHandler.invoke(error)
        }
    }
    return body
}

