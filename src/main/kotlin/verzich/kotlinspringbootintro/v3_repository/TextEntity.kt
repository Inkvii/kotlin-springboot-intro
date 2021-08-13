package verzich.kotlinspringbootintro.v3_repository

import AbstractEntity
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity(name = "text")
@Table(name = "text")
class TextEntity(
        var text: String,
        @ManyToOne
        @JsonManagedReference
        val saidBy: PersonEntity
) : AbstractEntity() {

}