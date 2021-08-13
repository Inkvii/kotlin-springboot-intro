package verzich.kotlinspringbootintro.v1_basic

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import verzich.kotlinspringbootintro.v1_basic.dto.IndexPagePostRequest
import verzich.kotlinspringbootintro.v1_basic.dto.IndexPagePostResponse

@RestController
class BasicController {

    val log = LoggerFactory.getLogger(this.javaClass)


    @GetMapping("/", produces = ["application/json"])
    fun getIndexPage(): ResponseEntity<String> {
        return ResponseEntity.ok("This is an index page")
    }

    @PostMapping("/", consumes = ["application/json"], produces = ["application/json"])
    fun postMyRequestToIndexPage(@RequestBody request: IndexPagePostRequest): ResponseEntity<IndexPagePostResponse> {
        log.info("Request is ${request}")

        val response = IndexPagePostResponse(request.text, request.value, "I am optional string")

        log.info("Response is ${response}")
        return ResponseEntity.ok(response)
    }
}