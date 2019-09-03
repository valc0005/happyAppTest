package happyapp.main;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the button
        Button btn = (Button) findViewById(R.id.btnMakeMeHappy);
        // ... see what happens when the users clicks
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("my happy app", "the button work [log message] - happy app");
                Toast.makeText(getApplicationContext(), "Blij!!!!!!!!", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}

