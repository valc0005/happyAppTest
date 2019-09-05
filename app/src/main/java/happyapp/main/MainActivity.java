package happyapp.main;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Select image to show happy or angry emote
        final ImageView happyImage = (ImageView)findViewById(R.id.happyImage);

        //Select button to switch happy or angry state
        final Button showButton = (Button)findViewById(R.id.smileyButton);

        //Select text above image to alter content
        final TextView topText = (TextView)findViewById(R.id.topText);

        //HappyTracker class switches happiness state
        final HappyTracker happyTracker = new HappyTracker();
        
        //Function switch happiness on button click
        showButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                happyTracker.changeStatus(happyImage);
                topText.setText(happyTracker.getCurrentText());
                showButton.setText(happyTracker.getCurrentButtonText());
            }
        });
    }
}

