package com.example.tsuji.hyakuninissyu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //インテントオブジェクトを取得。
        Intent intent = getIntent();
        //リスト画面から渡されたデータを取得。
        String lower = intent.getStringExtra("lower");

        //下の句を表示させるTextViewを取得。
        TextView tvLower = findViewById(R.id.tvLower);

        //TextViewに下の句を表示。
        tvLower.setText(lower);
    }

    /**
     * 戻るボタンをタップした時の処理。
     * @param view 画面部品。
     */
    public void onBackButtonClick1(View view) {
        finish();
    }
}
