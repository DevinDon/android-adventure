package red.don.game.adventure;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private TextView textView$username;
  private TextView textView$password;
  private ProgressBar progressBar$agility;
  private ProgressBar progressBar$attack;
  private ProgressBar progressBar$health;
  private Button button$shop;

  private void bindView() {
    textView$username = findViewById(R.id.MAIN_textView_username);
    textView$password = findViewById(R.id.MAIN_textView_password);
    progressBar$agility = findViewById(R.id.MAIN_progressBar_agility);
    progressBar$attack = findViewById(R.id.MAIN_progressBar_attack);
    progressBar$health = findViewById(R.id.MAIN_progressBar_health);
    button$shop = findViewById(R.id.MAIN_button_shop);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    this.bindView();
    Intent userInfo = getIntent();
    textView$username.setText(userInfo.getStringExtra("username"));
    textView$password.setText(userInfo.getStringExtra("password"));
    button$shop.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, ShopActivity.class);
        startActivityForResult(intent, 1);
      }
    });
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (requestCode == 1 && resultCode == 1) {
      progressBar$agility.setProgress(data.getIntExtra("agility", 0));
      progressBar$attack.setProgress(data.getIntExtra("attack", 0));
      progressBar$health.setProgress(data.getIntExtra("health", 0));
    }
  }

}
