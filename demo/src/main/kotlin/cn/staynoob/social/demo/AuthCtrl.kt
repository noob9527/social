package cn.staynoob.social.demo

import cn.staynoob.social.provider.github.GithubService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/auth"], produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)])
class AuthCtrl {

    @Autowired
    private lateinit var githubService: GithubService

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
