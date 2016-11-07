package com.example.acer.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.view.GestureDetector.*;

public class MainActivity extends AppCompatActivity implements OnGestureListener{
    private GestureDetector gDetector;

    private float mLastx;
    private float mLasty;
    float initialX ;
    float initialY;
    private float x1,x2,y1,y2;
    static final int MIN_DISTANCE = 10;
    LinearLayout gameScreen,activityG;
    Button btn[][] = new Button[4][4];
    Button right,left,up,down;
    Button new_or_restart_the_game;
    private int color2 = Color.parseColor("#eee4da");
    private final int COLOR_LESS_THAN_16 = Color.parseColor("#6a615a");
    private final int COLOR_MOST_THAN_16 = Color.parseColor("#f1f6f9");
    private final int COLOR_FOR_8 = Color.parseColor("#efb27c");
    private final int COLOR_FOR_16 = Color.parseColor("#f39768");
    private final int COLOR_FOR_32 = Color.parseColor("#f37d63");
    private final int COLOR_FOR_64 = Color.parseColor("#f46042");
    private final int COLOR_FOR_128 = Color.parseColor("#eacf76");
    private final int COLOR_FOR_256 = Color.parseColor("#edcb67");
    private final int COLOR_FOR_512 = Color.parseColor("#ecc85a");
    private final int COLOR_FOR_1024 = Color.parseColor("#e7c15e");
    private final int COLOR_FOR_2048 = Color.parseColor("#e8be4e");
    private final int COLOR_FOR_4 = Color.parseColor("#ece0ca");
    private final  int DEFAULT_COLOR = Color.parseColor("#cdc1b5");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gDetector = new GestureDetector(this);
        gameScreen = (LinearLayout)findViewById(R.id.GameScreen);
        activityG = (LinearLayout)findViewById(R.id.activity_main);
        btn[0][0] = (Button)findViewById(R.id.btn1);
        btn[0][1] = (Button)findViewById(R.id.btn2);
        btn[0][2] = (Button)findViewById(R.id.btn3);
        btn[0][3] = (Button)findViewById(R.id.btn4);
        btn[1][0] = (Button)findViewById(R.id.btn5);
        btn[1][1] = (Button)findViewById(R.id.btn6);
        btn[1][2] = (Button)findViewById(R.id.btn7);
        btn[1][3] = (Button)findViewById(R.id.btn8);
        btn[2][0] = (Button)findViewById(R.id.btn9);
        btn[2][1] = (Button)findViewById(R.id.btn10);
        btn[2][2] = (Button)findViewById(R.id.btn11);
        btn[2][3] = (Button)findViewById(R.id.btn12);
        btn[3][0] = (Button)findViewById(R.id.btn13);
        btn[3][1] = (Button)findViewById(R.id.btn14);
        btn[3][2] = (Button)findViewById(R.id.btn15);
        btn[3][3] = (Button)findViewById(R.id.btn16);
        right = (Button)findViewById(R.id.rightB);
        up = (Button)findViewById(R.id.upB);
        down = (Button)findViewById(R.id.bottomB);
        left = (Button)findViewById(R.id.leftB);
        new_or_restart_the_game = (Button)findViewById(R.id.newGameorRestart);


        //Listeners

        activityG.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getActionMasked();

                switch (action) {

                    case MotionEvent.ACTION_DOWN:
                        initialX = event.getX();
                        initialY = event.getY();

                        break;

                    case MotionEvent.ACTION_MOVE:
                        break;

                    case MotionEvent.ACTION_UP:
                        float finalX = event.getX();
                        float finalY = event.getY();


                        if (initialX < finalX) {
                           if (leftToRight(5,5)) or();
                        }

                        if (initialX > finalX) {
                            if (rightToLeft()) or();
                        }

                        if (initialY < finalY) {
                            if (down()) or();
                        }

                        if (initialY > finalY) {
                            if (up()) or();
                        }

                        break;

                    case MotionEvent.ACTION_CANCEL:
                        Toast.makeText(MainActivity.this,"Canceled",Toast.LENGTH_SHORT).show();
                        break;

                    case MotionEvent.ACTION_OUTSIDE:
                        Toast.makeText(MainActivity.this,"outside",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (down())or();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (leftToRight(5,5)) or();
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (up()) or();
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rightToLeft()) or();
            }
        });
        new_or_restart_the_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (new_or_restart_the_game.getText().toString().equals("NEW GAME")){
                    new_or_restart_the_game.setText("RESTART");
                    or();
                }else {
                    for (int i = 0; i <4 ; i++) {
                        for (int j = 0; j <4 ; j++) {
                            btn[i][j].setText("");
                            btn[i][j].setBackgroundColor(DEFAULT_COLOR);
                        }
                    }
                    or();
                }
            }
        });

    }

    //methods


    private void or(){
        int two_or_for;
       switch (rand()){
           case 4:
           case 8:
           case 9: two_or_for = 4;
               break;
           default: two_or_for = 2;
               break;
       }
        int i = forTile();
        int j = forTile();
        if (btn[i][j].getText().toString().equals("")){
            btn[i][j].setTextSize(30);
            btn[i][j].setTextColor(COLOR_LESS_THAN_16);
            if (two_or_for == 2){
                btn[i][j].setText("2");
                btn[i][j].setBackgroundColor(color2);
            }else {
                btn[i][j].setText("4");
                btn[i][j].setBackgroundColor(COLOR_FOR_4);

            }
        }else or();
    }
    private int rand(){
        return (int)(Math.random()*10);
    }
    private  int forTile(){
        int less_than_tree;
        less_than_tree = (int)(Math.random()*10);
        if (less_than_tree <= 3) return less_than_tree;
        else return forTile();
    }


    int key = 5;

    private boolean leftToRight(int x1,int y1) {

        boolean b = false;
        for (int i = 0; i <4 ; i++) {
            for (int j = 3; j >=0 ; j--) {
                if (j != 3 && btn[i][j + 1].getText().toString().equals("") && !btn[i][j].getText().toString().equals("") ) {
                    b = true;
                    btn[i][j + 1].setText(btn[i][j].getText());
                    btn[i][j+1].setTextSize(30);
                    btn[i][j + 1].setBackgroundColor(colorTile(btn[i][j]));
                    btn[i][j + 1].setTextColor(textColor(btn[i][j + 1].getText().toString()));
                    btn[i][j].setBackgroundColor(DEFAULT_COLOR);
                    btn[i][j].setText("");

                    if (!leftToRight(x1,y1));
                }
                if (j != 3 && btn[i][j + 1].getText().toString().equals(btn[i][j].getText().toString()) && !btn[i][j].getText().equals("")) {
                    Toast.makeText(getApplicationContext(), "i = " + x1 + ", j ="+ j,Toast.LENGTH_SHORT).show();
                    if (j == x1 && i == y1) {
                    Toast.makeText(getApplicationContext(),"IF",Toast.LENGTH_SHORT).show();
                    }else
                    {
                        b = true;
                        btn[i][j + 1].setText(String.valueOf(Integer.parseInt(btn[i][j].getText().toString()) * 2));
                        btn[i][j].setBackgroundColor(DEFAULT_COLOR);
                        btn[i][j].setText("");
                        btn[i][j + 1].setTextSize(30);
                        btn[i][j + 1].setBackgroundColor(colorTile(btn[i][j + 1]));
                        btn[i][j + 1].setTextColor(textColor(btn[i][j + 1].getText().toString()));
                        x1 = j+1;
                        y1 = i;
                        Toast.makeText(getApplicationContext(),"k= "+ x1 + ", kY = "+y1,Toast.LENGTH_SHORT).show();
                        if (!leftToRight(x1,y1)) break;
                    }
                }

            }

        }
        return b;
    }
    private boolean rightToLeft() {
        boolean b = false;
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <=3 ; j++) {
                if (j != 0 && btn[i][j - 1].getText().toString().equals("") && !btn[i][j].getText().toString().equals("")) {
                    b = true;
                    btn[i][j - 1].setText(btn[i][j].getText());
                    btn[i][j-1].setTextSize(30);
                    btn[i][j - 1].setBackgroundColor(colorTile(btn[i][j]));
                    btn[i][j -1].setTextColor(textColor(btn[i][j - 1].getText().toString()));
                    btn[i][j].setBackgroundColor(DEFAULT_COLOR);
                    btn[i][j].setText("");
                }else
                if (j != 0 && btn[i][j - 1].getText().toString().equals(btn[i][j].getText().toString()) && !btn[i][j].getText().equals("")) {
                    b = true;
                    btn[i][j-1].setText(String.valueOf(Integer.parseInt(btn[i][j].getText().toString())*2));
                    btn[i][j].setBackgroundColor(DEFAULT_COLOR);
                    btn[i][j].setText("");
                    btn[i][j-1].setTextSize(30);
                    btn[i][j - 1].setBackgroundColor(colorTile(btn[i][j-1]));
                    btn[i][j - 1].setTextColor(textColor(btn[i][j - 1].getText().toString()));
                }

            }
        }
        if (b) rightToLeft();
        return b;
    }
    private boolean up() {
        boolean b = false;
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <=3 ; j++) {
                if (j != 0 && btn[j-1][i].getText().toString().equals("") && !btn[j][i].getText().toString().equals("")) {
                    b = true;
                    btn[j-1][i].setText(btn[j][i].getText());
                    btn[j-1][i].setTextSize(30);
                    btn[j-1][i].setBackgroundColor(colorTile(btn[j][i]));
                    btn[j-1][i].setTextColor(textColor(btn[j-1][i].getText().toString()));
                    btn[j][i].setBackgroundColor(DEFAULT_COLOR);
                    btn[j][i].setText("");
                }else
                if (j != 0 && btn[j-1][i].getText().toString().equals(btn[j][i].getText().toString()) && !btn[j][i].getText().equals("")) {
                    b = true;
                    btn[j-1][i].setText(String.valueOf(Integer.parseInt(btn[j][i].getText().toString())*2));
                    btn[j][i].setBackgroundColor(DEFAULT_COLOR);
                    btn[j][i].setText("");
                    btn[j-1][i].setTextSize(30);
                    btn[j-1][i].setBackgroundColor(colorTile(btn[j-1][i]));
                    btn[j-1][i].setTextColor(textColor(btn[j-1][i].getText().toString()));
                }

            }
        }
        if (b) up();
        return b;
    }
    private boolean down() {
        boolean b = false;
        for (int i = 0; i <4 ; i++) {
            for (int j = 3; j >=0 ; j--) {
                if (j != 3 && btn[j+1][i].getText().toString().equals("") && !btn[j][i].getText().toString().equals("")) {
                    b = true;
                    btn[j+1][i].setText(btn[j][i].getText());
                    btn[j+1][i].setTextSize(30);
                    btn[j+1][i].setBackgroundColor(colorTile(btn[j][i]));
                    btn[j+1][i].setTextColor(textColor(btn[j+1][i].getText().toString()));
                    btn[j][i].setBackgroundColor(DEFAULT_COLOR);
                    btn[j][i].setText("");
                }else
                if (j != 3 && btn[j+1][i].getText().toString().equals(btn[j][i].getText().toString()) && !btn[j][i].getText().equals("")) {
                    b = true;
                    btn[j+1][i].setText(String.valueOf(Integer.parseInt(btn[j][i].getText().toString())*2));
                    btn[j][i].setBackgroundColor(DEFAULT_COLOR);
                    btn[j][i].setText("");
                    btn[j+1][i].setTextSize(30);
                    btn[j+1][i].setBackgroundColor(colorTile(btn[j+1][i]));
                    btn[j+1][i].setTextColor(textColor(btn[j+1][i].getText().toString()));
                }

            }
        }
        if (b) down();
        return b;
    }

    private int textColor(String text) {
        if (Integer.parseInt(text) < 8) return COLOR_LESS_THAN_16;
        return COLOR_MOST_THAN_16;
    }

    private int colorTile(Button button) {
        switch (button.getText().toString()){
            case "2":
                return color2;
            case "4":
                return COLOR_FOR_4;
            case "8":
                return COLOR_FOR_8;
            case "16":
                return COLOR_FOR_16;
            case "32":
                return COLOR_FOR_32;
            case "64":
                return COLOR_FOR_64;
            case "128":
                return COLOR_FOR_128;
            case "256":
                return COLOR_FOR_256;
            case "512":
                return COLOR_FOR_512;
            case "1024":
                return COLOR_FOR_1024;
            case "2048":
                return COLOR_FOR_2048;
            default:return DEFAULT_COLOR;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        return gDetector.onTouchEvent(motionEvent);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent start, MotionEvent finish, float v, float v1) {
        if (start.getX() > finish.getX()) Toast.makeText(MainActivity.this,"Right",Toast.LENGTH_SHORT).show();
        return true;
    }
}

