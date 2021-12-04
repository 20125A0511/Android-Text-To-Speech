package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;
import android.widget.Button;
import java.util.Locale;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
public class MainActivity extends AppCompatActivity {
TextToSpeech t1;
EditText ed1;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.editText);
        b1 = findViewById(R.id.button);
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR){
                    t1.setLanguage(Locale.UK);
                }
            }
        });
      b1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
             String toSpeak = ed1.getText().toString();
             Toast.makeText(getApplicationContext(),toSpeak,Toast.LENGTH_SHORT).show();
             t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
          }
      });
    }
    public   void onPause(){
        if (t1!=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}