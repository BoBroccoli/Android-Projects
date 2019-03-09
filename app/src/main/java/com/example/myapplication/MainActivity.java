package com.example.myapplication;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Integer turn = 1;
    private  Integer totalMove = 0;
    //red 1 yellow 2
    private int [][] current = new int [3][3];
    private boolean end = false;
    private boolean checkWin() {
        for(int i = 0; i<=2; i++){
            if(current[i][0]==current[i][1] && current[i][1]==current[i][2] && current[i][0]!=0){
                return true;
            }
        }
        for(int j = 0; j<=2; j++){
            if(current[0][j]==current[1][j] && current[1][j]==current[2][j] && current[0][j]!=0){
                return true;
            }
        }
        if(current[0][0]==current[1][1] && current[1][1] == current[2][2] &&current[0][0]!=0
                ||
                current[2][0]==current[1][1] && current[1][1] == current[0][2] && current[2][0]!=0
        ) {
            return true;
        }
        return  false;
    }

    public void move(View view) {
        ImageView imageView = (ImageView) view;
        if(totalMove == 8){

            LinearLayout panel = (LinearLayout) findViewById(R.id.panel);
            EditText text = (EditText) findViewById(R.id.editText);
            text.setText("Tie");
            panel.setVisibility(View.VISIBLE);
            end =true;
        }
        if (turn == 1 && !end) {
            if(current[Integer.parseInt(imageView.getTag().toString())/3][Integer.parseInt(imageView.getTag().toString())%3] == 0) {
                imageView.setBackgroundResource(R.drawable.red);
                imageView.animate().scaleX(2f).scaleY(2f).scaleX(0.5f).scaleY(0.5f).setDuration(300).start();
                turn = 2;
                totalMove++;
                current[Integer.parseInt(imageView.getTag().toString()) / 3][Integer.parseInt(imageView.getTag().toString()) % 3] = turn;
                if(checkWin()){
                    LinearLayout panel = (LinearLayout) findViewById(R.id.panel);
                    EditText text = (EditText) findViewById(R.id.editText);
                    text.setText("RED WON");
                    panel.setVisibility(View.VISIBLE);
                    end =true;
                }
            }
            else{
                Toast.makeText(this,"Make another move",Toast.LENGTH_LONG).show();
            }
        }
        else if(!end){
            if(current[Integer.parseInt(imageView.getTag().toString())/3][Integer.parseInt(imageView.getTag().toString())%3] == 0) {
                imageView.setBackgroundResource(R.drawable.yellow);
                imageView.animate().scaleX(2f).scaleY(2f).scaleX(0.5f).scaleY(0.5f).setDuration(300).start();
                turn = 1;
                totalMove++;
                current[Integer.parseInt(imageView.getTag().toString()) / 3][Integer.parseInt(imageView.getTag().toString()) % 3] = turn;
                if (checkWin()) {
                    LinearLayout panel = (LinearLayout) findViewById(R.id.panel);
                    EditText text = (EditText) findViewById(R.id.editText);
                    text.setText("YELLOW WON");
                    panel.setVisibility(View.VISIBLE);
                    end =true;
                }
            }
            else{
                Toast.makeText(this,"Make another move",Toast.LENGTH_LONG).show();
                end = true;
            }
        }
    }
    public void restart(View view){
        Button restart = (Button) findViewById(R.id.restart);
        LinearLayout panel = (LinearLayout) findViewById(R.id.panel);
        end = false;
        turn = 1;
        totalMove = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                current[i][j] = 0;
            }
        }
        ImageView red = (ImageView) findViewById(R.id.red);
        red.setBackgroundResource(0);

        ImageView red2 = (ImageView) findViewById(R.id.red2);
        red2.setBackgroundResource(0);

        ImageView red3 = (ImageView) findViewById(R.id.red3);
        red3.setBackgroundResource(0);

        ImageView red4 = (ImageView) findViewById(R.id.red4);
        red4.setBackgroundResource(0);

        ImageView red5 = (ImageView) findViewById(R.id.red5);
        red5.setBackgroundResource(0);

        ImageView red6 = (ImageView) findViewById(R.id.red6);
        red6.setBackgroundResource(0);

        ImageView red7 = (ImageView) findViewById(R.id.red7);
        red7.setBackgroundResource(0);
        ImageView red8 = (ImageView) findViewById(R.id.red8);
        red8.setBackgroundResource(0);

        ImageView red9 = (ImageView) findViewById(R.id.red9);
        red9.setBackgroundResource(0);

        panel.setVisibility(View.INVISIBLE);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean end = false;

    }
}
