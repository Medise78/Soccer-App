package com.medise.soccerscoreapp.ui.team_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medise.soccerscoreapp.data.repository.SoccerRepository
import com.medise.soccerscoreapp.domain.model.team_detail.TeamDetail
import com.medise.soccerscoreapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    private val repository: SoccerRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _getTeamDetail = MutableStateFlow<Resource<TeamDetail>>(Resource.Loading())
    val getTeamDetail: StateFlow<Resource<TeamDetail>> get() = _getTeamDetail

    init {
        savedStateHandle.get<Int>("teamId")?.let {
            observerData(it)
        }
    }

    private fun observerData(teamId: Int) = viewModelScope.launch {
        try {
            repository.getTeamDetailById(teamId).let {
                _getTeamDetail.value = Resource.Success(it)
            }
        } catch (e: Exception) {
            _getTeamDetail.value = Resource.Error(e.message ?: "Error")
        }
    }
}