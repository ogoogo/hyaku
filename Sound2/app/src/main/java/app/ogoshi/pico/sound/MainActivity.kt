package app.ogoshi.pico.sound

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drumSound = MediaPlayer.create(this, R.raw.drum_sound)

        drumImage.setOnTouchListener { view, event ->

            if (event.action == MotionEvent.ACTION_DOWN) {
                drumImage.setImageResource(R.drawable.drum_playing_image)
                drumSound.seekTo(0)
                drumSound.start()
            }


            else if (event.action == MotionEvent.ACTION_UP){
                drumImage.setImageResource(R.drawable.drum_image)
            }
            true

               }
    }
}