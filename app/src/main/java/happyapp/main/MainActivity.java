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

        happyImage.setVisibility(View.INVISIBLE);

        showButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(happyImage.getVisibility() == View.INVISIBLE){
                    happyImage.setVisibility(View.VISIBLE);
                    angryImage.setVisibility(View.INVISIBLE);
                    topText.setText("You are happy!");
                    showButton.setText("Click here to be ANGRY!");
                }
                else{
                    happyImage.setVisibility(View.INVISIBLE);
                    angryImage.setVisibility(View.VISIBLE);
                    topText.setText("You are not happy!");
                    showButton.setText("Click here to be HAPPY!");

                }


            }
        });
    }
}

