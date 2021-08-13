package verzich.kotlinspringbootintro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener
import verzich.kotlinspringbootintro.util.DatabaseUtils

@SpringBootApplication
class KotlinSpringbootIntroApplication(
        val databaseUtils: DatabaseUtils
) {
    @EventListener(ApplicationReadyEvent::class)
    fun fireEventAfterStart() {
        databaseUtils.fillDatabaseWithDefaultValues()
    }

}

fun main(args: Array<String>) {
    runApplication<KotlinSpringbootIntroApplication>(*args)
}
