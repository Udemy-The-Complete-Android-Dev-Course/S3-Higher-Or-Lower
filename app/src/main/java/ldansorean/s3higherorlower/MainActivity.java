package ldansorean.s3higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random randomGenerator = new Random();
    private int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNumber = generateRandomNumber();
    }

    private int generateRandomNumber() {
        int number = randomGenerator.nextInt(21);
        Log.i("number", String.valueOf(number));
        return number;
    }

    public void validateGuess(View view) {
        EditText userGuessET = findViewById(R.id.userGuess);
        Integer userGuess = Integer.parseInt(userGuessET.getText().toString());

        String message = "";
        if (userGuess == randomNumber) {
            message = "Congratulations! You've got it! Now try again!";
            randomNumber = generateRandomNumber();
        } else if (userGuess > randomNumber) {
            message = "Your number is too high.";
        } else {
            message = "Your number is too low";
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
