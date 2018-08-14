package cn.staynoob.social.share

import com.fasterxml.jackson.core.JsonProcessingException
import com.mashape.unirest.http.ObjectMapper
import com.mashape.unirest.http.Unirest
import java.io.IOException


private val unirestObjectMapper = object : ObjectMapper {
    override fun <T : Any?> readValue(value: String, valueType: Class<T>): T {
        return try {
            objectMapper.readValue(value, valueType)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    override fun writeValue(value: Any): String {
        return try {
            objectMapper.writeValueAsString(value)
        } catch (e: JsonProcessingException) {
            throw RuntimeException(e)
        }
    }
}

internal fun initUnrest() {
    Unirest.setObjectMapper(unirestObjectMapper)
}

