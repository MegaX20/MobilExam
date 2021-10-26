package com.example.mobilexamain;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.behavior.SwipeDismissBehavior;

public class RateActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener  {

    TextView textView1;
    String strModel[], strRelease[], strLink[], strCamera[], strMemory[], strScreen[], strPrice[], strCpu[], strGpu[], strBattery[];
    int photo[] = {R.drawable.apple_ipad_pro_11, R.drawable.apple_iphone_11_pro_max,
            R.drawable.apple_iphone_8, R.drawable.apple_iphone_8_plus,
            R.drawable.apple_iphone_se_2020, R.drawable.apple_iphone_x,
            R.drawable.huawei_mate30_pro_5g, R.drawable.huawei_mate_xs,
            R.drawable.huawei_nova_5t, R.drawable.huawei_nova_7i,
            R.drawable.huawei_p40_pro, R.drawable.huawei_p20_pro,
            R.drawable.lg_g8_thinq, R.drawable.lg_k30_2019,
            R.drawable.lg_q92_5g, R.drawable.lg_v30_thinq,
            R.drawable.lg_v60_thinq_5g, R.drawable.lg_velvet,
            R.drawable.samsung_galaxy_m51, R.drawable.samsung_galaxy_note10_5g,
            R.drawable.samsung_galaxy_note20_ultra, R.drawable.samsung_galaxy_s20,
            R.drawable.samsung_galaxy_tab_s6_lite, R.drawable.samsung_galaxy_z_flip_5g,
            R.drawable.sony_xperia_1, R.drawable.sony_xperia_10,
            R.drawable.sony_xperia_10_ii, R.drawable.sony_xperia_1_ii,
            R.drawable.sony_xperia_5_ii_5g, R.drawable.sony_xperia_l4,
            R.drawable.xiaomi_poco_f2_pro, R.drawable.xiaomi_poco_x3,
            R.drawable.xiaomi_poco_x3_nfc, R.drawable.xiaomi_redmi_9a,
            R.drawable.xiaomi_redmi_k30_ultra, R.drawable.xiaomi_redmi_note_9_pro};
    private RecyclerView recyclerView1;

    private ToggleButton toggleButton;
    public Boolean state;
    private Button applySelectionBtn;
    private Integer clickcount;
    private TextView textViewCounter;
    private Context context;
    private Switch aSwitch;
    public CompoundButton compoundButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        clickcount=0;
        textView1 =(TextView) findViewById(R.id.hyperLink1);
        //toggleButton= (ToggleButton) findViewById(R.id.toggleRate01);

        //applySelectionBtn=findViewById(R.id.applySelectionBtn);
        //textViewCounter=findViewById(R.id.textViewCounter);


        /*
        CompoundButton compoundButton=new CompoundButton(getApplicationContext()) {
            @Override
            public void setOnTouchListener(OnTouchListener listener) {
                super.setOnTouchListener(listener);
                
            }
        };
        if(compoundButton.isChecked()){
            callToggleOnClick();
        }
        else {
            callToggleOffClick();
        }*/




        strModel = getResources().getStringArray(R.array.mobiles_models);
        strRelease = getResources().getStringArray(R.array.Release_year_month);
        strLink = getResources().getStringArray(R.array.link);
        strCamera = getResources().getStringArray(R.array.photos_and_video_in_camera);
        strMemory = getResources().getStringArray(R.array.ram_and_internal_memory);
        strScreen = getResources().getStringArray(R.array.screen_size);
        strPrice = getResources().getStringArray(R.array.price);
        strCpu = getResources().getStringArray(R.array.CPU);
        strGpu = getResources().getStringArray(R.array.GPU);
        strBattery = getResources().getStringArray(R.array.battery);


        /*String thisLink = getString(R.string.thisLink);
        String yourString = getString(R.string.submitText, thisLink);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(yourString);
        spannableStringBuilder.setSpan(click,
                startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);*/

        recyclerView1 = findViewById(R.id.recyclerView);

        MyAdapter myAdapter = new MyAdapter(this, strModel, strRelease, strLink, strCamera, strMemory, strScreen, strPrice, strCpu, strGpu, strBattery, photo);
        recyclerView1.setAdapter(myAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        Button login = (Button) findViewById(R.id.loginRa);

        Button qa = (Button) findViewById(R.id.qaRa);

        Button review = (Button) findViewById(R.id.reviewRa);

        Button search = (Button) findViewById(R.id.searchRa);

        Button chose = (Button) findViewById(R.id.choseRa);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        qa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qa();
            }
        });

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                review();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });
        chose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chose();
            }
        });


    }

    public void login() {
        Intent intentL = new Intent(this, LoginActivity.class);
        startActivity(intentL);
    }

    public void qa() {
        Intent intentRa = new Intent(this, QaActivity.class);
        startActivity(intentRa);
    }

    public void review() {
        Intent intentR = new Intent(this, ReviewActivity.class);
        startActivity(intentR);
    }

    public void search() {
        Intent intentS = new Intent(this, SearchActivity.class);
        startActivity(intentS);
    }
    public void chose() {
        Intent intentC = new Intent(this, ChoseActivity.class);
        startActivity(intentC);
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean bool) {
        compoundButton.performClick();
        compoundButton.setPressed(!compoundButton.isPressed());
        compoundButton.setChecked(!compoundButton.isChecked());
        compoundButton.setClickable(!compoundButton.isClickable());
        compoundButton.setClickable(!bool);
        compoundButton.setOnCheckedChangeListener(RateActivity.this);

        if(bool==true){

            clickcount++;
            if (clickcount==1){
                Toast.makeText(getBaseContext(),"The switch button is selected only 1 time ,Please select 2 switches",Toast.LENGTH_LONG).show();
            }
            if (clickcount==2){
                Intent intentMatch=new Intent(getBaseContext(),MatchActivity.class);
                startActivity(intentMatch);
            }

        }
        else {
            clickcount--;
            if (clickcount==1){
                Toast.makeText(getBaseContext(),"The switch button is selected only 1 time ,Please select 2 switches",Toast.LENGTH_LONG).show();
            }
            if (clickcount==2){
                Intent intentMatch=new Intent(getBaseContext(),MatchActivity.class);
                startActivity(intentMatch);
            }

        }
    }
    /*
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    public void callToggleOnClick(){
        applySelectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Test1",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void callToggleOffClick(){
        applySelectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "The switch button isn't selected ,Please select 2 switches", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onTouch(View view ,MotionEvent motionEvent){

    }*/
}



