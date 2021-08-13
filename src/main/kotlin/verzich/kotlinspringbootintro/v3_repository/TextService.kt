package verzich.kotlinspringbootintro.v3_repository

import org.springframework.stereotype.Service
import verzich.kotlinspringbootintro.v3_repository.dto.TextRequest

@Service
class TextService(
        private val textRepository: TextRepository,
        private val personRepository: PersonRepository
) {

    fun findAll(): List<String> {
        val allTexts = textRepository.findAll()
                .map { entity -> entity.text }
                .toList()

        return allTexts
    }

    fun findTextsThatStartWith(startsWith: String): List<String> {
        val textStartingWith = textRepository.findTextsThatStartWith(startsWith)
                .map { entity -> entity.text }
                .toList()

        return textStartingWith
    }

    fun putTextToPersonId(textRequest: TextRequest): TextEntity {
        if (textRequest.personId == null) {
            throw IllegalArgumentException("Person id cannot be null")
        }

        val person = personRepository.findById(textRequest.personId).orElseThrow { Exception("Couldnt find person in database") }
        return textRepository.save(TextEntity(textRequest.text, person))
    }
}