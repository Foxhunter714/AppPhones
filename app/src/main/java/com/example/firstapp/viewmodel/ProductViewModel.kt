package com.example.firstapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.firstapp.model.db.ProductEntity
import com.example.firstapp.model.db.Repository

class ProductViewModel(application: Application): AndroidViewModel(application) {
    private var repository: Repository = Repository(application)
    var listProduct = repository.listProduct

    init {
        repository.loadApiData()

    }

    fun getDetails(param1: String): LiveData<ProductEntity> {
        return repository.getDetails(param1)
    }
}