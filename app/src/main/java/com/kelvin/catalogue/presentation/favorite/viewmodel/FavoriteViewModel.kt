package com.kelvin.catalogue.presentation.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelvin.catalogue.data.utils.Resource
import com.kelvin.catalogue.domain.data.CatalogEntity
import com.kelvin.catalogue.domain.usecase.FetchCatalogUseCase
import com.kelvin.catalogue.presentation.favorite.state.FavoriteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val fetchCatalogUseCase: FetchCatalogUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(FavoriteState())
    val state = _state.asStateFlow()

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchCatalogUseCase.execute(Unit)
                .distinctUntilChanged()
                .collectLatest { result ->
                    when (result) {
                        is Resource.Success -> result.data?.let { data ->
                            onRequestSuccess(data)
                        }

                        is Resource.Error -> onRequestError(result.message)
                        is Resource.Loading -> onRequestLoading()
                    }
                }
        }
    }

    internal fun onRequestSuccess(
        data: List<CatalogEntity>
    ) {

        _state.update {
            it.copy(
                data = data,
                isLoading = false,
                error = ""
            )
        }
    }

    internal fun onRequestError(msg: String?) {
        _state.update {
            it.copy(
                error = msg
            )
        }
    }

    internal fun onRequestLoading() {
        if (_state.value.data.isEmpty()) {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }
        }
    }

}
