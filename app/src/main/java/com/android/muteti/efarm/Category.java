package com.android.muteti.efarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by muteti on 1/10/16.
 */
public class Category extends Activity {

    public static RadioGroup radio_g;
    public static RadioButton radio_cabb,radio_pota,radio_maiz,radio_bean;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
    }

    public void onButtonRad(View v)
    {
        if (v.getId() == R.id.Bnextcategory)
        {
            Intent y = new Intent(Category.this, county.class);
            startActivity(y);
        }

    }
}
