package com.example.lesson_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.edit_text);
        Button button = findViewById(R.id.button1);
        EditText editText1 = findViewById(R.id.edit_p);

        LinearLayout cardView = findViewById(R.id.container2);






        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    // Change the color of the button when text is entered
                    button.setBackgroundColor(Color.YELLOW); // Change to your desired color
                } else {
                    // Restore the original color of the button when no text
                    button.setBackgroundColor(Color.RED); // Change to your original color
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editText.getText().toString();
                String userP = editText1.getText().toString();
                if(userName.equals("admin") && userP.equals("admin")){
                    String m = "Welcome " + userName + "!";
                    Toast.makeText(MainActivity.this, m, Toast.LENGTH_SHORT).show();
                    if(cardView.getVisibility() == View.VISIBLE){
                        cardView.setVisibility(View.INVISIBLE);
                    }
                    else{
                        cardView.setVisibility(View.VISIBLE);
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}