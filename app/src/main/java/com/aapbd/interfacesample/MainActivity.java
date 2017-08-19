package com.aapbd.interfacesample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.aapbd.interfacesample.interfaces.Publish;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements Publish {

    private Context con;

    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        con=this;

        resultView=(TextView)findViewById(R.id.resultview);

    }

    /*
    On click action to start the calcutation.
     */

    public void clickFB(View v)
    {

        MyCal cal=new MyCal(this ,10,12);

        cal.Sum();

    }



    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void workStarted() {

        /*
        show progressbar if needed
         */

    }

    @Override
    public void result(Object result) {


        HashMap<String, String> data=(HashMap)result;


       StringBuffer buf=new StringBuffer();

        for(String key:data.keySet())
        {
            Log.e("task done ", "from main activity and value is "+result);

            buf.append(key+": "+data.get(key));
            buf.append("\n");

        }

        updateUI(buf);


    }

    @Override
    public void workFinished() {

          /*
Close progress bar
         */

    }


    private void updateUI(final StringBuffer buf) {


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                resultView.setText(buf);

            }
        });
    }
}
