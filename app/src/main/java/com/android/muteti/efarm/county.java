package com.android.muteti.efarm;

import android.app.Activity;
import android.content.Intent;
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
public class county extends Activity {
    Spinner spinner;
    Button btnSummit;
    ArrayAdapter<CharSequence>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.county);
        btnSummit=(Button)findViewById(R.id.Bnextcounty);
        selectCounty();
        spinner =(Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.county_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString()+" selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public  void selectCounty(){
        btnSummit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (spinner.getSelectedItem().toString().equals("Machakos")){
                            Intent y = new Intent(county.this, Shoppcentre.class);
                            startActivity(y);
                        }
                        else if (spinner.getSelectedItem().toString().equals("Kitui")) {
                            Intent j = new Intent(county.this, khoppcentre.class);
                            startActivity(j);
                        }

                    }
                }
        );

    }

}
