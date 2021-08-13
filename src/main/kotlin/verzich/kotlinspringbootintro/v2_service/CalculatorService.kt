package verzich.kotlinspringbootintro.v2_service

import org.springframework.stereotype.Service
import verzich.kotlinspringbootintro.v2_service.dto.CalculatorOperationEnum
import verzich.kotlinspringbootintro.v2_service.dto.CalculatorRequestDto

@Service
class CalculatorService {

    fun calculateResult(calculationRequestDto: CalculatorRequestDto): Double {
        when (calculationRequestDto.operationEnum) {
            CalculatorOperationEnum.PLUS -> return plus(calculationRequestDto.firstValue, calculationRequestDto.secondValue)
            CalculatorOperationEnum.MINUS -> return minus(calculationRequestDto.firstValue, calculationRequestDto.secondValue)
            CalculatorOperationEnum.MULTIPLY -> return multiply(calculationRequestDto.firstValue, calculationRequestDto.secondValue)
            CalculatorOperationEnum.DIVIDE -> return divide(calculationRequestDto.firstValue, calculationRequestDto.secondValue)
        }
    }

    private fun plus(firstValue: Double, secondValue: Double): Double {
        return firstValue + secondValue
    }

    private fun minus(firstValue: Double, secondValue: Double): Double {
        return firstValue - secondValue
    }

    private fun multiply(firstValue: Double, secondValue: Double): Double {
        return firstValue * secondValue
    }

    private fun divide(firstValue: Double, secondValue: Double): Double {
        val result = firstValue / secondValue

        if (result.isNaN() || result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) {
            throw IllegalArgumentException("Try some normal numbers instead")
        }

        return result
    }
}