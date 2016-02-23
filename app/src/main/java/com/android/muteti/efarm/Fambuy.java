package com.android.muteti.efarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by muteti on 1/10/16.
 */
public class Fambuy extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fambuy);
    }

    public void onButtonFam(View v)
    {
        if (v.getId() == R.id.Bfarmer)
        {
            Intent y = new Intent(Fambuy.this, MainActivity.class);
            startActivity(y);
        }

    }

    public void onButtonBuy(View v)
    {
        if (v.getId() == R.id.Bbuyer)
        {
            Intent u = new Intent(Fambuy.this,Category.class);
            startActivity(u);
        }
    }

}
