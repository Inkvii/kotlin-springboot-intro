package verzich.kotlinspringbootintro.v2_service

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import verzich.kotlinspringbootintro.v2_service.dto.CalculatorOperationEnum
import verzich.kotlinspringbootintro.v2_service.dto.CalculatorRequestDto

@RestController
@RequestMapping("/calculator", produces = ["application/json"])
class CalculatorController(private val calculatorService: CalculatorService) {


    @GetMapping("/{firstValue}/{operation}/{secondValue}")
    fun calculate(@PathVariable("firstValue") firstValue: Double,
                  @PathVariable("operation") operation: CalculatorOperationEnum,
                  @PathVariable("secondValue") secondValue: Double
    ): ResponseEntity<String> {

        val requestDto = CalculatorRequestDto(firstValue = firstValue, secondValue = secondValue, operationEnum = operation)

        try {
            val result = calculatorService.calculateResult(requestDto)
            return ResponseEntity.ok("$result")
        } catch (e: Exception) {
            return ResponseEntity.badRequest().body(e.message)
        }

    }
}