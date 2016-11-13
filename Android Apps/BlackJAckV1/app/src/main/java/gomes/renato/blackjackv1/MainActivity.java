package gomes.renato.blackjackv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     private Button Next = (Button) findViewById(R.id.btnNext);
    private Button Back = (Button) findViewById(R.id.btnBack);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
