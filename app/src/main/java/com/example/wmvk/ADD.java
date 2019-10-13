package com.example.wmvk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;



        public class ADD extends AppCompatActivity  {
            Button b3,b4;
            Button finish;
            String number="1";
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_add);
                b3=(Button)findViewById(R.id.camera);
                b4=(Button)findViewById(R.id.back);
                finish=(Button)findViewById(R.id.Finish);
                Intent f=getIntent();
                String s=f.getStringExtra("file");
                // Intent f= getIntent();
                final   String email,roll,machine,item,date,time,name,mobile,pay;
                email=f.getStringExtra("email");
                date=f.getStringExtra("file");
                roll=f.getStringExtra("roll");
                machine=f.getStringExtra("machine no");
                item=f.getStringExtra("item");
                time=f.getStringExtra("time");
                pay=f.getStringExtra("pay");
                mobile=f.getStringExtra("mobile");
                name=f.getStringExtra("name");

                String fb=email+date+roll+machine+item+time;
                Toast.makeText(ADD.this,fb,Toast.LENGTH_LONG).show();
                //  Toast.makeText(ADD.this,s,Toast.LENGTH_LONG).show();



                /*
                 */
                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                 /*   Intent inn;
                inn = new Intent(ADD.this,Add_image.class);
                startActivity(inn);
                //  Intent r=getIntent();
                //    tw=r.getStringExtra("t");
                //  t1.setText(tw);

                *///Toast.makeText(ADD.this,sd,Toast.LENGTH_LONG).show();
                        int i=0;
                        Intent add_image=new Intent(ADD.this,Add_image.class);
                        add_image.putExtra("image_name",Integer.toString(i));
                        startActivity(add_image);
                        //Intent Data;
                        //String f=Data.getData();



                    }
                });
                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ADD.super.onBackPressed();
                        //  Intent r=getIntent();
                        //    tw=r.getStringExtra("t");
                        //  t1.setText(tw);

                    }
                });

                finish.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int a1=0,a2=0,b1=0,b2=0,c1=0,c2=0,d1=0,d2=0,e1=0,e2=0;
                        EditText r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
                        r1=(EditText)findViewById(R.id.editText5);
                        a1=Integer.parseInt( r1.getText().toString());


                        r2=(EditText)findViewById(R.id.editText10);
                        a2=Integer.parseInt( r2.getText().toString());


                        r3=(EditText)findViewById(R.id.editText6);
                        b1=Integer.parseInt( r3.getText().toString());


                        r4=(EditText)findViewById(R.id.editText11);
                        b2=Integer.parseInt( r4.getText().toString());


                        r5=(EditText)findViewById(R.id.editText7);
                        c1=Integer.parseInt( r5.getText().toString());

                        r6=(EditText)findViewById(R.id.editText12);
                        c2=Integer.parseInt( r6.getText().toString());


                        r7=(EditText)findViewById(R.id.editText8);
                        d1=Integer.parseInt( r7.getText().toString());


                        r8=(EditText)findViewById(R.id.editText13);
                        d2=Integer.parseInt( r8.getText().toString());


                        r9=(EditText)findViewById(R.id.editText9);
                        e1=Integer.parseInt( r9.getText().toString());


                        r10=(EditText)findViewById(R.id.editText14);
                        e2=Integer.parseInt( r10.getText().toString());

                        ActivityCompat.requestPermissions(ADD.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

                        createPDF(v,Integer.toString(a1*a2),Integer.toString(b1*b2),Integer.toString(c1*c2),Integer.toString(d1*d2),Integer.toString(e1*e2),email,date,roll,machine,item,time,e1,e2,d1,d2,c1,c2,b1,b2,a1,a2,pay,mobile,name);



                    }
                });


            }
            public void  createPDF(View v,String q1,String q2,String q3,String q4,String q5,String email,String date,String roll ,String machine ,String item ,String time,int e1,int e2,int d1,int d2,int c1,int c2,int b1,int b2,int a1,int a2,String pay,String mobile,String name)
            {

                PdfDocument myPdf = new PdfDocument();
                PdfDocument.PageInfo mypag = new PdfDocument.PageInfo.Builder(600,1200,2).create();
                PdfDocument.Page mypage = myPdf.startPage(mypag);

                Paint mypain = new Paint();
                String mys;/// = e1.getText().toString();
                int y=25;

                String line1,line2,line3,line4,line5,line6,line7,line8,line9,line10,line11,line12,line91,line92,line93,line0;
                line0="Name              "+name+"\n";
                line1="Roll no."+"      "+roll+"\n";
                line2="Date"+"                 "+date+"\n";
                line3="Machine no "+"  "+machine+"\n";
                line4="Time"+"                 "+time+"\n";
                line5="Email"+"             "+email+"\n";
                line6="Mobile no"+"       "+mobile+"\n";
                line12="___________________________________________________________________________\n";
                line7="Type of Item             a.No of Item        b.RATE/Item         a X b  \n";
                line8="1) Shirt"+"                     "+a1+"               "+a2+"               "+q1+"\n";
                line9="2) T-Shirt                    "+b1+"              "+b2+"               "+q2+"\n";
                line91="3) Jeans                     "+c1+"              "+c2+"               "+q3+"\n";
                line92="4) Towels                "+d1+"               "+d2+"              "+q4+"\n";
                line93="5) Others                 "+e1+"              "+e2+"              "+q5+"\n";
                int g=Integer.parseInt(q1)+Integer.parseInt(q2)+Integer.parseInt(q3)+Integer.parseInt(q4)+Integer.parseInt(q5);
                line10="                                               Total"+"           "+Integer.toString(g)+"\n";
                line11=" PAYMENT STATUS                         "+pay+"\n" ;
                mys=line0+line1+line2+line3+line4+line5+line6+line12+line7+line8+line9+line91+line92+line93+line12+line10+line11+"\n\n"+"finish";
                for(String line:mys.split("\n")){
                    //
                    mypage.getCanvas().drawText(line,10,y,mypain);
                    y+=mypain.descent()-mypain.ascent();
                }


                myPdf.finishPage(mypage);
                String hil="/"+roll+".pdf";
                String namm= String.valueOf(Environment.getExternalStorageDirectory().getPath())+"second.pdf";


                try
                {
                    File myFile = new File(String.valueOf(Environment.getExternalStorageDirectory().getPath())+hil);
                    Toast.makeText(ADD.this,"file save",Toast.LENGTH_LONG).show();
                    FileOutputStream dk = new FileOutputStream(myFile);

                    myPdf.writeTo(dk);

                    Toast.makeText(ADD.this,String.valueOf(Environment.getExternalStorageDirectory().getPath()),Toast.LENGTH_LONG).show();

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    //  e1.setText("Error");
                    Toast.makeText(ADD.this,"Error",Toast.LENGTH_LONG).show();

                }
                myPdf.close();

            }
        }
    }
}
