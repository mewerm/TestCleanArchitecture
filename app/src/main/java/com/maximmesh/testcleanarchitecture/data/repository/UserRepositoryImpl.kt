package com.maximmesh.testcleanarchitecture.data.repository

import android.content.Context
import com.maximmesh.testcleanarchitecture.domain.models.SaveUserNameParam
import com.maximmesh.testcleanarchitecture.domain.models.UserName
import com.maximmesh.testcleanarchitecture.domain.repository.UserRepository
import com.maximmesh.testcleanarchitecture.utils.DEFAULT_NAME
import com.maximmesh.testcleanarchitecture.utils.KEY_FIRST_NAME
import com.maximmesh.testcleanarchitecture.utils.KEY_LAST_NAME
import com.maximmesh.testcleanarchitecture.utils.SHARED_PREFS_NAME

class UserRepositoryImpl(context: Context): UserRepository { //data слой это уже не бизнес логика и она имеет право работать с кониекстом

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParam): Boolean {

        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply()
        return true
    }

    override fun getName(): UserName {

        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "")?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME)?: DEFAULT_NAME

        return UserName(firstName = firstName, lastName = lastName)
    }
}