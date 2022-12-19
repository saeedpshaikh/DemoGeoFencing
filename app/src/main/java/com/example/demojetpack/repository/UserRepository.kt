package com.example.demojetpack.repository

import androidx.lifecycle.MutableLiveData
import com.example.demojetpack.api.UserAPI
import com.example.demojetpack.models.ExampleJson2KtKotlin
import com.example.demojetpack.utils.NetworkResult
import com.example.demojetpack.utils.NetworkResult.Success
import javax.inject.Inject

class UserRepository @Inject constructor(private val userAPI: UserAPI) {

    private val _userResponseLiveDataOne = MutableLiveData<NetworkResult<List<ExampleJson2KtKotlin>>>()
    val userResponseLiveData: MutableLiveData<NetworkResult<List<ExampleJson2KtKotlin>>>
        get() = _userResponseLiveDataOne


    suspend fun getLocationData() {
        _userResponseLiveDataOne.postValue(NetworkResult.Loading())
        val response = userAPI.getLocation()
        if (response.isSuccessful && response.body() != null) {
            _userResponseLiveDataOne.postValue(Success(response.body()!!))
        } else if (response.errorBody() != null) {

            _userResponseLiveDataOne.postValue(NetworkResult.Error(response.errorBody().toString() ))
        } else {
            _userResponseLiveDataOne.postValue(NetworkResult.Error("Something Went Wrong"))
        }
    }

}