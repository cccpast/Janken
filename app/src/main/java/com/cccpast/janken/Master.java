package com.cccpast.janken;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Master {

  private Button stone_btn;
  private Button scissors_btn;
  private Button paper_btn;
  private TextView result_text;

  Master(Button stone_btn, Button scissors_btn, Button paper_btn, TextView result_text) {
    this.stone_btn = stone_btn;
    this.scissors_btn = scissors_btn;
    this.paper_btn = paper_btn;
    this.result_text = result_text;
  }

  /*
   * ユーザが選んだボタンを検出
   */
  public void inputUserChoiseHand() {

    this.stone_btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        battle(0);
      }
    });

    this.scissors_btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        battle(1);
      }
    });

    this.paper_btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        battle(2);
      }
    });

  }

  /*
   * じゃんけん勝負を行う
   * player_hand : ユーザの手
   * 0 -> stone
   * 1 -> scissors
   * 2 -> paper

   */
  private void battle(int player_hand) {

    int cpu_hand = returnCpuHand();
    int winner = judgeWinner(player_hand, cpu_hand);
    outputResultText(cpu_hand, winner);

  }

  /*
   * CPUが選択した手を返す
   * 0 -> stone
   * 1 -> scissors
   * 2 -> paper
   */
  private int returnCpuHand() {

    Random rand = new Random();
    int cpu_hand = rand.nextInt(3);

    return cpu_hand;
  }

  /*
   * ユーザが選んだ手とCPUが選んだ手を比較し、勝敗を決定する
   * winner(int) : ユーザの勝利で０、CPUの勝利で１、あいこで２を返す
   */
  private int judgeWinner(int player_hand, int cpu_hand) {

    if (player_hand == 0 && cpu_hand == 1 || player_hand == 1 && cpu_hand == 2 || player_hand == 2 && cpu_hand == 0) {
      return 0;
    } else if (player_hand == 1 && cpu_hand == 0 || player_hand == 2 && cpu_hand == 1 || player_hand == 0 && cpu_hand == 2) {
      return 1;
    } else {
      return 2;
    }

  }

  /*
   * CPUのじゃんけんの手と
   * 勝敗をテキストに出力
   */
  private void outputResultText(int cpu_hand, int winner) {

    String cpu_hand_text = toStrCpuHand(cpu_hand);
    String winner_text = toStrWinner(winner);

    this.result_text.setText("CPUは" + cpu_hand_text + "でした。" + winner_text);
  }

  /*
   * CPUの手を数値から文字列へなおす
   */
  private String toStrCpuHand(int cpu_hand) {

    switch (cpu_hand) {

      case 0 :
        return "グー";

      case 1 :
        return "チョキ";

      case 2 :
        return "パー";

    }

    return "error!";
  }

  private String toStrWinner(int winner) {

    switch (winner) {

      case 0 :
        return "あなたの勝ちです";

      case 1 :
        return "CPUの勝ちです";

      case 2 :
        return "あいこです";

    }

    return "error!";

  }

}
