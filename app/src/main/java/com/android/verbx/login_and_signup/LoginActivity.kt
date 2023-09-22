package com.android.verbx.login_and_signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.verbx.R
import com.android.verbx.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}