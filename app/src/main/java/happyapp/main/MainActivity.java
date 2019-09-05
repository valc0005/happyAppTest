package happyapp.main;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private HappyTracker happyTracker = new HappyTracker();

    private final ArrayList<Typeface> fontList;
    private final int[] colorList;

    private TextView text;
    private Button button;
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
        button = findViewById(R.id.smileyButton);
        image = findViewById(R.id.happyImage);
    }

    public void changeState(View view){
        happyTracker.changeStatus(image);
        text.setText(happyTracker.getCurrentText());
        button.setText(happyTracker.getCurrentButtonText());


        int buttonTextColor = colorList[MathHelper.getRandomInt(0, colorList.length)];
        int buttonBackgroundColor = colorList[MathHelper.getRandomInt(0, colorList.length)];

        while (buttonTextColor == buttonBackgroundColor) {
        buttonBackgroundColor = colorList[MathHelper.getRandomInt(0, colorList.length)];
        }

        text.setTypeface(fontList.get(MathHelper.getRandomInt(0, fontList.size())));
        text.setTextColor(colorList[MathHelper.getRandomInt(0, colorList.length)]);

        button.setTypeface(fontList.get(MathHelper.getRandomInt(0, fontList.size())));
        button.setTextColor(buttonTextColor);
        button.setBackgroundColor(buttonBackgroundColor);
        }
}

