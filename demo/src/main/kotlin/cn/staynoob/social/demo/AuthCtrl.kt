package cn.staynoob.social.demo

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/auth"], produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)])
class AuthCtrl {

    @GetMapping("/ping")
    fun ping(): String {
        return "pong"
    }

    @PostMapping("/google")
    fun google(@RequestBody map: Map<String, Any?>) {
        println(map)
    }

    @PostMapping("/facebook")
    fun facebook(@RequestBody map: Map<String, Any?>) {
        println(map)
    }

    @PostMapping("/linkedin")
    fun linkedin(@RequestBody map: Map<String, Any?>) {
        println(map)
    }

}
