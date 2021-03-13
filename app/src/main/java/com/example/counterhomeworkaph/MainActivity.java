package com.example.counterhomeworkaph;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private TextView saveText;


    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //obteniendo el valor del textview
        mShowCount = (TextView) findViewById(R.id.show_count);
        //obteniendo el valor del textview
        saveText = findViewById(R.id.editText1);

        if (savedInstanceState != null) {
            // guardando el valor booleano del objeto bundle con identificador reply_visible
            boolean isVisible = savedInstanceState.getBoolean("visible_txt");
            boolean isVisibleCounter = savedInstanceState.getBoolean("visible_count");
            //compara las variables antes declaradas y si alguna de las dos es true se realiza lo sig.
            if (isVisible || isVisibleCounter) {
                //volvemos a hacer visible el editText
                saveText.setVisibility(View.VISIBLE);
                //guardamos en el objeto bundle lo que tiene el editText
                // y se colocará cuando la aplicacion pase a on pause, on stop
                saveText.setText(savedInstanceState.getString("saved_text"));
                //volvemos a hacer visible el editText del contador
                mShowCount.setVisibility(View.VISIBLE);
                //guardamos en el objeto bundle  lo que tiene el editText
                // y se colocará cuando la aplicacion pase a on pause, on stop
                mShowCount.setText(savedInstanceState.getString("saved_count"));
            }//fin del  segundo if
        }//fin del primer if
    }//fin del método onCreate()

    /**
     * método para el contador
     * @param view
     */
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    /**
     * método para saber el estado de el editText si es visible o no
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    //se usa el método getVisibility para obtener la visibilidad del elemento TextView
    //si el texto es visible se guardan los datos
        //comparando la visibilidad del editText (con su método correspondiente getVisibility() ) con la visibilidad de la vista (View.VISIBLE)
        if (saveText.getVisibility() == View.VISIBLE || mShowCount.getVisibility() == View.VISIBLE) {
            //reply_visible es el nombre de outstate
            //agregando un primer parametro para el Bundle outState que sera boolean con identificador reply_visible
            outState.putBoolean("visible_txt", true);
            //agregando un primer parametro para el Bundle outState que sera boolean con identificador reply_visible
            //obtenemos el valor que se tiene en el EditText del texto en la variable reply_text
            outState.putString("saved_text",saveText.getText().toString());
            //6cambiarle el nombre //creamos una key llamada reply_visibleCounter con valor true
            outState.putBoolean("visible_count", true);
            //obtenemos el valor que se tiene en el EditText del texto en la variable reply_counter
            outState.putString("saved_count", mShowCount.getText().toString());
        }//fin del if
    }//fin del método onSaveInstanceState
}