package com.medise.soccerscoreapp.ui.leader_board

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medise.soccerscoreapp.data.repository.SoccerRepository
import com.medise.soccerscoreapp.domain.model.league_standing.LeagueStanding
import com.medise.soccerscoreapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeaderBoardViewModel @Inject constructor(
    private val repository: SoccerRepository,
) : ViewModel() {

    private val _getLeaderBoard = MutableStateFlow<Resource<LeagueStanding>>(Resource.Loading())
    val getLeaderBoard: StateFlow<Resource<LeagueStanding>> get() = _getLeaderBoard

    fun loadSeason(seasonId:Int){
        loadData(seasonId)
    }

    private fun loadData(seasonId: Int) = viewModelScope.launch {
        try {
            repository.getLeagueStandingById(seasonId).let {
                _getLeaderBoard.value = Resource.Success(it)
            }
        } catch (e: Exception) {
            _getLeaderBoard.value = Resource.Error(e.message ?: "Error")
        }
    }
}