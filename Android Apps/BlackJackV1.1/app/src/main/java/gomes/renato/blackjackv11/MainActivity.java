package gomes.renato.blackjackv11;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnPlay;
    private Button btnCard;
    private Button btnSplit;
    private Button btnOk;

    private Game game;

    private ImageView ivDealer1;
    private ImageView ivDealer2;
    private ImageView ivDealer3;
    private ImageView ivDealer4;

    private ImageView ivPlayer1;
    private ImageView ivPlayer2;
    private ImageView ivPlayer3;
    private ImageView ivPlayer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnCard = (Button) findViewById(R.id.btnCard);
        btnSplit = (Button) findViewById(R.id.btnSplit);
        btnOk = (Button) findViewById(R.id.btnOk);

        ivDealer1 = (ImageView) findViewById(R.id.ivDealer1);
        ivDealer2 = (ImageView) findViewById(R.id.ivDealer2);
        ivDealer3 = (ImageView) findViewById(R.id.ivDealer3);
        ivDealer4 = (ImageView) findViewById(R.id.ivDealer4);

        ivPlayer1 = (ImageView) findViewById(R.id.ivPlayer1);
        ivPlayer2 = (ImageView) findViewById(R.id.ivPlayer2);
        ivPlayer3 = (ImageView) findViewById(R.id.ivPlayer3);
        ivPlayer4 = (ImageView) findViewById(R.id.ivPlayer4);

        game = new Game(getApplicationContext());

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPlay.setVisibility(View.INVISIBLE);
                btnCard.setVisibility(View.VISIBLE);
                btnOk.setVisibility(View.VISIBLE);
                btnSplit.setVisibility(View.VISIBLE);
                game.Shuffle();

                DealCard(ivDealer1);


                // DealCard(ivPlayer1);
                // DealCard(ivPlayer2);
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DealCard(ivDealer1);
            }
        });
    }

    public void DealCard(ImageView image) {
        Card card = game.getDeck().get(game.getTop());
        game.plusTop();
        Toast.makeText(MainActivity.this, card.getResId() + " " + game.getTop(), Toast.LENGTH_LONG).show();
        //image.setImageResource(android.R.color.transparent);
       // int resID = getResources().getIdentifier(card.getId(), "drawable", getPackageName());

        //image.setImageDrawable(getResources().getDrawable(resID));


        int resource = getResources().getIdentifier("drawable/" + card.getId(), null, getPackageName());

        @SuppressWarnings("deprecation") Drawable iconCard = getResources().getDrawable(resource);
        image.setImageDrawable(iconCard);

    }


}
