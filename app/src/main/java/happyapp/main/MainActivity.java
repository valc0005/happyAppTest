package happyapp.main;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View happyImage = (View)findViewById(R.id.happyImage);
        final View angryImage = (View)findViewById(R.id.angryImage);
        final Button showButton = (Button)findViewById(R.id.smileyButton);
        final TextView topText = (TextView)findViewById(R.id.topText);

        final HappyTracker happyTracker = new HappyTracker();

        happyImage.setVisibility(View.INVISIBLE);

        showButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                happyTracker.changeStatus();
                topText.setText(happyTracker.getCurrentText());
                showButton.setText(happyTracker.getCurrentButtonText());

                if(happyTracker.isHappy()){
                    happyImage.setVisibility(View.VISIBLE);
                    angryImage.setVisibility(View.INVISIBLE);
                }
                else{
                    happyImage.setVisibility(View.INVISIBLE);
                    angryImage.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}

