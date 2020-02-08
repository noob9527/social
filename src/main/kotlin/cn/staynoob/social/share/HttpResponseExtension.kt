package cn.staynoob.social.share

import kong.unirest.HttpResponse
import kotlin.reflect.KClass

internal fun <T : Any, E : Any> HttpResponse<T>.successBody(
        errorClazz: KClass<E>,
        errorHandler: (E) -> Unit
): T {
    this.ifFailure(errorClazz.java) {
        if (this.status < 200 || status >= 300)
            throw HttpException(status, statusText)
        val error = it?.body ?: throw HttpException(it.status, it.statusText)
        errorHandler.invoke(error)
    }
    return body
}

