package com.android.muteti.efarm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by muteti on 1/8/16.
 */
public class PostAdvert extends Activity   {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postadvert);

    }


    public void onPostClick(View v)
    {
        if (v.getId() == R.id.Bsubmit1) {


            EditText produce = (EditText) findViewById(R.id.Tfproduct);
            EditText price = (EditText) findViewById(R.id.Tfprice);
            EditText quantity = (EditText) findViewById(R.id.Tfquantity);
            EditText contact1 = (EditText) findViewById(R.id.Tfcontact);
            EditText image = (EditText) findViewById(R.id.Tfimage);


            String producestr = produce.getText().toString();
            String pricestr = price.getText().toString();
            String quantitystr = quantity.getText().toString();
            String contact1str = contact1.getText().toString();
            String imagestr = image.getText().toString();

            if (contact1str.equals(quantitystr))
            {
                //popup message
                Toast pass = Toast.makeText(PostAdvert.this ,"Passwords don't match!" , Toast.LENGTH_SHORT);
                pass.show();
            }
            else {


                Contact y = new Contact();
                y.setFproduce(producestr);
                y.setPrice(pricestr);
                y.setQuantity(quantitystr);
                y.setContact1(contact1str);
                y.setImage(imagestr);
                helper.insertContact2(y);
            }

            boolean onPostClick;
            if (onPostClick = true){
                 Toast.makeText(PostAdvert.this ,"You have successfully added new advert!" , Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(PostAdvert.this ,"something is wrong!" , Toast.LENGTH_LONG).show();

            }


        }








    }


}







