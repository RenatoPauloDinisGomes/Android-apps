package gomes.renato.app004;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Act001 extends AppCompatActivity {

    Camera camera;
    Camera.Parameters parameters;
    boolean isFlash = false;
    boolean isOn = false;

    @Override
    protected void onStop() {
        super.onStop();
        if(camera!=null)
        {
            camera.release();
            camera = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act001);
        if(getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH))
        {
            camera = Camera.open();
            parameters =camera.getParameters();
            isFlash=true;
        }


        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button btnEnter = (Button) findViewById(R.id.btnEnter);
        final Button btnFlash = (Button) findViewById(R.id.btnFlash);


        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText etUserName = (EditText) findViewById(R.id.etUserName);

                String Name = etUserName.getText().toString();
                String Password = etPassword.getText().toString();
                String Texto = "User Name: " + Name + " \n Password: " + Password;
                Toast toast001 = new Toast(getApplicationContext());
                toast001.makeText(Act001.this, Texto, toast001.LENGTH_LONG).show();

                Intent PassagemIntent = new Intent(Act001.this, Act002.class);
                PassagemIntent.putExtra("NAME", Name);
                Act001.this.startActivity(PassagemIntent);

            }
        });
        btnFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast003 = new Toast(getApplicationContext());
                if (isFlash) {
                    toast003.makeText(Act001.this, "Sim", toast003.LENGTH_LONG).show();
                    if(!isOn)
                    {
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(parameters);
                        camera.startPreview();
                        isOn=true;
                    }else
                    {
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                        camera.setParameters(parameters);
                        camera.stopPreview();
                        isOn=false;
                    }
                } else {
                    AlertDialog.Builder builder= new AlertDialog.Builder(Act001.this);
                    builder.setTitle("Erro...");
                    builder.setMessage("Flash não esta disponivel!");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    });
                AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });

    }
}
