package com.maximmesh.testcleanarchitecture.domain.usecase

import com.maximmesh.testcleanarchitecture.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
     return UserName(firstName = "Иван", lastName = "Иванович") //хардкор
    }
}