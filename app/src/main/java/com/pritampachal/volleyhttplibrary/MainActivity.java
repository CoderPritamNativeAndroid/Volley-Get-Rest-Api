package com.pritampachal.volleyhttplibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextStart,editTextEnd;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextStart=findViewById(R.id.editTextStartID);
        editTextEnd=findViewById(R.id.editTextEndID);
        button=findViewById(R.id.buttonSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (editTextStart.getText().toString().trim().equals("")) {
                        Toast.makeText(MainActivity.this, "Start-ID field Required", Toast.LENGTH_SHORT).show();
                    } else if (editTextEnd.getText().toString().trim().equals("")) {
                        Toast.makeText(MainActivity.this, "End-ID field Required", Toast.LENGTH_SHORT).show();
                    } else {
                        int int1,int2;
                        int1=Integer.parseInt(editTextStart.getText().toString().trim());
                        int2=Integer.parseInt(editTextEnd.getText().toString().trim());
                        if (int1 >= 1 && int1 <= 4999) {
                            if (int2 >= 2 && int2 <= 5000) {
                                if (int1 == int2) {
                                    Toast.makeText(MainActivity.this, "Start-ID & End-ID Same", Toast.LENGTH_SHORT).show();
                                } else {
                                    if (int1 > int2) {
                                        Toast.makeText(MainActivity.this, "Must be :: StartID < EndID", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                        intent.putExtra("num1", "" + int1);
                                        intent.putExtra("num2", "" + int2);
                                        startActivity(intent);
                                    }
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "End-ID Out of Range", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Start-ID Out of Range", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, ""+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
