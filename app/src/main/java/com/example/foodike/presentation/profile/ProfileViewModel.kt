package com.example.foodike.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodike.domain.repository.LoginRepository
import com.example.foodike.presentation.login.LoginEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {


    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.PerformLogout -> {
              viewModelScope.launch()  {
                    repository.toggleLoginState()
                    event.onClick()
                }
            }
        }
    }
}