package com.android.muteti.efarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by muteti on 1/12/16.
 */
public class Payment extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
    }

    public void OnButtonNext(View v)
    {
        if (v.getId() == R.id.BonNext)
        {
            Intent y = new Intent(Payment.this, Vcode.class);
            startActivity(y);
        }

    }
}



