package id.ac.umn.jerryarianto_00000033745_if570_el_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    Button btn_next;
    EditText    et_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_next = findViewById(R.id.btn_next);
        et_input = findViewById(R.id.et_input);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(et_input.getText())){
                    et_input.setError("Harap Diisi");
                }else{
                    String name = et_input.getText().toString();
                    Intent libraryIntent = new Intent(LoginActivity.this, LibraryActivity.class);
                    libraryIntent.putExtra(LibraryActivity.EXTRA_NAME,name );
                    finish();
                    startActivity(libraryIntent);
                }
            }
        });
    }
}