package com.alex_bystrov.ktorrequestsexample.features.characters.di

import com.alex_bystrov.ktorrequestsexample.features.characters.api.CharacterRepository
import com.alex_bystrov.ktorrequestsexample.features.characters.api.CharacterRepositoryImpl
import com.alex_bystrov.ktorrequestsexample.features.characters.api.ktor.KtorDataSource
import com.alex_bystrov.ktorrequestsexample.features.characters.api.ktor.KtorRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorDataSource).bind<KtorRepository>()
    singleOf(::CharacterRepositoryImpl).bind<CharacterRepository>()
}