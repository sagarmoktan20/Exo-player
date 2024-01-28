package com.example.exo_player





import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player

import com.example.exo_player.databinding.ActivityMedaiplayerBinding


class medaiplayerActivity : AppCompatActivity() {
    lateinit var binding:ActivityMedaiplayerBinding
    lateinit var player1: ExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMedaiplayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val url= intent.getStringExtra("url")
        val mediaItem=MediaItem.fromUri(url!!)

        player1=ExoPlayer.Builder(this).build()
        binding.playerView.player=player1

        player1.setMediaItem(mediaItem)
        player1.prepare()
        player1.play()
        player1.addListener(object :Player.Listener{
            override fun onPlayerError(error: PlaybackException) {
                Toast.makeText(applicationContext, "error in playing media", Toast.LENGTH_SHORT).show()
                super.onPlayerError(error)

            }
        })
    }

    override fun onStart() {
        super.onStart()
    player1.playWhenReady=true
    }

    override fun onStop() {
        super.onStop()
    player1.playWhenReady=false
    }

    override fun onDestroy() {
        super.onDestroy()
    player1.release()
    }
}