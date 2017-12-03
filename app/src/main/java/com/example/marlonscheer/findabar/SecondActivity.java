package com.example.marlonscheer.findabar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {


    private Handler handler = new Handler();

    private Button show;

    private Button logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        logout = (Button) findViewById(R.id.button2);






        new Thread(new Runnable() {
            @Override
            public void run() {


            }
        }).start();


        show = (Button) findViewById(R.id.ShowBoxes);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(SecondActivity.this, MapsActivity.class);
                startActivity(intent);


            }
        });



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(SecondActivity.this, "Successfully Logged Out...Bye ;)", Toast.LENGTH_LONG).show();

                finish();
            }
        });




    }
}
