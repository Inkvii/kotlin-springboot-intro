package verzich.kotlinspringbootintro.v3_repository

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import verzich.kotlinspringbootintro.v3_repository.dto.TextRequest

@RestController
@RequestMapping("/text", produces = ["application/json"])
class TextController(
        private val textService: TextService
) {

    val log = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/getAll")
    fun getAll(): ResponseEntity<List<String>> {

        val result = textService.findAll()
        return ResponseEntity.ok(result)
    }

    @PostMapping("/getByStartingText", consumes = ["application/json"])
    fun getByStartingText(@RequestBody request: TextRequest): ResponseEntity<List<String>> {
        log.info("Request: ${request.text}")
        val result = textService.findTextsThatStartWith(request.text)
        return ResponseEntity.ok(result)
    }

    @PutMapping("/put/{personId}")
    fun putTextToPersonId(@PathVariable("personId") personId: Long, @RequestBody request: TextRequest): ResponseEntity<TextEntity> {
        log.info("Request: ${request}")

        val modifiedRequest = request.copy(personId = personId)
        val entity = textService.putTextToPersonId(modifiedRequest)
        log.info("Response: $entity")

        return ResponseEntity.ok(entity)
    }
}