package gomes.renato.app005;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Act001 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act001);
        final EditText etName = (EditText) findViewById(R.id.etName);

        final Button btnToast = (Button) findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast001= new Toast(getApplicationContext());
                toast001.makeText(Act001.this,etName.getText(),toast001.LENGTH_LONG).show();

            }
        });


    }
}
