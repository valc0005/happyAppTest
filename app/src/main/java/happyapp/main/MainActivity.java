package happyapp.main;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private HappyTracker happyTracker = new HappyTracker();

    private final ArrayList<Typeface> fontList;
    private final int[] colorList;

    private TextView text;
    private Button diceButton;
    private ImageView image;

    private final Typeface bold;
    private final Typeface serif;
    private final Typeface mono;
    private final Typeface cursive;
    private final Typeface boldCursive;

    MainActivity() {

        fontList = new ArrayList<>();
        bold = Typeface.DEFAULT_BOLD;
        serif = Typeface.SERIF;
        mono = Typeface.MONOSPACE;
        cursive = Typeface.defaultFromStyle(Typeface.ITALIC);
        boldCursive = Typeface.defaultFromStyle(Typeface.BOLD_ITALIC);

        fontList.add(bold);
        fontList.add(serif);
        fontList.add(mono);
        fontList.add(cursive);
        fontList.add(boldCursive);

        colorList = new int[]{  Color.GREEN,
                Color.RED,
                Color.BLUE,
                Color.BLACK,
                Color.YELLOW,
                Color.MAGENTA,
                Color.CYAN
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.topText);
        diceButton = findViewById(R.id.diceButton);
        image = findViewById(R.id.happyImage);
    }

    public void changeState(View view){

        //Change the status in the HappyTracker
        happyTracker.changeStatus(image);
        //Set the new text
        text.setText(happyTracker.getCurrentText());

        //Change text font and color
        text.setTypeface(fontList.get(MathHelper.getRandomInt(0, fontList.size())));
        text.setTextColor(colorList[MathHelper.getRandomInt(0, colorList.length)]);

        //Change color of button text and background
        int diceButtonTextColor = colorList[MathHelper.getRandomInt(0, colorList.length)];
        int diceButtonBackgroundColor = colorList[MathHelper.getRandomInt(0, colorList.length)];

        //Change background color if it is the same as text color
        while (diceButtonTextColor == diceButtonBackgroundColor) {
            diceButtonBackgroundColor = colorList[MathHelper.getRandomInt(0, colorList.length)];
        }

        //Set the font and colors of the button
        diceButton.setTypeface(fontList.get(MathHelper.getRandomInt(0, fontList.size())));
        diceButton.setTextColor(diceButtonTextColor);
        diceButton.setBackgroundColor(diceButtonBackgroundColor);
        }

    public void showDiceNumber(final View view) {
        //Set status to unhappy
        if(happyTracker.isHappy()) changeState(view);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // Get a Random integer
        int randomNumber = MathHelper.getRandomInt(1, 7);
        // If random number is 6
        if(randomNumber == 6) {
            //Set status to happy
            changeState(view);

            builder.setTitle("You won!")
                    .setMessage("You rolled: " + randomNumber)
                    .setCancelable(true)
                    .setPositiveButton("Play new game", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                            //Set status back to unhappy
                            changeState(view);
                            
                            showDiceNumber(view);
                        }
                    }).show();
            // Creating dialog box
            AlertDialog dialog = builder.create();
            dialog.show();
            // Or else
        } else {
            builder.setTitle("The dice have been cast...")
                    .setMessage("You rolled: " + randomNumber + ". " + "Pass the device on to the next player...")
                    .setCancelable(true)
                    .setPositiveButton("Re-roll", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                            showDiceNumber(view);
                        }
                    }).show();
            // Creating dialog box
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}

