package com.medise.soccerscoreapp.ui.match_detail

import androidx.lifecycle.ViewModel
import com.medise.soccerscoreapp.data.repository.SoccerRepository
import com.medise.soccerscoreapp.domain.model.live_score.LiveScore
import com.medise.soccerscoreapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MatchDetailViewModel @Inject constructor(
    private val repository: SoccerRepository
) :ViewModel(){


}