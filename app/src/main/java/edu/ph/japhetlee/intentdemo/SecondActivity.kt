package edu.ph.japhetlee.intentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.ph.japhetlee.intentdemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val message = intent.getStringExtra("message")
        if(message != null){
            binding.txtMessage.text = message
        }
    }
}