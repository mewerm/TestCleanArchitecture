package com.maximmesh.testcleanarchitecture.domain.usecase

import com.maximmesh.testcleanarchitecture.domain.models.UserName
import com.maximmesh.testcleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}