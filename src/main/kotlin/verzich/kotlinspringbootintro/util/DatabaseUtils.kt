package verzich.kotlinspringbootintro.util

import org.springframework.stereotype.Component
import verzich.kotlinspringbootintro.v3_repository.PersonEntity
import verzich.kotlinspringbootintro.v3_repository.PersonRepository
import verzich.kotlinspringbootintro.v3_repository.TextEntity

@Component
class DatabaseUtils(
        private val personRepository: PersonRepository
) {
    fun fillDatabaseWithDefaultValues() {
        val person1 = PersonEntity("alice")
        person1.saidTexts.add(TextEntity("I said", person1))
        person1.saidTexts.add(TextEntity("Something really matters", person1))
        person1.saidTexts.add(TextEntity("But then what is", person1))
        person1.saidTexts.add(TextEntity("I know right?", person1))

        personRepository.save(person1)
    }
}