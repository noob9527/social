package cn.staynoob.social.provider.linkedin

import com.fasterxml.jackson.annotation.JsonProperty


data class LinkedInUserInfo(
        val id: String = "",
        val localizedFirstName: String = "",
        val localizedLastName: String = "",
        val profilePicture: ProfilePicture? = null,
        var unstableEmailAddress: String = ""
) {
    val unstablePictureUrls = profilePicture
            ?.displayImagePage
            ?.elements
            ?.mapNotNull { it.identifiers.firstOrNull()?.identifier }
            ?: emptyList()

    data class ProfilePicture(
            val displayImage: String? = null,
            @JsonProperty(value = "displayImage~")
            val displayImagePage: DisplayImagePage? = null
    )

    data class DisplayImagePage(
            val elements: List<DisplayImageElement> = emptyList()
    )

    data class DisplayImageElement(
            val identifiers: List<DisplayImageElementIdentifier> = emptyList()
    )

    data class DisplayImageElementIdentifier(
            val identifier: String = ""
    )
}
