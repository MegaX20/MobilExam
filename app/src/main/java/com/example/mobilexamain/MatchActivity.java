package com.example.mobilexamain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {
    public  ImageView imagePhone1,imagePhone2;
    public TextView batteryPhone1Value,batteryPhone2Value,cameraPhone1Value,cameraPhone2Value,
            cpuPhone1Value,cpuPhone2Value, gpuPhone1Value, gpuPhone2Value,linkPhone1Value,
            linkPhone2Value,memoryPhone1Value,memoryPhone2Value, modelPhone1Value,
            modelPhone2Value, pricePhone1Value, pricePhone2Value,releasePhone1Value,
            releasePhone2Value,screenPhone1Value,screenPhone2Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        final Button backToChose=findViewById(R.id.backToChose);

        imagePhone1=findViewById(R.id.imagePhone1);
        imagePhone2=findViewById(R.id.imagePhone2);
        batteryPhone1Value=findViewById(R.id.batteryPhone1Value);
        batteryPhone2Value=findViewById(R.id.batteryPhone2Value);
        cameraPhone1Value=findViewById(R.id.cameraPhone1Value);
        cameraPhone2Value=findViewById(R.id.cameraPhone2Value);
        cpuPhone1Value=findViewById(R.id.cpuPhone1Value);
        cpuPhone2Value=findViewById(R.id.cpuPhone2Value);
        gpuPhone1Value=findViewById(R.id.gpuPhone1Value);
        gpuPhone2Value=findViewById(R.id.gpuPhone2Value);
        linkPhone1Value=findViewById(R.id.linkPhone1Value);
        linkPhone2Value=findViewById(R.id.linkPhone2Value);
        memoryPhone1Value=findViewById(R.id.memoryPhone1Value);
        memoryPhone2Value=findViewById(R.id.memoryPhone2Value);
        modelPhone1Value=findViewById(R.id.modelPhone1Value);
        modelPhone2Value=findViewById(R.id.modelPhone2Value);
        pricePhone1Value=findViewById(R.id.pricePhone1Value);
        pricePhone2Value=findViewById(R.id.pricePhone2Value);
        releasePhone1Value=findViewById(R.id.releasePhone1Value);
        releasePhone2Value=findViewById(R.id.releasePhone2Value);
        screenPhone1Value=findViewById(R.id.screenPhone1Value);
        screenPhone2Value=findViewById(R.id.screenPhone2Value);

        backToChose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToChose();
            }
        });
        ChoseActivity choseActivity=new ChoseActivity();
        View view=new View(getApplicationContext());
        choseActivity.onChosen(view);
        imagePhone1=choseActivity.apple1;
        imagePhone2=choseActivity.apple2;
    }

    public void backToChose(){
        Intent intentBTC=new Intent(MatchActivity.this,ChoseActivity.class);
        startActivity(intentBTC);
    }

}