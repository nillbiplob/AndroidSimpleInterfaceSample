package com.aapbd.interfacesample;

import android.util.Log;

import com.aapbd.interfacesample.interfaces.Publish;

import java.util.HashMap;
import java.util.concurrent.Executors;

/**
 * Created by shafiulalambiplob on 17/8/2017.
 */

public class MyCal {

    private Publish publish;

    int a;
    int b;


    public MyCal(Publish publish, int a, int b) {

        this.publish = publish;
        this.a = a;
        this.b = b;


    }


    /*
    Sum method
     */

    public void Sum()
    {

       Runnable r=new  Runnable() {
            @Override
            public void run() {

                int result=0;

                for(int i=0; i<100;i++)
                {

                    Log.e("Print i=", i+"");

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    result+=i;

                }


                Log.e("task done", "call interface method to broadcast result");

                HashMap<String, String> map=new HashMap();
                map.put("value", result+"");
                map.put("status", "done");

                publish.result(map);


            }
        };

        /*
        let's run on different thread
         */
        Executors.newSingleThreadExecutor().submit(r);

    }


}
