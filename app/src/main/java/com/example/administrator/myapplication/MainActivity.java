package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doGet(View view){
        //1.拿到okhttpclient对象
        OkHttpClient okHttpClient=new OkHttpClient();//全局执行者
        //2.构造Request
        Request.Builder builder=new Request.Builder();
        Request request=builder.get().url("http://www.imooc.com/").build();
        //3将Request封装为Call
        Call call=okHttpClient.newCall(request);
        //4执行call
        /*try {
            Response response=call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                L.e("onFailure"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                L.e(" onResponse:");
                String res=response.body().string();
                L.e(res);
            }
        });

    }
}
