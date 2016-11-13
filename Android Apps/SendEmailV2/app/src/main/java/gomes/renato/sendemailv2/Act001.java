package gomes.renato.sendemailv2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Act001 extends AppCompatActivity {

    private Button btnSend;
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act001);
        Log.i("Send email", "");
        btnSend = (Button) findViewById(R.id.btnSend);
        tvInfo = (TextView) findViewById(R.id.tvInfo);

        btnSend.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent(Intent.ACTION_SEND);
                                           intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"renatogomes1995@hotmail.com"});
                                           intent.putExtra(Intent.EXTRA_SUBJECT, "Tema");
                                           intent.putExtra(Intent.EXTRA_TEXT, "texto do mail");
                                           intent.setType("message/rfc822");
                                           try {
                                               startActivity(intent);
                                               tvInfo.setText("A Enviar ...");
                                               Log.i("Finished sending email", "");
                                           } catch (ActivityNotFoundException e) {
                                               Toast.makeText(Act001.this, "No Email Client found!", Toast.LENGTH_LONG).show();
                                           }
                                       }
                                   }

        );
    }
}
