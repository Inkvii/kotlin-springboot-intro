package verzich.kotlinspringbootintro.v3_repository

import AbstractEntity
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity(name = "person")
@Table(name = "person")
class PersonEntity(
        val name: String,
        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "saidBy")
        @JsonBackReference
        val saidTexts: MutableList<TextEntity> = mutableListOf()
) : AbstractEntity() {

}