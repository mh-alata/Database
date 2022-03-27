package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText productQuantity, productName;
    TextView productID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bttnAdd = findViewById(R.id.bttnAdd);
        Button bttnFind = findViewById(R.id.bttnFind);
        Button bttnDelete = findViewById(R.id.bttnDelete);

        myDB= new DatabaseHelper(this);
        productID = (TextView) findViewById(R.id.productID);
        productQuantity=(EditText) findViewById(R.id.productQuantity);
        productName=(EditText) findViewById(R.id.productName);



        bttnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!myDB.addData("FirstItem","9"))
                    Toast.makeText(MainActivity.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
                myDB.addData("SecondItem","13");

                Toast.makeText(MainActivity.this, "Good", Toast.LENGTH_SHORT).show();
            }
        });

        bttnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor = myDB.structuredQuery(4);
                String cID = cursor.getString(0);
                String cName= cursor.getString(1);
                String cPrQuant = cursor.getString(2);
                
                Toast.makeText(MainActivity.this, cID + " , " + cName + " , " + cPrQuant, Toast.LENGTH_SHORT).show();


            }
        });

        bttnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}