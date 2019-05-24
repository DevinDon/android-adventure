package red.don.game.adventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {

  private EditText editText$username;
  private EditText editText$password;
  private Button button$signIn;

  private void bindView() {
    this.editText$username = findViewById(R.id.SIGNIN_editText_username);
    this.editText$password = findViewById(R.id.SIGNIN_editText_password);
    this.button$signIn = findViewById(R.id.SIGNIN_button_signIn);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signin);
    this.bindView();
    this.button$signIn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        intent.putExtra("username", editText$username.getText().toString());
        intent.putExtra("password", editText$password.getText().toString());
        startActivity(intent);
      }
    });
  }

}
