package ldansorean.s3higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random randomGenerator = new Random();
        randomNumber = randomGenerator.nextInt(21);
        Log.i("number", String.valueOf(randomNumber));
    }

    public void validateGuess(View view) {
        EditText userGuessET = findViewById(R.id.userGuess);
        Integer userGuess = Integer.parseInt(userGuessET.getText().toString());

        String message = "";
        if (userGuess == randomNumber) {
            message = "Congratulations! You've got it!";
        } else if (userGuess > randomNumber) {
            message = "Your number is too high.";
        } else {
            message = "Your number is too low";
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
