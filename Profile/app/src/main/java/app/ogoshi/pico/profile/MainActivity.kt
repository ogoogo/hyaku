package app.ogoshi.pico.profile

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {

            profileImage.setImageResource(R.drawable.randy_image)
            profileLabelText.text = "名前"
            profileCommentText.text = "Androidメンターのランディだよ"
            button1.backgroundTintList = ColorStateList.valueOf(Color.rgb(0, 180, 220))
            button2.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            button3.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            button4.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        }

        button2.setOnClickListener {

            profileImage.setImageResource(R.drawable.baseball_image)
            profileLabelText.text = "スポーツ"
            profileCommentText.text = "野球観戦が好きで、スタジアムに通っている"
            button2.backgroundTintList = ColorStateList.valueOf(Color.rgb(220, 0, 100))
            button1.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            button3.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            button4.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))

        }

        button3.setOnClickListener {

            profileImage.setImageResource(R.drawable.donut_image)
            profileLabelText.text = "好きな食べ物"
            profileCommentText.text = "キャンディやドーナツが大好き"
            button3.backgroundTintList = ColorStateList.valueOf(Color.rgb(0, 180, 120))
            button2.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            button1.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            button4.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))

        }
        button4.setOnClickListener {

            profileImage.setImageResource(R.drawable.gadget_image)
            profileLabelText.text = "趣味"
            profileCommentText.text = "ガジェットを集めて動かすこと"
            button4.backgroundTintList = ColorStateList.valueOf(Color.rgb(220, 100, 0))
            button2.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            button3.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            button1.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))

        }


    }
}
//コード