package verzich.kotlinspringbootintro.v3_repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TextRepository : JpaRepository<TextEntity, Long> {

    fun findAllBySaidById(saidById: Long): List<TextEntity>

    /**
     * parameter startingText is inserted in query as positional argument, so first input parameter of the method equals to "?1"
     */
    @Query("select t from text t where t.text like ?1%")
    fun findTextsThatStartWith(startingText: String): List<TextEntity>
}