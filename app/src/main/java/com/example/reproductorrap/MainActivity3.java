package com.example.reproductorrap;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    Button play_pause, btn_repetir,btn4;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;

    MediaPlayer vectormp [] = new MediaPlayer [23];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        play_pause = (Button)findViewById(R.id.btn_play);
        btn_repetir = (Button)findViewById(R.id.btn_repetir);
        iv = (ImageView)findViewById(R.id.imageView2);
        btn4=(Button)findViewById(R.id.btn4);


        vectormp[0] = MediaPlayer.create(this, R.raw.race);
        vectormp[1] = MediaPlayer.create(this, R.raw.sound);
        vectormp[2] = MediaPlayer.create(this, R.raw.tea);
        vectormp[3] = MediaPlayer.create(this, R.raw.babygirl);
        vectormp[4] = MediaPlayer.create(this, R.raw.keepitgangsta);
        vectormp[5] = MediaPlayer.create(this, R.raw.smile);
        vectormp[6] = MediaPlayer.create(this, R.raw.money);
        vectormp[7] = MediaPlayer.create(this, R.raw.ateenagerinlove);
        vectormp[8] = MediaPlayer.create(this, R.raw.bomboro);
        vectormp[9] = MediaPlayer.create(this, R.raw.bulebule);
        vectormp[10] = MediaPlayer.create(this, R.raw.danzon);
        vectormp[11] = MediaPlayer.create(this, R.raw.despeinada);
        vectormp[12] = MediaPlayer.create(this, R.raw.donna);
        vectormp[13] = MediaPlayer.create(this, R.raw.dreamlover);
        vectormp[14] = MediaPlayer.create(this, R.raw.florecita);
        vectormp[15] = MediaPlayer.create(this, R.raw.lollipop);
        vectormp[16] = MediaPlayer.create(this, R.raw.musita);
        vectormp[17] = MediaPlayer.create(this, R.raw.nereidas);
        vectormp[18] = MediaPlayer.create(this, R.raw.quizas);
        vectormp[19] = MediaPlayer.create(this, R.raw.sherry);
        vectormp[20] = MediaPlayer.create(this, R.raw.sway);
        vectormp[21] = MediaPlayer.create(this, R.raw.whydontyoudoright);
        vectormp[22] = MediaPlayer.create(this, R.raw.diossiperdona);
    }
    public void Boton4(View view){
        btn4 = (Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                Toast.makeText(getApplicationContext(), "Inicio", Toast.LENGTH_SHORT).show();

                startActivity(i);
            }
        });
    }



    //Método para el botón PlayPause

    public void PlayPause(View view){
        if(vectormp[posicion].isPlaying()){//nos dira si se esta reproduccioendo una cacncion
            vectormp[posicion].pause();//a la hora de precionar el boton pausa , pausara la muscia
            play_pause.setBackgroundResource(R.drawable.reproducir);//aqui cambiara la imagen del boton de pausa a reproducir
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        } else {
            vectormp[posicion].start();//si no se esta reproducciendo se empezara a reproducir
            play_pause.setBackgroundResource(R.drawable.pausa);//si esta reproduciendo cambia el aspecto del boton a pausa
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    //Método para el botón Stop
    public void Stop(View view){
        if(vectormp[posicion] != null){
            vectormp[posicion].stop();

            vectormp[0] = MediaPlayer.create(this, R.raw.race);
            vectormp[1] = MediaPlayer.create(this, R.raw.sound);
            vectormp[2] = MediaPlayer.create(this, R.raw.tea);
            vectormp[3] = MediaPlayer.create(this, R.raw.babygirl);
            vectormp[4] = MediaPlayer.create(this, R.raw.keepitgangsta);
            vectormp[5] = MediaPlayer.create(this, R.raw.smile);
            vectormp[6] = MediaPlayer.create(this, R.raw.money);
            vectormp[7] = MediaPlayer.create(this, R.raw.ateenagerinlove);
            vectormp[8] = MediaPlayer.create(this, R.raw.bomboro);
            vectormp[9] = MediaPlayer.create(this, R.raw.bulebule);
            vectormp[10] = MediaPlayer.create(this, R.raw.danzon);
            vectormp[11] = MediaPlayer.create(this, R.raw.despeinada);
            vectormp[12] = MediaPlayer.create(this, R.raw.donna);
            vectormp[13] = MediaPlayer.create(this, R.raw.dreamlover);
            vectormp[14] = MediaPlayer.create(this, R.raw.florecita);
            vectormp[15] = MediaPlayer.create(this, R.raw.lollipop);
            vectormp[16] = MediaPlayer.create(this, R.raw.musita);
            vectormp[17] = MediaPlayer.create(this, R.raw.nereidas);
            vectormp[18] = MediaPlayer.create(this, R.raw.quizas);
            vectormp[19] = MediaPlayer.create(this, R.raw.sherry);
            vectormp[20] = MediaPlayer.create(this, R.raw.sway);
            vectormp[21] = MediaPlayer.create(this, R.raw.whydontyoudoright);
            vectormp[22] = MediaPlayer.create(this, R.raw.diossiperdona);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.portada1);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    //Método repetir una pista
    public void Repetir(View view){
        if(repetir == 1){
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        } else {
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);//este metodo setloopin nos permite siclar valores booleanos
            repetir = 1;
        }
    }

    //Método para saltar a la siguiente canción.
    public void Siguiente(View view){
        if(posicion < vectormp.length -1){ //el menos 1 es para que no haya desbordamiento de memoria

            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();

                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                } else if(posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }else if(posicion == 3){
                    iv.setImageResource(R.drawable.portada4);
                }else if(posicion == 4){
                    iv.setImageResource(R.drawable.portada5);
                }else if(posicion == 5){
                    iv.setImageResource(R.drawable.portada6);
                }else if(posicion == 6){
                    iv.setImageResource(R.drawable.portada7);
                }else if(posicion == 7){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 8){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 9){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 10){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 11){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 12){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 13){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 14){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 15){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 16){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 17){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 18){
                    iv.setImageResource(R.drawable.portada8);
                } else if(posicion == 19){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 20){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 21){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 22){
                    iv.setImageResource(R.drawable.portada8);
                }

            } else {
                posicion++;

                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                } else if(posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }else if(posicion == 3){
                    iv.setImageResource(R.drawable.portada4);
                }else if(posicion == 4){
                    iv.setImageResource(R.drawable.portada5);
                }else if(posicion == 5){
                    iv.setImageResource(R.drawable.portada6);
                }else if(posicion == 6){
                    iv.setImageResource(R.drawable.portada7);
                }else if(posicion == 7){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 8){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 9){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 10){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 11){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 12){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 13){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 14){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 15){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 16){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 17){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 18){
                    iv.setImageResource(R.drawable.portada8);
                } else if(posicion == 19){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 20){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 21){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 22){
                    iv.setImageResource(R.drawable.portada8);
                }
            }

        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }


    //Método para regresar a la canción anterior
    public void Anterior(View view){
        if(posicion >= 1){

            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.race);
                vectormp[1] = MediaPlayer.create(this, R.raw.sound);
                vectormp[2] = MediaPlayer.create(this, R.raw.tea);
                vectormp[3] = MediaPlayer.create(this, R.raw.babygirl);
                vectormp[4] = MediaPlayer.create(this, R.raw.keepitgangsta);
                vectormp[5] = MediaPlayer.create(this, R.raw.smile);
                vectormp[6] = MediaPlayer.create(this, R.raw.money);
                vectormp[7] = MediaPlayer.create(this, R.raw.ateenagerinlove);
                vectormp[8] = MediaPlayer.create(this, R.raw.bomboro);
                vectormp[9] = MediaPlayer.create(this, R.raw.bulebule);
                vectormp[10] = MediaPlayer.create(this, R.raw.danzon);
                vectormp[11] = MediaPlayer.create(this, R.raw.despeinada);
                vectormp[12] = MediaPlayer.create(this, R.raw.donna);
                vectormp[13] = MediaPlayer.create(this, R.raw.dreamlover);
                vectormp[14] = MediaPlayer.create(this, R.raw.florecita);
                vectormp[15] = MediaPlayer.create(this, R.raw.lollipop);
                vectormp[16] = MediaPlayer.create(this, R.raw.musita);
                vectormp[17] = MediaPlayer.create(this, R.raw.nereidas);
                vectormp[18] = MediaPlayer.create(this, R.raw.quizas);
                vectormp[19] = MediaPlayer.create(this, R.raw.sherry);
                vectormp[20] = MediaPlayer.create(this, R.raw.sway);
                vectormp[21] = MediaPlayer.create(this, R.raw.whydontyoudoright);
                vectormp[22] = MediaPlayer.create(this, R.raw.diossiperdona);
                posicion--;

                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                } else if(posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }else if(posicion == 3){
                    iv.setImageResource(R.drawable.portada4);
                }else if(posicion == 4){
                    iv.setImageResource(R.drawable.portada5);
                }else if(posicion == 5){
                    iv.setImageResource(R.drawable.portada6);
                }else if(posicion == 6){
                    iv.setImageResource(R.drawable.portada7);
                } else if(posicion == 7){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 8){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 9){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion== 10){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 11){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 12){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 13){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 14){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 15){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 16){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 17){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 18){
                    iv.setImageResource(R.drawable.portada8);
                } else if(posicion == 19){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 20){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 21){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 22){
                    iv.setImageResource(R.drawable.portada8);
                }

                vectormp[posicion].start();

            } else {
                posicion--;

                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                } else if(posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                } else if(posicion == 3){
                    iv.setImageResource(R.drawable.portada4);
                }else if(posicion == 4){
                    iv.setImageResource(R.drawable.portada5);
                }else if(posicion == 5){
                    iv.setImageResource(R.drawable.portada6);
                }else if(posicion == 6){
                    iv.setImageResource(R.drawable.portada7);
                }else if(posicion == 7){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 8){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 9){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 10){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 11){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 12){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 13){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 14){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 15){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 16){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 17){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 18){
                    iv.setImageResource(R.drawable.portada8);
                } else if(posicion == 19){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 20){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 21){
                    iv.setImageResource(R.drawable.portada8);
                }else if(posicion == 22){
                    iv.setImageResource(R.drawable.portada8);
                }
            }

        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }
}
