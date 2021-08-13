package verzich.kotlinspringbootintro.v3_repository

import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<PersonEntity, Long> {
}