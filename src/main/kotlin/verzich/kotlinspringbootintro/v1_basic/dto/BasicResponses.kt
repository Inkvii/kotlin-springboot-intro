package verzich.kotlinspringbootintro.v1_basic.dto

// equals, hashcode and tostring methods are generated automatically for data class
data class IndexPagePostResponse(
        val text: String, // mandatory (not null)
        val value: Long, // mandatory (not null)
        val serverText: String? //nullable
)