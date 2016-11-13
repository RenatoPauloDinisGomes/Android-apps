package gomes.renato.app004;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Act002 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act002);


        Intent i = getIntent();
        Bundle dataBundle = i.getExtras();
        String Name = dataBundle.getString("NAME");


        final EditText showName = (EditText) findViewById(R.id.showName);
        final EditText showPassword = (EditText) findViewById(R.id.showPassword);
        showName.setText(Name);

        Toast toast002 = new Toast(getApplicationContext());
        toast002.makeText(Act002.this,Name,toast002.LENGTH_LONG).show();

        final Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PassagemBackIntent = new Intent(Act002.this,Act001.class);
                Act002.this.startActivity(PassagemBackIntent);
            }
        });

    }
}
