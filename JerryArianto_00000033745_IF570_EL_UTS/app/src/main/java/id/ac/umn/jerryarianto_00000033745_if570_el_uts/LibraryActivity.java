package id.ac.umn.jerryarianto_00000033745_if570_el_uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "username";
    ArrayList<Sound> list = new ArrayList<>();
    RecyclerView rv;
    ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        getSupportActionBar().setTitle(name);
        Toast.makeText(getApplicationContext(), "Selamat Datang, " + name, Toast.LENGTH_SHORT).show();
        daftarSFX();
        rv = findViewById(R.id.rv);
        adapter = new ListAdapter(this,list);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu:
                Intent mainMenuIntent = new Intent(LibraryActivity.this, MainActivity.class);
                startActivity(mainMenuIntent);
                finish();
                return true;
            case R.id.profile:
                Intent profileIntent = new Intent(LibraryActivity.this, ProfileActivity.class);
                startActivity(profileIntent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void daftarSFX(){
        list.add(new Sound("Channel Intro","wii", "android.resource://" + getPackageName() + "/"+ R.raw.channelintro));
        list.add(new Sound("Select Position","wii", "android.resource://" + getPackageName() + "/"+ R.raw.selectposition));
        list.add(new Sound("Stage Clear","wii", "android.resource://" + getPackageName() + "/"+ R.raw.stageclear));
        list.add(new Sound("Plaza","wii", "android.resource://" + getPackageName() + "/"+ R.raw.plaza));
        list.add(new Sound("Parade","wii", "android.resource://" + getPackageName() + "/"+ R.raw.parade));
    }
}