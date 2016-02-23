package com.android.muteti.efarm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by muteti on 1/8/16.
 */
public class Display extends Activity {
    Button viewMyAdds;
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String username = getIntent().getStringExtra("Username");
        viewMyAdds = (Button)findViewById(R.id.Bmyads);
        viewAdds();

        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);


    }

    public void onButtonPostA(View v)
    {
        if (v.getId() == R.id.Bpostad)
        {
            Intent u = new Intent(Display.this, PostAdvert.class);
            startActivity(u);
        }
    }


    public void viewAdds(){
        viewMyAdds.setOnClickListener(
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
                        showMessage("+", buffer.toString());

                    }
                }
        );
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }



}




