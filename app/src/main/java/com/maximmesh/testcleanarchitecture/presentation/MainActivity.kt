package com.maximmesh.testcleanarchitecture.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maximmesh.testcleanarchitecture.databinding.ActivityMainBinding
import com.maximmesh.testcleanarchitecture.domain.models.SaveUserNameParam
import com.maximmesh.testcleanarchitecture.domain.models.UserName
import com.maximmesh.testcleanarchitecture.domain.usecase.GetUserNameUseCase
import com.maximmesh.testcleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    //пока примитивно, без dagger или hint. Простота и примитив для лучшего понимания.
    // +Просто вот он доступ из слоя presentation к классам, которые решают бизнес-логику
    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            sendButton.setOnClickListener {
                //клик по кнопке Save data
                val text = dataEditText.text.toString()
                val params = SaveUserNameParam(name = text)
                val result: Boolean = saveUserNameUseCase.execute(param = params)

                dataTextView.text = "Save result = $result"
            }

            receiveButton.setOnClickListener {
                //клик по кнопке Get data
                val userName: UserName = getUserNameUseCase.execute()
                dataTextView.text = "${userName.firstName}${userName.lastName}"
            }
        }
    }
}
