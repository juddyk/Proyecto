package com.example.juddyreina.proyecto;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mostrar extends AppCompatActivity {

    private Button btn;
    private kidDatabaseHelper kidDatabase = new kidDatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        final String name=getIntent().getStringExtra("nombre");
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/TimKid.ttf");
        btn=(Button) findViewById(R.id.continuar);
        String nombre,padre;
        Child kid=kidDatabase.getChild(name);
        TextView lenguaje = (TextView) findViewById(R.id.mostrar);
        nombre=kid.getName();
        padre=kid.getPadre();
        lenguaje.setText(padre);
        lenguaje.setTypeface(myCustomFont);
        btn.setTypeface(myCustomFont);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mostrar.this, premio.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mostrar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.itemABOUT) {
            // Toast.makeText(this, "ABOUT", Toast.LENGTH_SHORT).show();
            //abrir una actividad de dialogo
            Intent i = new Intent(this, guia.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }



}