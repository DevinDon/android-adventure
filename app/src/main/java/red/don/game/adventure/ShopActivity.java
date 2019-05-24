package red.don.game.adventure;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopActivity extends AppCompatActivity {

  private ListView listView$equipment;
  private List<Equipment> equipments;
  private Equipment equipment;
  private AlertDialog dialog;

  private void init() {
    listView$equipment = findViewById(R.id.SHOP_listView_equipment);
    equipments = Arrays.asList(new Equipment[] {
            new Equipment("锅铲",50,50,10),
            new Equipment("锅盖",30,10,50),
            new Equipment("平底锅",10,75,50),
            new Equipment("擀面杖",75,15,10)
    });
    dialog = new AlertDialog.Builder(ShopActivity.this)
            .setTitle("购买装备")
            .setMessage("确认购买？")
            .setNegativeButton("取消", null)
            .setPositiveButton("确认", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent();
                intent.putExtra("name", equipment.getName());
                intent.putExtra("agility", equipment.getAgility());
                intent.putExtra("attack", equipment.getAttack());
                intent.putExtra("health", equipment.getHealth());
                setResult(1, intent);
                finish();
              }
            })
            .create();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shop);
    init();
    listView$equipment.setAdapter(new EquipmentAdapter(this, equipments));
    listView$equipment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        equipment = equipments.get(position);
        dialog.show();
      }
    });
  }

}

class Equipment {

  private String name;
  private int agility;
  private int attack;
  private int health;
  private int head;

  public Equipment(String name, int agility, int attack, int health) {
    this(name, agility, attack, health, 0);
  }

  public Equipment(String name, int agility, int attack, int health, int head) {
    this.name = name;
    this.agility = agility;
    this.attack = attack;
    this.health = health;
    this.head = head;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAgility() {
    return agility;
  }

  public void setAgility(int agility) {
    this.agility = agility;
  }

  public int getAttack() {
    return attack;
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getHead() {
    return head;
  }

  public void setHead(int head) {
    this.head = head;
  }

}

class EquipmentAdapter extends BaseAdapter {

  private Context context;
  private List<Equipment> data;

  public EquipmentAdapter(Context context, List<Equipment> data) {
    this.context = context;
    this.data = data;
  }

  @Override
  public int getCount() {
    return data.size();
  }

  @Override
  public Object getItem(int position) {
    return data.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    Equipment equipment = data.get(position);
    View view = View.inflate(context, R.layout.list_equipment, null);
    ((TextView)view.findViewById(R.id.EQUIPMENTLIST_name)).setText(equipment.getName());
    ((TextView)view.findViewById(R.id.EQUIPMENTLIST_agility)).setText("" + equipment.getAgility());
    ((TextView)view.findViewById(R.id.EQUIPMENTLIST_attack)).setText("" + equipment.getAttack());
    ((TextView)view.findViewById(R.id.EQUIPMENTLIST_health)).setText("" + equipment.getHealth());
    return view;
  }

}