package com.example.wmvk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        t1=(TextView)findViewById(R.id.textView);
        b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent ni=new Intent(MainActivity.this,Date_reader.class);
                        startActivity(ni);
                        //  Intent r=getIntent();
                        //     =r.getStringExtra("t");
                        //  t1.setText(tw);


                    }
                });





            }


        }
    }
}
