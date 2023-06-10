package hello.hellospring.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {

    @GetMapping("/hello")
    fun hello(model: Model): String {
        model.addAttribute("data", "hello!")
        return "hello"
    }

    @GetMapping("hello-mvc")
    fun helloMvc(@RequestParam(value = "name", defaultValue = "test") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "hello-template"
    }

    @GetMapping("hello-string")
    @ResponseBody // HTTP 통신의 Body 부분에, 데이터를 직접 넣어주겠다
    fun helloString(@RequestParam("name") name: String): String {
        return "hello, $name" // 문자가 그대로 내려감 (뷰 템플릿 엔진 사용 x)
    }

    @GetMapping("hello-api")
    @ResponseBody // json 방식으로 내려줌
    fun helloApi(@RequestParam("name") name: String): Hello {
        return Hello(name = name)
    }

    data class Hello(
        var name: String = ""
    )
}