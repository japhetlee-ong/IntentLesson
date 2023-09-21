package edu.ph.japhetlee.intentdemo

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.view.View.OnClickListener
import edu.ph.japhetlee.intentdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAlarm.setOnClickListener(this)
        binding.btnSendEmail.setOnClickListener(this)
        binding.btnNewActivity.setOnClickListener(this)
        binding.btnSharedPref.setOnClickListener(this)
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun onClick(p0: View?) {
        when(p0!!.id){
            (R.id.btn_alarm) ->
            {
                val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                    putExtra(AlarmClock.EXTRA_MESSAGE, "Test Message")
                    putExtra(AlarmClock.EXTRA_MINUTES,1)
                }

                if(intent.resolveActivity(packageManager) != null){
                    startActivity(intent)
                }
            }
            (R.id.btn_send_email) ->
            {
                val data = Uri.parse("mailto:")
                val email = arrayOf("jong@gmail.com","ong@gmail.com")
                var intent = Intent(Intent.ACTION_SENDTO).apply {
                    putExtra(Intent.EXTRA_EMAIL, email)
                    putExtra(Intent.EXTRA_SUBJECT, "This is a test message")
                }
                intent.data = data

                if(intent.resolveActivity(packageManager) != null){
                    startActivity(intent)
                }
            }
            (R.id.btn_new_activity) ->{
                val intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("message","Hello from Main Activity")
                startActivity(intent)
            }
            (R.id.btn_shared_pref) ->{
                val intent = Intent(this,SharedPrefActivity::class.java)
                startActivity(intent)
            }
        }
    }
}