package cn.staynoob.social.demo

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/test"], produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)])
class TestCtrl(
) {

    @GetMapping("/ping")
    fun ping(): String {
        return "pong"
    }

}
