package com.alex_bystrov.ktorrequestsexample.features.characters.api.ktor

import com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.model.CharacterModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KtorRequestModel(
    @SerialName("info")
    val info: CharacterInfoModel,

    @SerialName("results")
    val results: List<Character>
)

@Serializable
data class CharacterInfoModel(
    @SerialName("count")
    val count: Int,

    @SerialName("pages")
    val pages: Int
)

@Serializable
data class Character(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("status")
    val status: String,

    @SerialName("gender")
    val gender: String,

    @SerialName("image")
    val imageUrl: String
)

fun Character.mapToCharacterModel(): CharacterModel =
    CharacterModel(
        id = id,
        name = name,
        status = status,
        gender = gender,
        imageUrl = imageUrl
    )