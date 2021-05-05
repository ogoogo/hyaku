package com.example.tsuji.hyakuninissyu;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    protected JSONObject jObj = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jObj = createJson();

        Iterator<String> keys = jObj.keys();
        ///全てのキーを取得

        //画面部品ListViewを取得
        ListView lvMenu = findViewById(R.id.lvUpper);

        //SimpleAdapterで使用するListオブジェクトを用意。
        List<Map<String, String>> menuList = new ArrayList<>();

        while(keys.hasNext()){
            String key = keys.next();
            String value = null;
            Map<String, String> menu = new HashMap<>();
            menu.put("upper", key);
            menuList.add(menu);
        }

        //SimpleAdapter第4引数from用データの用意。
        String[] from = {"upper"};
        //SimpleAdapter第5引数to用データの用意。
        int[] to = {android.R.id.text1};
        //SimpleAdapterを生成。
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, menuList, android.R.layout.simple_list_item_1, from, to);
        //アダプタの登録。
        lvMenu.setAdapter(adapter);

        //リストタップのリスナクラス登録。
        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    /**
     * リストがタップされたときの処理が記述されたメンバクラス。
     */
    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //タップされた行のデータを取得。SimpleAdapterでは1行分のデータはMap型!
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);
            //定食名と金額を取得。
            String menuName = item.get("upper");

            //インテントオブジェクトを生成。
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            //第2画面に送るデータを格納。
            String value = null;
            try {
                value = jObj.getString(menuName);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            intent.putExtra("lower", value);
            //第2画面の起動。
            startActivity(intent);
        }
    }

    public JSONObject createJson() {
        Resources res = this.getResources();
        InputStream in = res.openRawResource(R.raw.foo);          //        URL resource = new URL(MainActivity.class.getResource("."),"foo.json");

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder strbuilder = new StringBuilder();
        String inputStr = null;
        JSONObject jsonObject = null;
        try {
            while ((inputStr = br.readLine()) != null) {
                Log.v("TestData", "inputStr:" + inputStr);
                strbuilder.append(inputStr);
            }
            br.close();
            jsonObject = new JSONObject(strbuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
            e.printStackTrace();
        }

        return jsonObject;
    }
}
