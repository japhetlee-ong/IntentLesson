package edu.ph.japhetlee.intentdemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import edu.ph.japhetlee.intentdemo.databinding.ActivitySecondBinding
import edu.ph.japhetlee.intentdemo.databinding.ActivitySharedPrefBinding

class SharedPrefActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySharedPrefBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPrefBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference = getSharedPreferences("MY_PREF",Context.MODE_PRIVATE)
        val username = sharedPreference.getString("KEY_USERNAME",null)
        if(username !=null){
            binding.txtName.text = username
        }else{
            binding.txtName.text = "NO SAVED PREF YET"
        }

        binding.btnSave.setOnClickListener{
            if(binding.edtName.text.isNotEmpty()){
                val editor = sharedPreference.edit()
                editor.putString("KEY_USERNAME",binding.edtName.text.toString())
                editor.apply()
                binding.txtName.text = binding.edtName.text.toString()
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putBoolean("CONFIG_CHANGE",true)
        super.onSaveInstanceState(outState, outPersistentState)
    }
}