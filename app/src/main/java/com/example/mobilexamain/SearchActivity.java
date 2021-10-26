package com.example.mobilexamain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {


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











    /*
    //String strCamera[], strBattery[], strMemory[], strScreen[], strPrice[], strCPU[], strLink[], fireBaseData[];
    int photo2[] = {R.drawable.apple_ipad_pro_11, R.drawable.apple_iphone_11_pro_max,
            R.drawable.apple_iphone_8,R.drawable.apple_iphone_8_plus,
            R.drawable.apple_iphone_se_2020,R.drawable.apple_iphone_x,
            R.drawable.huawei_mate30_pro_5g, R.drawable.huawei_mate_xs,
            R.drawable.huawei_nova_5t,R.drawable.huawei_nova_7i,
            R.drawable.huawei_p40_pro,R.drawable.huawei_p20_pro,
            R.drawable.lg_g8_thinq,R.drawable.lg_k30_2019,
            R.drawable.lg_q92_5g, R.drawable.lg_v30_thinq,
            R.drawable.lg_v60_thinq_5g,R.drawable.lg_velvet,
            R.drawable.samsung_galaxy_m51,R.drawable.samsung_galaxy_note10_5g,
            R.drawable.samsung_galaxy_note20_ultra,R.drawable.samsung_galaxy_s20,
            R.drawable.samsung_galaxy_tab_s6_lite,R.drawable.samsung_galaxy_z_flip_5g,
            R.drawable.sony_xperia_1,R.drawable.sony_xperia_10,
            R.drawable.sony_xperia_10_ii,R.drawable.sony_xperia_1_ii,
            R.drawable.sony_xperia_5_ii_5g,R.drawable.sony_xperia_l4,
            R.drawable.xiaomi_poco_f2_pro,R.drawable.xiaomi_poco_x3,
            R.drawable.xiaomi_poco_x3_nfc,R.drawable.xiaomi_redmi_9a,
            R.drawable.xiaomi_redmi_k30_ultra,R.drawable.xiaomi_redmi_note_9_pro};
    //Widgets
    RecyclerView recyclerView;
    //firebase
    private DatabaseReference myReff;
    //variable
    private ArrayList<PhonesFirebaseDB> phonesFbDBArrayList1,phonesFbDBArrayList2,phonesFbDBArrayList3,phonesFbDBArrayList4,
            phonesFbDBArrayList5,phonesFbDBArrayList6,phonesFbDBArrayList7,phonesFbDBArrayList8,phonesFbDBArrayList9;
    private MyNewAdapter myNewAdapter;
    //     private List<PhonesFirebaseDB>filterList;
    private FirebaseDatabase database;
    private Context context;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);




        Button login = (Button) findViewById(R.id.loginS);

        Button rate = (Button) findViewById(R.id.rateS);

        Button qa = (Button) findViewById(R.id.qaS);

        Button review = (Button) findViewById(R.id.reviewS);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate();
            }
        });
        qa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qa();
            }
        });
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                review();
            }
        });



        /*strCamera = getResources().getStringArray(R.array.photos_and_video_in_camera);
        strBattery = getResources().getStringArray(R.array.battery);
        strMemory = getResources().getStringArray(R.array.ram_and_internal_memory);
        strScreen = getResources().getStringArray(R.array.screen_size);
        strPrice = getResources().getStringArray(R.array.price);
        strCPU = getResources().getStringArray(R.array.CPU);
        strLink = getResources().getStringArray(R.array.link);*/
        /*
        recyclerView = findViewById(R.id.recyclerViewS); // db read new 1

        LinearLayoutManager linearManager = new LinearLayoutManager(this); //db read new 2
        recyclerView.setLayoutManager(linearManager); //db new read 3
        recyclerView.setHasFixedSize(true); //db new read 4

        //firebase
        myReff = FirebaseDatabase.getInstance().getReference(); //db new read 5

        //ArrayList
        phonesFbDBArrayList1=new ArrayList<>();*/
        /*phonesFbDBArrayList2=new ArrayList<>();
        phonesFbDBArrayList3=new ArrayList<>();
        phonesFbDBArrayList4=new ArrayList<>();
        phonesFbDBArrayList5=new ArrayList<>();
        phonesFbDBArrayList6=new ArrayList<>();
        phonesFbDBArrayList7=new ArrayList<>();
        phonesFbDBArrayList8=new ArrayList<>();
        phonesFbDBArrayList9=new ArrayList<>();*/
        /*
        //Clear ArrayList
        ClearAll();
        // Get Data Method
        getDataFromFirebase();

        //MyNewAdapter myNewAdapter = new MyNewAdapter(this, strCamera, strBattery, strMemory, strScreen, strPrice, strCPU, strLink, photo2);


        //mPhoneList.setLayoutManager(new LinearLayoutManager(this));//3 for db

        //database = FirebaseDatabase.getInstance();
        //myReff = database.getReference("phones");
        //CALL FOR setUpRecylerView()
//        setUpRecylerView();
    }*/

    //READ DB
    /*private void getDataFromFirebase() {
        Query query =myReff.child("phones");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                ClearAll();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){

                    PhonesFirebaseDB phonesFbDB1=new PhonesFirebaseDB();
                    phonesFbDB1.setBattery(snapshot.child("battery").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB1);
                    PhonesFirebaseDB phonesFbDB3=new PhonesFirebaseDB();
                    phonesFbDB3.setCpu(snapshot.child("CPU").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB3);
                    PhonesFirebaseDB phonesFbDB4=new PhonesFirebaseDB();
                    phonesFbDB4.setCamera(snapshot.child("Camera").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB4);
                    PhonesFirebaseDB phonesFbDB5=new PhonesFirebaseDB();
                    phonesFbDB5.setCpu(snapshot.child("GPU").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB5);
                    PhonesFirebaseDB phonesFbDB6=new PhonesFirebaseDB();
                    phonesFbDB6.setMemory(snapshot.child("Memory").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB6);
                    PhonesFirebaseDB phonesFbDB7=new PhonesFirebaseDB();
                    phonesFbDB7.setPrice(snapshot.child("Price").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB7);
                    PhonesFirebaseDB phonesFbDB8=new PhonesFirebaseDB();
                    phonesFbDB8.setPrice(snapshot.child("Screen").child("Screen").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB8);
                    PhonesFirebaseDB phonesFbDB9=new PhonesFirebaseDB();
                    phonesFbDB9.setMemory(snapshot.child("Video").child("Video").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB9);
                    //PhonesFirebaseDB phonesFbDB2=new PhonesFirebaseDB();

                    /*PhonesFirebaseDB phonesFbDB3=new PhonesFirebaseDB();
                    PhonesFirebaseDB phonesFbDB4=new PhonesFirebaseDB();
                    PhonesFirebaseDB phonesFbDB5=new PhonesFirebaseDB();
                    PhonesFirebaseDB phonesFbDB6=new PhonesFirebaseDB();
                    PhonesFirebaseDB phonesFbDB7=new PhonesFirebaseDB();
                    PhonesFirebaseDB phonesFbDB8=new PhonesFirebaseDB();
                    PhonesFirebaseDB phonesFbDB9=new PhonesFirebaseDB();


                    //phonesFbDB18.setImage(snapshot.child("image").getValue().toString());

                }*/
                /*for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    PhonesFirebaseDB phonesFbDB2=new PhonesFirebaseDB();
                    phonesFbDB2.setBuy(snapshot.child("BuyLink").getValue().toString());

                }*/
                /*
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    PhonesFirebaseDB phonesFbDB3=new PhonesFirebaseDB();
                    phonesFbDB3.setCpu(snapshot.child("CPU").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB3);
                }
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    PhonesFirebaseDB phonesFbDB4=new PhonesFirebaseDB();
                    phonesFbDB4.setCamera(snapshot.child("Camera").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB4);
                }
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    PhonesFirebaseDB phonesFbDB5=new PhonesFirebaseDB();
                    phonesFbDB5.setCpu(snapshot.child("GPU").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB5);
                }
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    PhonesFirebaseDB phonesFbDB6=new PhonesFirebaseDB();
                    phonesFbDB6.setMemory(snapshot.child("Memory").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB6);
                }
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    PhonesFirebaseDB phonesFbDB7=new PhonesFirebaseDB();
                    phonesFbDB7.setPrice(snapshot.child("Price").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB7);
                }
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    PhonesFirebaseDB phonesFbDB8=new PhonesFirebaseDB();
                    phonesFbDB8.setPrice(snapshot.child("Screen").child("Screen").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB8);
                }
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    PhonesFirebaseDB phonesFbDB9=new PhonesFirebaseDB();
                    phonesFbDB9.setMemory(snapshot.child("Video").child("Video").getValue().toString());
                    phonesFbDBArrayList1.add(phonesFbDB9);
                }*/
               /* myNewAdapter=new MyNewAdapter(getApplicationContext(),phonesFbDBArrayList1,/*phonesFbDBArrayList2,phonesFbDBArrayList3,phonesFbDBArrayList4,
                        phonesFbDBArrayList5,phonesFbDBArrayList6,phonesFbDBArrayList7,phonesFbDBArrayList8,phonesFbDBArrayList9,*/ //photo2);
//                filterList=new ArrayList<>();

                /*recyclerView.setAdapter(myNewAdapter);
                myNewAdapter.notifyDataSetChanged();*/
                /*/filterList.addAll(phonesFbDBArrayList1);
                filterList.addAll(phonesFbDBArrayList9);
                filterList.addAll(phonesFbDBArrayList3);
                filterList.addAll(phonesFbDBArrayList4);
                filterList.addAll(phonesFbDBArrayList5);
                filterList.addAll(phonesFbDBArrayList6);
                filterList.addAll(phonesFbDBArrayList7);
                filterList.addAll(phonesFbDBArrayList8);/*/
            /*}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void ClearAll(){
        if(phonesFbDBArrayList1!=null){
            phonesFbDBArrayList1.clear();

            if(myNewAdapter!=null){
                myNewAdapter.notifyDataSetChanged();
            }
        }
        /*if(phonesFbDBArrayList2!=null){
            phonesFbDBArrayList1.clear();
            if(myNewAdapter!=null){
                myNewAdapter.notifyDataSetChanged();
            }
        }
        if(phonesFbDBArrayList3!=null){
            phonesFbDBArrayList1.clear();
            if(myNewAdapter!=null){
                myNewAdapter.notifyDataSetChanged();
            }
        }
        if(phonesFbDBArrayList4!=null){
            phonesFbDBArrayList1.clear();
            if(myNewAdapter!=null){
                myNewAdapter.notifyDataSetChanged();
            }
        }
        if(phonesFbDBArrayList5!=null){
            phonesFbDBArrayList1.clear();
            if(myNewAdapter!=null){
                myNewAdapter.notifyDataSetChanged();
            }
        }
        if(phonesFbDBArrayList6!=null){
            phonesFbDBArrayList1.clear();
            if(myNewAdapter!=null){
                myNewAdapter.notifyDataSetChanged();
            }
        }
        if(phonesFbDBArrayList7!=null){
            phonesFbDBArrayList1.clear();
            if(myNewAdapter!=null){
                myNewAdapter.notifyDataSetChanged();
            }
        }
        if(phonesFbDBArrayList8!=null){
            phonesFbDBArrayList1.clear();
            if(myNewAdapter!=null){
                myNewAdapter.notifyDataSetChanged();
            }
        }
        if(phonesFbDBArrayList9!=null){
            phonesFbDBArrayList1.clear();
            if(myNewAdapter!=null){
                myNewAdapter.notifyDataSetChanged();
            }
        }*/

        /*phonesFbDBArrayList1=new ArrayList<>();
        /*phonesFbDBArrayList2=new ArrayList<>();
        phonesFbDBArrayList3=new ArrayList<>();
        phonesFbDBArrayList4=new ArrayList<>();
        phonesFbDBArrayList5=new ArrayList<>();
        phonesFbDBArrayList6=new ArrayList<>();
        phonesFbDBArrayList7=new ArrayList<>();
        phonesFbDBArrayList8=new ArrayList<>();
        phonesFbDBArrayList9=new ArrayList<>();*/

    /*}


    public void login() {
        Intent intentL = new Intent(this, LoginActivity.class);
        startActivity(intentL);
    }

    public void rate() {
        Intent intentRa = new Intent(this, RateActivity.class);
        startActivity(intentRa);
    }

    public void qa() {
        Intent intentQ = new Intent(this, QaActivity.class);
        startActivity(intentQ);
    }

    public void review() {
        Intent intentR = new Intent(this, ReviewActivity.class);
        startActivity(intentR);
    }*/
/*
    //setting filter list in recyler view
    private void setUpRecylerView() {
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        myNewAdapter=new MyNewAdapter(filterList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myNewAdapter);
    }
    //setting menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.new_menu,menu);

        MenuItem searchItem=menu.findItem(R.id.action_search);
        SearchView searchView= (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myNewAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }*/

}

