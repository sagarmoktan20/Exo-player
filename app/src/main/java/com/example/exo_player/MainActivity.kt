package com.example.exo_player

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exo_player.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val url="https://storage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
            gotoplayerPage(url)
        }
        binding.button2.setOnClickListener {
            val url="https://storage.googleapis.com/gtv-videos-bucket/sample/Sintel.jpg"
            gotoplayerPage(url)
        }
        binding.button3.setOnClickListener {
            val url="https://firebasestorage.googleapis.com/v0/b/musichub-621e3.appspot.com/o/songs%2FKhalid_-_Young_Dumb_%26_Broke_(Official_Video)(256k).mp3?alt=media&token=5be6078a-80aa-4723-9978-844e90504c1c"
            gotoplayerPage(url)
        }
    }
    fun gotoplayerPage(url:String){
        val intent=Intent(this,medaiplayerActivity::class.java)
        intent.putExtra("url",url)
        startActivity(intent)
    }
}