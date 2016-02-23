package com.android.muteti.efarm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by muteti on 1/8/16.
 */
public class SignUp extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onSignUpClick (View v)
    {
        if (v.getId() == R.id.Bsignupbut)
        {
            EditText name = (EditText)findViewById(R.id.Tfname);
            EditText uname = (EditText)findViewById(R.id.Tfuname);
            EditText pass1 = (EditText)findViewById(R.id.Tfpass1);
            EditText pass2 = (EditText)findViewById(R.id.Tfpass2);
            EditText idno = (EditText)findViewById(R.id.Tfidno);
            EditText phoneno = (EditText)findViewById(R.id.Tfphoneno);
            EditText county = (EditText)findViewById(R.id.Tfcounty);
            EditText shopcentre = (EditText)findViewById(R.id.Tfshopcentre);

            String namestr = name.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();
            String idnostr = idno.getText().toString();
            String phonenostr = phoneno.getText().toString();
            String countystr = county.getText().toString();
            String shopcentrestr = shopcentre.getText().toString();

            if (!pass1str.equals(pass2str))
            {
                //popup message
                Toast pass = Toast.makeText(SignUp.this ,"Passwords don't match!" , Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                //insert the details in database
                Contact c = new Contact();
                c.setName(namestr);
                c.setUname(unamestr);
                c.setPass(pass1str);
                c.setIdno(idnostr);
                c.setPhoneno(phonenostr);
                c.setCounty(countystr);
                c.setShopcentre(shopcentrestr);

                helper.insertContact(c);

            }
            Toast.makeText(SignUp.this,"Data Inserted",Toast.LENGTH_LONG).show();




        }
    }




}
