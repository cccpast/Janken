package com.cccpast.janken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button stone_btn = (Button) findViewById(R.id.stone_btn);
    Button scissors_btn = (Button) findViewById(R.id.scissors_btn);
    Button paper_btn = (Button) findViewById(R.id.paper_btn);
    TextView result_text = (TextView) findViewById(R.id.result_text);

    Master master = new Master(stone_btn, scissors_btn, paper_btn, result_text);
    master.inputUserChoiseHand();
  }
}
