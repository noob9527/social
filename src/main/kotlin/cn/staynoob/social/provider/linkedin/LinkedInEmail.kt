package cn.staynoob.social.provider.linkedin

import com.fasterxml.jackson.annotation.JsonProperty

data class LinkedInEmail(
        val elements: List<Element>
) {
    data class Element(
            @JsonProperty(value = "handle~")
            val handle_: Handle? = null,
            val type: String,
            val primary: Boolean = false
    )

    data class Handle(
            val emailAddress: String
    )
}
