package com.example.wmvk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Environment;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.DateFormat;
import java.util.Calendar;



    public class Date_reader extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
        String s,r1;
        int d=100;
        EditText e1,e2,e3,e4,e5,e6,e7;
        RadioGroup radiogroup;
        RadioButton radioButton;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_date_reader);
            Button Next=(Button)findViewById(R.id.Next);
            radiogroup=findViewById(R.id.radiogroup);
            Button select=(Button)findViewById(R.id.select);
            e1=(EditText)findViewById(R.id.editText) ; //roll
            e2=(EditText)findViewById(R.id.editText2) ; //email
            e3=(EditText)findViewById(R.id.editText3) ; //time
            e4=(EditText)findViewById(R.id.editText4) ;// machine
            e5=(EditText)findViewById(R.id.no_item) ;//item
            e6=(EditText)findViewById(R.id.editText16); // name
            e7=(EditText)findViewById(R.id.editText15) ;//mobile
            select.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    d=50;
                    DialogFragment datepicker=new DatePickerFragment();
                    datepicker.show(getSupportFragmentManager(),"date picker");
                }
            });

            Next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in=new Intent(Date_reader.this,ADD.class);
                    if(d==50)
                    {
                        r1= e1.getText().toString();
                        String s1,s2,s3,s4,s5,s6,s7;
                        s4=e4.getText().toString();
                        s2=e2.getText().toString();
                        s1=e1.getText().toString();
                        s3=e3.getText().toString();
                        s5=e5.getText().toString();
                        s6=e6.getText().toString();
                        s7=e7.getText().toString();
                        in.putExtra("file",s);


                        //  ss=e1.getText().toString();
                        if(e1.getText().toString().length()==0){
                            s1="#####";
                        }
                        if(e2.getText().toString().length()==0){
                            s2="#####";
                        } if(e3.getText().toString().length()==0){
                        s3="#####";
                    } if(e4.getText().toString().length()==0){
                        s4="#####";
                    } if(e5.getText().toString().length()==0){
                        s5="#####";
                    }
                        if(e6.getText().toString().length()==0){
                            s6="#####";
                        }
                        if(e7.getText().toString().length()==0){
                            s7="#####";
                        }
                        int radioId=radiogroup.getCheckedRadioButtonId();
                        radioButton=findViewById(radioId);

                        String pay ;
                        pay=radioButton.getText().toString();
                        in.putExtra("machine no",s4);
                        in.putExtra("email",s2);
                        in.putExtra("roll",s1);
                        in.putExtra("time",s3);
                        in.putExtra("item",s5);
                        in.putExtra("pay",pay);
                        in.putExtra("name",s6);
                        in.putExtra("mobile",s7);
                        //File file=new File(context,Environment.getExternalStorageDirectory()+"\\Injoy");
                        // in.putExtra(s,"First select Date");
                        startActivity(in);

                    }
                    else
                    {
                        //in.putExtra(s,"First select Date");
                        Toast.makeText(Date_reader.this,"some thing wrong",Toast.LENGTH_LONG);
                    }

                }
            });
      /*  public int checkButton(View v)
        {
            int radioId=radiogroup.getCheckedRadioButtonId();

            radioButton=findViewById(radioId);

        }*/
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Calendar c= Calendar.getInstance();
            c.set(Calendar.YEAR,year);
            c.set(Calendar.MONTH,month);
            c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
            TextView Date=(TextView)findViewById(R.id.Date);
            Date.setText(currentDateString);
            s=currentDateString;
            d=50;
        }
    }



}
