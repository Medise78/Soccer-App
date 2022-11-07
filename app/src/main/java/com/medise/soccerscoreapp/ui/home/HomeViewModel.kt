package com.medise.soccerscoreapp.ui.home

import android.annotation.SuppressLint
import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.medise.soccerscoreapp.data.repository.SoccerRepository
import com.medise.soccerscoreapp.domain.model.leagues.Leagues
import com.medise.soccerscoreapp.domain.model.live_score.LiveScore
import com.medise.soccerscoreapp.service.Notifier
import com.medise.soccerscoreapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
@RequiresApi(Build.VERSION_CODES.M)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: SoccerRepository,
    application: Application
) : AndroidViewModel(application) {

    private val _getMatchScores = MutableStateFlow<Resource<LiveScore>>(Resource.Loading())
    val getMatchScore: StateFlow<Resource<LiveScore>> get() = _getMatchScores
    private val _getLeagues = MutableStateFlow<Resource<Leagues>>(Resource.Loading())
    val getLeagues: StateFlow<Resource<Leagues>> get() = _getLeagues

    val context = application.applicationContext!!

    init {
        fetchData()
    }

    fun reload() {
        fetchData()
    }

    private fun fetchData() = viewModelScope.launch {
        try {
            repository.getLiveScore().let {
                if (it.data!!.isNotEmpty()) {
                    _getMatchScores.value = Resource.Success(it)

                    Notifier(context).sendNotification(it.data[0] , true)
                }
                currentCoroutineContext().ensureActive()
            }
            repository.getAllLeague().let {
                _getLeagues.value = Resource.Success(it)
                currentCoroutineContext().ensureActive()
            }
        } catch (e: Exception) {
            _getMatchScores.value = Resource.Error(e.message ?: "Error")
        }
    }


    private fun CoroutineScope.refreshData(
        refreshTime: Long,
        onRefresh: () -> Unit
    ) = this.async {
        while (isActive) {
            delay(refreshTime)
            onRefresh()
        }
    }
}