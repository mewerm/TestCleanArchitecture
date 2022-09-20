package com.maximmesh.testcleanarchitecture.domain.usecase

import com.maximmesh.testcleanarchitecture.domain.models.SaveUserNameParam
import com.maximmesh.testcleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getName()

        if(oldUserName.firstName == param.name){
            return true
        }

        return userRepository.saveName(saveParam = param)
    }
}