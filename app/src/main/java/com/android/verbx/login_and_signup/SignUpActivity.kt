package com.android.verbx.login_and_signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.verbx.R
import com.android.verbx.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}