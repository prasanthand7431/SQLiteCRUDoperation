package com.example.prasanth.databasebb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    TextView textView;
    databaseb databaseb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.edit1);
        editText2=findViewById(R.id.edit2);
        editText3=findViewById(R.id.edit3);
        editText4=findViewById(R.id.edit4);
        editText5=findViewById(R.id.edit5);
        editText6=findViewById(R.id.edit6);
        textView=findViewById(R.id.text1);
        databaseb1=new databaseb(MainActivity.this);

    }

    public void saveus(View view){

        String s1=editText1.getText().toString();
        String s2=editText2.getText().toString();
        long h=databaseb1.saveit(s1,s2);
        Toast.makeText(this, "save successfully"+h, Toast.LENGTH_SHORT).show();

    }

    public void gett(View view) {

        String s3=editText3.getText().toString();
        String loc=databaseb1.gettt(s3);
        textView.setText(loc);

        }

    public void updateus(View view) {

        String s1=editText4.getText().toString();
        String s2=editText5.getText().toString();
        boolean isupdate=databaseb1.updateit(s1,s2);
        if (isupdate==true){

            Toast.makeText(this, "update successfully", Toast.LENGTH_SHORT).show();
        }
        else {

            Toast.makeText(this, "data not updated", Toast.LENGTH_SHORT).show();
        }

    }

    public void deleteus(View view) {

        String s1=editText3.getText().toString();
        Integer deleted=databaseb1.deletedatas(s1);
        Toast.makeText(this, "Data "+deleted, Toast.LENGTH_SHORT).show();
    }
}
