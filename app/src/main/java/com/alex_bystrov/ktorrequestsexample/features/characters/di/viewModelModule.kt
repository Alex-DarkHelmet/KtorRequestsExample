package com.alex_bystrov.ktorrequestsexample.features.characters.di

import com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.CharacterListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CharacterListViewModel(get()) }
}