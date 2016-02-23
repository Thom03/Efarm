package com.android.muteti.efarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by muteti on 1/19/16.
 */
public class Vcode extends Activity {
    EditText vericode;
    Button Btvericode;

    DatabaseHelper helper = new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vcode);
        vericode = (EditText) findViewById(R.id.Tfcode);
        Btvericode =(Button) findViewById(R.id.Bverify);
        OnButtonVerrify();
    }

    public void OnButtonVerrify() {
        Btvericode.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(vericode.getText().toString().equals("JKDH1231") ||
                                vericode.getText().toString().equals("H52BGS")){
                            Intent i = new Intent(Vcode.this, SignUp.class);
                            startActivity(i);
                            Vcode.this.finish();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Invalid Verification Code",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );



    }

}
