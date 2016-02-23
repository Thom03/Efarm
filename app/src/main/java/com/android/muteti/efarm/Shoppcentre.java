package com.android.muteti.efarm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by muteti on 1/10/16.
 */
public class Shoppcentre extends Activity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    Button Bnextcategory;

    Button btnSummit;
    DatabaseHelper helper = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppcentre);

        btnSummit=(Button)findViewById(R.id.Bshopcentres);
        viewAll();
        spinner =(Spinner)findViewById(R.id.spinner1);
        adapter = ArrayAdapter.createFromResource(this,R.array.shopping_centre,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString() + " selected", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void onButtonRad(View v)
    {
        if (v.getId() == R.id.Bnextcategory)
        {
            Intent y = new Intent(Shoppcentre.this, county.class);
            startActivity(y);
        }

    }

    public void  viewAll(){
        btnSummit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = helper.getAllData();
                        if (res.getCount() == 0){
                            //show message
                            showMessage("Error","No Data Found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("id :"+ res.getString(0)+"\n");
                            buffer.append("fproduce :"+ res.getString(1)+"\n");
                            buffer.append("price :"+ res.getString(2)+"\n");
                            buffer.append("quantity :"+ res.getString(3)+"\n");
                            buffer.append("contact1 :"+ res.getString(4)+"\n");
                            buffer.append("image :"+ res.getString(4)+"\n\n");

                        }
                        //show all data
                        showMessage("+", buffer.toString());
                    }
                }
        );
    }
    //new code

    //new code

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
