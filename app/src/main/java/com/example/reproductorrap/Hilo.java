package com.example.reproductorrap;


import android.util.Log;

public class Hilo extends Thread {

    public void run(){

        try {

            Thread.sleep(2000);

            Log.d("Etiqueta 1", "Resultado.....");

        }catch (InterruptedException e){

            e.printStackTrace();

        }

    }

}