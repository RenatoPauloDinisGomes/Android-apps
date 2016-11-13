package gomes.renato.sendmail;

import android.content.Intent;
import android.net.Uri;
import android.service.chooser.ChooserTarget;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Act001 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act001);
        final Button btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String email = "renatogomes1995@hotmail.com";
                intent.putExtra(Intent.EXTRA_EMAIL,email);
                intent.putExtra(Intent.EXTRA_SUBJECT,"oi foi enviado pelo renato");
                intent.putExtra(Intent.EXTRA_TEXT, "Oi outra vez!");
                intent.setType("message/rfc822");
                Intent chooser=Intent.createChooser(intent, "Send Email");
                startActivity(chooser);
            }
        });
    }
}
