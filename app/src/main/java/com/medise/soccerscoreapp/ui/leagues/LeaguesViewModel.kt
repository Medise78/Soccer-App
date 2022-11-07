package com.medise.soccerscoreapp.ui.leagues

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medise.soccerscoreapp.data.repository.SoccerRepository
import com.medise.soccerscoreapp.domain.model.leagues.Leagues
import com.medise.soccerscoreapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeaguesViewModel @Inject constructor(
    private val repository: SoccerRepository
) :ViewModel(){

    private val _getLeagues = MutableStateFlow<Resource<Leagues>>(Resource.Loading())
    val getLeagues:StateFlow<Resource<Leagues>> get() = _getLeagues

    init {
        fetchData()
    }

    private fun fetchData() = viewModelScope.launch {
        try {
            repository.getAllLeague().let {
                _getLeagues.value = Resource.Success(it)
            }
        }catch (e:Exception){
            _getLeagues.value = Resource.Error(e.message?:"Error")
        }
    }
}