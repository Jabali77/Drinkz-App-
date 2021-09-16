package com.vijanaweusi.cocktailzapp.ui.cocktails

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vijanaweusi.CockTailsRepository
import com.vijanaweusi.model.response.CockTailsCategoryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CockTailsCategoriesViewModel(private val repository: CockTailsRepository = CockTailsRepository()) :
    ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val cockTails = getCockTails()
            cockTailsState.value = cockTails
        }
    }

    val cockTailsState: MutableState<List<CockTailsCategoryResponse.CockTailsResponse>> = mutableStateOf(emptyList())

    private suspend fun getCockTails(): List<CockTailsCategoryResponse.CockTailsResponse> {
        return repository.getCockTails().drinks
    }
}