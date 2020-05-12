package com.example.drawingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Path;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
     private  boolean isDrawInit;
    @Override
    protected void onPostResume() {
        super.onPostResume();
        if(!isDrawInit){
            intiDraw();

            final Button clearButton= findViewById(R.id.clear);
            clearButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    paintView.clear();
                }
            });

            final TextView bruchsize=findViewById(R.id.DisplaybrushSzie);
            bruchsize.setText("20");
            final TextView brushColor=findViewById(R.id.DisplaybrushCOLOR);
            brushColor.setText("black");

            final Button incBrushSize=findViewById(R.id.brushSizINC);
            incBrushSize.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    paintView.brushSize++;
                    bruchsize.setText(String.valueOf(paintView.brushSize));
                }
            });


            final Button DECBruchSize= findViewById(R.id.brushSizDEC);
            DECBruchSize.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(paintView.brushSize >1){

                        paintView.brushSize--;
                        bruchsize.setText(String.valueOf(paintView.brushSize));

                    }
                }
            });
            final Button changcolor=findViewById(R.id.changeColor);
            changcolor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(paintView.brushColor== Color.BLACK){

                        paintView.brushColor=Color.RED;
                        brushColor.setText("Red");
                    }else if(paintView.brushColor ==Color.RED){
                        paintView.brushColor=Color.YELLOW;
                        brushColor.setText("YELLOW");

                    }


                    else {
                        paintView.brushColor=Color.BLACK;
                        brushColor.setText("BLACK");

                    }
                }
            });


            isDrawInit =true;
        }
    }

    private PaintView paintView;
    private  void  intiDraw(){
        paintView=findViewById(R.id.paintView);
        DisplayMetrics metrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        paintView.init(metrics);
    }


    static  class FingerPath{
        int color;
        int strokeWidth;
        Path path;
        FingerPath(int color,int strokeWidth,Path path){
          this.color=color;
          this.strokeWidth=strokeWidth;
          this.path=path;

        }




    }
}
