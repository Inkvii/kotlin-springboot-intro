package verzich.kotlinspringbootintro.v2_service.dto

enum class CalculatorOperationEnum {
    PLUS, MINUS, MULTIPLY, DIVIDE
}

data class CalculatorRequestDto(
        val firstValue: Double,
        val operationEnum: CalculatorOperationEnum,
        val secondValue: Double
)