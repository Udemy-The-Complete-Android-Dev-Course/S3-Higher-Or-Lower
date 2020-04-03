package ldansorean.s3higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static int MIN_VALUE = 0, MAX_VALUE = 20;

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

    private boolean isUserGuessValid(String userGuessStr){
        try {
            int number = Integer.parseInt(userGuessStr);
            return (number >= MIN_VALUE) && (number <= MAX_VALUE);
        } catch (Exception e) {
            return false;
        }
    }

    public void validateGuess(View view) {
        String userGuessStr = ((EditText) findViewById(R.id.userGuess)).getText().toString();
        String toastMessage = "";

        if (isUserGuessValid(userGuessStr)) {
            int userGuess = Integer.parseInt(userGuessStr);
            if (userGuess == randomNumber) {
                toastMessage = "Well done! Now try again!";
                randomNumber = generateRandomNumber();
            } else if (userGuess > randomNumber) {
                toastMessage = "Your number is too high.";
            } else {
                toastMessage = "Your number is too low";
            }
        } else {
            toastMessage = "Invalid input. Choose a number between 0 and 20.";
        }

        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
    }
}
