package com.maximmesh.testcleanarchitecture.domain.repository

import com.maximmesh.testcleanarchitecture.domain.models.SaveUserNameParam
import com.maximmesh.testcleanarchitecture.domain.models.UserName

interface UserRepository {
    fun saveName( saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}