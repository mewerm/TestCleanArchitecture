package com.maximmesh.testcleanarchitecture.domain.usecase

import com.maximmesh.testcleanarchitecture.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam): Boolean{
        return param.name.isNotEmpty() //заглушка
    }
}