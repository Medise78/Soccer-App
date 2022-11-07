package com.medise.soccerscoreapp.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medise.soccerscoreapp.data.repository.SoccerRepository
import com.medise.soccerscoreapp.domain.model.search_team.SearchTeam
import com.medise.soccerscoreapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: SoccerRepository
) : ViewModel() {

    private val _searchTeam = MutableStateFlow<Resource<SearchTeam>>(Resource.Loading())
    val searchTeam: StateFlow<Resource<SearchTeam>> get() = _searchTeam


    fun searchTeam(searchTeam: String) {
        viewModelScope.launch {
            fetchData(searchTeam)
        }
    }

    private suspend fun fetchData(team: String) {
        _searchTeam.value = Resource.Loading()
        try {
            repository.searchTeam(team).let {
                _searchTeam.value = Resource.Success(it)
            }
        } catch (e: Exception) {
            _searchTeam.value = Resource.Error(e.message ?: "Error")
        }
    }
}