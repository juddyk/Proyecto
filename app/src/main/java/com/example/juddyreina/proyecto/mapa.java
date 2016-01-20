package com.example.juddyreina.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mapa extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30;
        Button b31,b32,b33,b34,b35,b36,b37,b38,b39,b40,b41,b42;

        b1=(Button) findViewById(R.id.b1);         b11=(Button) findViewById(R.id.b11);        b21=(Button) findViewById(R.id.b21);
        b2=(Button) findViewById(R.id.b2);         b12=(Button) findViewById(R.id.b12);        b22=(Button) findViewById(R.id.b22);
        b3=(Button) findViewById(R.id.b3);         b13=(Button) findViewById(R.id.b13);        b23=(Button) findViewById(R.id.b23);
        b4=(Button) findViewById(R.id.b4);         b14=(Button) findViewById(R.id.b14);        b24=(Button) findViewById(R.id.b24);
        b5=(Button) findViewById(R.id.b5);         b15=(Button) findViewById(R.id.b15);        b25=(Button) findViewById(R.id.b25);
        b6=(Button) findViewById(R.id.b6);         b16=(Button) findViewById(R.id.b16);        b26=(Button) findViewById(R.id.b26);
        b7=(Button) findViewById(R.id.b7);         b17=(Button) findViewById(R.id.b17);        b27=(Button) findViewById(R.id.b27);
        b8=(Button) findViewById(R.id.b8);         b18=(Button) findViewById(R.id.b18);        b28=(Button) findViewById(R.id.b28);
        b9=(Button) findViewById(R.id.b9);         b19=(Button) findViewById(R.id.b19);        b29=(Button) findViewById(R.id.b29);
        b10=(Button) findViewById(R.id.b10);       b20=(Button) findViewById(R.id.b20);        b30=(Button) findViewById(R.id.b30);

        b31=(Button) findViewById(R.id.b31);         b41=(Button) findViewById(R.id.b41);
        b32=(Button) findViewById(R.id.b32);         b42=(Button) findViewById(R.id.b42);
        b33=(Button) findViewById(R.id.b33);
        b34=(Button) findViewById(R.id.b34);
        b35=(Button) findViewById(R.id.b35);
        b36=(Button) findViewById(R.id.b36);
        b37=(Button) findViewById(R.id.b37);
        b38=(Button) findViewById(R.id.b38);
        b39=(Button) findViewById(R.id.b39);
        b40=(Button) findViewById(R.id.b20);
        //inicialización
        b1.setEnabled(true);b2.setEnabled(false);b3.setEnabled(false);b4.setEnabled(false);b5.setEnabled(false);b6.setEnabled(false);b7.setEnabled(false);
        b8.setEnabled(false);b9.setEnabled(false);b10.setEnabled(false);b11.setEnabled(false);b12.setEnabled(false);b13.setEnabled(false);
        b14.setEnabled(false);b15.setEnabled(false);b16.setEnabled(false);b17.setEnabled(false);b18.setEnabled(false);b19.setEnabled(false);
        b20.setEnabled(false);b21.setEnabled(false);b22.setEnabled(false);b23.setEnabled(false);b24.setEnabled(false);b25.setEnabled(false);
        b26.setEnabled(false);b27.setEnabled(false);b28.setEnabled(false);b29.setEnabled(false);b30.setEnabled(false);b31.setEnabled(false);
        b32.setEnabled(false);b33.setEnabled(false);b34.setEnabled(false);b35.setEnabled(false);b36.setEnabled(false);b37.setEnabled(false);
        b38.setEnabled(false);b39.setEnabled(false);b40.setEnabled(false);b41.setEnabled(false);b42.setEnabled(false);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(mapa.this, contenido.class);
                startActivity(i);
            }
        });







    }
}
