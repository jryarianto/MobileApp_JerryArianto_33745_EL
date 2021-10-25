package id.ac.umn.jerryarianto_00000033745_if570_el_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE ="title";
    public static final String EXTRA_DESC = "genre";
    public static final String EXTRA_URI = "uri";
    TextView tv_title, tv_desc;
    Button btn_play;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        String desc = getIntent().getStringExtra(EXTRA_DESC);
        String uri = getIntent().getStringExtra(EXTRA_URI);
        setContentView(R.layout.activity_detail);
        tv_title = findViewById(R.id.detail_title);
        tv_desc = findViewById(R.id.detail_desc);
        btn_play = findViewById(R.id.play);
        tv_title.setText(title);
        tv_desc.setText(desc);
        getSupportActionBar().setTitle(title);

        mp = MediaPlayer.create(getApplicationContext(), Uri.parse(uri));
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        mp.stop();
        mp.release();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}