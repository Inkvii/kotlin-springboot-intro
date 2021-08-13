package verzich.kotlinspringbootintro.v3_repository.dto

data class TextRequest(
        val text: String,
        val personId: Long?
)