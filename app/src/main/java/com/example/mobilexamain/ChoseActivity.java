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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.chip.Chip;

public class ChoseActivity extends AppCompatActivity {

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
    MatchActivity matchActivity = new MatchActivity();
    private Switch aSwitch;
    public Boolean signCount = false,
            isChosen = false;
    private Integer clickcount = 0, timeClicks, firstChose = 0;
    private String chostring[] = new String[2];
    private Context context;
    private Button anyButton;
    public CompoundButton compoundButton;
    public ImageButton apple1, apple2, apple3, apple4, apple5, apple6,
            huawei1, huawei2, huawei3, huawei4, huawei5, huawei6, lg1, lg2, lg3, lg4, lg5, lg6,
            samsung1, samsung2, samsung3, samsung4, samsung5, samsung6,
            sony1, sony2, sony3, sony4, sony5, sony6, xiaomi1, xiaomi2, xiaomi3, xiaomi4, xiaomi5, xiaomi6;
    public ImageButton apple1cancel, apple2cancel, apple3cancel, apple4cancel, apple5cancel, apple6cancel,
            huawei1cancel, huawei2cancel, huawei3cancel, huawei4cancel, huawei5cancel, huawei6cancel,
            lg1cancel, lg2cancel, lg3cancel, lg4cancel, lg5cancel, lg6cancel,
            samsung1cancel, samsung2cancel, samsung3cancel, samsung4cancel, samsung5cancel, samsung6cancel,
            sony1cancel, sony2cancel, sony3cancel, sony4cancel, sony5cancel, sony6cancel,
            xiaomi1cancel, xiaomi2cancel, xiaomi3cancel, xiaomi4cancel, xiaomi5cancel, xiaomi6cancel;

    private TextView apple1battery, apple1camera, apple1cpu, apple1gpu, apple1link,
            apple2battery, apple2camera, apple2cpu, apple2gpu, apple2link,
            apple3battery, apple3camera, apple3cpu, apple3gpu, apple3link,
            apple4battery, apple4camera, apple4cpu, apple4gpu, apple4link,
            apple5battery, apple5camera, apple5cpu, apple5gpu, apple5link,
            apple6battery, apple6camera, apple6cpu, apple6gpu, apple6link,
            huawei1battery, huawei1camera, huawei1cpu, huawei1gpu, huawei1link,
            huawei2battery, huawei2camera, huawei2cpu, huawei2gpu, huawei2link,
            huawei3battery, huawei3camera, huawei3cpu, huawei3gpu, huawei3link,
            huawei4battery, huawei4camera, huawei4cpu, huawei4gpu, huawei4link,
            huawei5battery, huawei5camera, huawei5cpu, huawei5gpu, huawei5link,
            huawei6battery, huawei6camera, huawei6cpu, huawei6gpu, huawei6link,
            lg1battery, lg1camera, lg1cpu, lg1gpu, lg1link,
            lg2battery, lg2camera, lg2cpu, lg2gpu, lg2link,
            lg3battery, lg3camera, lg3cpu, lg3gpu, lg3link,
            lg4battery, lg4camera, lg4cpu, lg4gpu, lg4link,
            lg5battery, lg5camera, lg5cpu, lg5gpu, lg5link,
            lg6battery, lg6camera, lg6cpu, lg6gpu, lg6link,
            samsung1battery, samsung1camera, samsung1cpu, samsung1gpu, samsung1link,
            samsung2battery, samsung2camera, samsung2cpu, samsung2gpu, samsung2link,
            samsung3battery, samsung3camera, samsung3cpu, samsung3gpu, samsung3link,
            samsung4battery, samsung4camera, samsung4cpu, samsung4gpu, samsung4link,
            samsung5battery, samsung5camera, samsung5cpu, samsung5gpu, samsung5link,
            samsung6battery, samsung6camera, samsung6cpu, samsung6gpu, samsung6link,
            sony1battery, sony1camera, sony1cpu, sony1gpu, sony1link,
            sony2battery, sony2camera, sony2cpu, sony2gpu, sony2link,
            sony3battery, sony3camera, sony3cpu, sony3gpu, sony3link,
            sony4battery, sony4camera, sony4cpu, sony4gpu, sony4link,
            sony5battery, sony5camera, sony5cpu, sony5gpu, sony5link,
            sony6battery, sony6camera, sony6cpu, sony6gpu, sony6link,
            xiaomi1battery, xiaomi1camera, xiaomi1cpu, xiaomi1gpu, xiaomi1link,
            xiaomi2battery, xiaomi2camera, xiaomi2cpu, xiaomi2gpu, xiaomi2link,
            xiaomi3battery, xiaomi3camera, xiaomi3cpu, xiaomi3gpu, xiaomi3link,
            xiaomi4battery, xiaomi4camera, xiaomi4cpu, xiaomi4gpu, xiaomi4link,
            xiaomi5battery, xiaomi5camera, xiaomi5cpu, xiaomi5gpu, xiaomi5link,
            xiaomi6battery, xiaomi6camera, xiaomi6cpu, xiaomi6gpu, xiaomi6link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose);

        final ImageButton apple1 = (ImageButton) findViewById(R.id.apple1chose);
        final ImageButton apple1cancel = (ImageButton) findViewById(R.id.apple1cancel);
        final ImageButton apple2 = (ImageButton) findViewById(R.id.apple2chose);
        final ImageButton apple2cancel = (ImageButton) findViewById(R.id.apple2cancel);
        final ImageButton apple3 = (ImageButton) findViewById(R.id.apple3chose);
        final ImageButton apple3cancel = (ImageButton) findViewById(R.id.apple3cancel);
        final ImageButton apple4 = (ImageButton) findViewById(R.id.apple4chose);
        final ImageButton apple4cancel = (ImageButton) findViewById(R.id.apple4cancel);
        final ImageButton apple5 = (ImageButton) findViewById(R.id.apple5chose);
        final ImageButton apple5cancel = (ImageButton) findViewById(R.id.apple5cancel);
        final ImageButton apple6 = (ImageButton) findViewById(R.id.apple6chose);
        final ImageButton apple6cancel = (ImageButton) findViewById(R.id.apple6cancel);
        final ImageButton huawei1 = (ImageButton) findViewById(R.id.huawei1chose);
        final ImageButton huawei1cancel = (ImageButton) findViewById(R.id.huawei1cancel);
        final ImageButton huawei2 = (ImageButton) findViewById(R.id.huawei2chose);
        final ImageButton huawei2cancel = (ImageButton) findViewById(R.id.huawei2cancel);
        final ImageButton huawei3 = (ImageButton) findViewById(R.id.huawei3chose);
        final ImageButton huawei3cancel = (ImageButton) findViewById(R.id.huawei3cancel);
        final ImageButton huawei4 = (ImageButton) findViewById(R.id.huawei4chose);
        final ImageButton huawei4cancel = (ImageButton) findViewById(R.id.huawei4cancel);
        final ImageButton huawei5 = (ImageButton) findViewById(R.id.huawei5chose);
        final ImageButton huawei5cancel = (ImageButton) findViewById(R.id.huawei5cancel);
        final ImageButton huawei6 = (ImageButton) findViewById(R.id.huawei6chose);
        final ImageButton huawei6cancel = (ImageButton) findViewById(R.id.huawei6cancel);
        final ImageButton lg1 = (ImageButton) findViewById(R.id.lg1chose);
        final ImageButton lg1cancel = (ImageButton) findViewById(R.id.lg1cancel);
        final ImageButton lg2 = (ImageButton) findViewById(R.id.lg2chose);
        final ImageButton lg2cancel = (ImageButton) findViewById(R.id.lg2cancel);
        final ImageButton lg3 = (ImageButton) findViewById(R.id.lg3chose);
        final ImageButton lg3cancel = (ImageButton) findViewById(R.id.lg3cancel);
        final ImageButton lg4 = (ImageButton) findViewById(R.id.lg4chose);
        final ImageButton lg4cancel = (ImageButton) findViewById(R.id.lg4cancel);
        final ImageButton lg5 = (ImageButton) findViewById(R.id.lg5chose);
        final ImageButton lg5cancel = (ImageButton) findViewById(R.id.lg5cancel);
        final ImageButton lg6 = (ImageButton) findViewById(R.id.lg6chose);
        final ImageButton lg6cancel = (ImageButton) findViewById(R.id.lg6cancel);
        final ImageButton samsung1 = (ImageButton) findViewById(R.id.samsung1chose);
        final ImageButton samsung1cancel = (ImageButton) findViewById(R.id.samsung1cancel);
        final ImageButton samsung2 = (ImageButton) findViewById(R.id.samsung2chose);
        final ImageButton samsung2cancel = (ImageButton) findViewById(R.id.samsung2cancel);
        final ImageButton samsung3 = (ImageButton) findViewById(R.id.samsung3chose);
        final ImageButton samsung3cancel = (ImageButton) findViewById(R.id.samsung3cancel);
        final ImageButton samsung4 = (ImageButton) findViewById(R.id.samsung4chose);
        final ImageButton samsung4cancel = (ImageButton) findViewById(R.id.samsung4cancel);
        final ImageButton samsung5 = (ImageButton) findViewById(R.id.samsung5chose);
        final ImageButton samsung5cancel = (ImageButton) findViewById(R.id.samsung5cancel);
        final ImageButton samsung6 = (ImageButton) findViewById(R.id.samsung6chose);
        final ImageButton samsung6cancel = (ImageButton) findViewById(R.id.samsung6cancel);
        final ImageButton sony1 = (ImageButton) findViewById(R.id.sony1chose);
        final ImageButton sony1cancel = (ImageButton) findViewById(R.id.sony1cancel);
        final ImageButton sony2 = (ImageButton) findViewById(R.id.sony2chose);
        final ImageButton sony2cancel = (ImageButton) findViewById(R.id.sony2cancel);
        final ImageButton sony3 = (ImageButton) findViewById(R.id.sony3chose);
        final ImageButton sony3cancel = (ImageButton) findViewById(R.id.sony3cancel);
        final ImageButton sony4 = (ImageButton) findViewById(R.id.sony4chose);
        final ImageButton sony4cancel = (ImageButton) findViewById(R.id.sony4cancel);
        final ImageButton sony5 = (ImageButton) findViewById(R.id.sony5chose);
        final ImageButton sony5cancel = (ImageButton) findViewById(R.id.sony5cancel);
        final ImageButton sony6 = (ImageButton) findViewById(R.id.sony6chose);
        final ImageButton sony6cancel = (ImageButton) findViewById(R.id.sony6cancel);
        final ImageButton xiaomi1 = (ImageButton) findViewById(R.id.xiaomi1chose);
        final ImageButton xiaomi1cancel = (ImageButton) findViewById(R.id.xiaomi1cancel);
        final ImageButton xiaomi2 = (ImageButton) findViewById(R.id.xiaomi2chose);
        final ImageButton xiaomi2cancel = (ImageButton) findViewById(R.id.xiaomi2cancel);
        final ImageButton xiaomi3 = (ImageButton) findViewById(R.id.xiaomi3chose);
        final ImageButton xiaomi3cancel = (ImageButton) findViewById(R.id.xiaomi3cancel);
        final ImageButton xiaomi4 = (ImageButton) findViewById(R.id.xiaomi4chose);
        final ImageButton xiaomi4cancel = (ImageButton) findViewById(R.id.xiaomi4cancel);
        final ImageButton xiaomi5 = (ImageButton) findViewById(R.id.xiaomi5chose);
        final ImageButton xiaomi5cancel = (ImageButton) findViewById(R.id.xiaomi5cancel);
        final ImageButton xiaomi6 = (ImageButton) findViewById(R.id.xiaomi6chose);
        final ImageButton xiaomi6cancel = (ImageButton) findViewById(R.id.xiaomi6cancel);


        apple1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                apple1.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    apple1.setEnabled(true);
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();

                }
                if (clickcount == 2) {
                    apple1.setEnabled(true);
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });
        apple1cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    apple1cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();

                }
            }
        });


        apple2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                apple2.setEnabled(false);
                clickcount++;


                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                    apple1.setEnabled(true);
                }
                if (clickcount == 2) {
                    apple1.setEnabled(true);
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        apple2cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    apple2cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();

                }
            }
        });


        apple3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                apple3.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    chostring[1] = strModel[2];
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        apple3cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    apple3cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();

                }
            }
        });

        apple4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                apple4.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    chostring[1] = strModel[3];
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        apple4cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    apple4cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();

                }
            }
        });

        apple5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                apple5.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    chostring[1] = strModel[4];
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        apple5cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    apple5cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();

                }
            }
        });

        apple6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                apple6.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    chostring[1] = strModel[5];
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        apple6cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    apple6cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();

                }
            }
        });

        huawei1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                huawei1.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });
        huawei1cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    huawei1cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }

        });


        huawei2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                huawei2.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        huawei2cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    huawei2cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }

        });

        huawei3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                huawei3.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        huawei3cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    huawei3cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }

        });
        huawei4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                huawei4.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        huawei4cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    huawei4cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }

        });

        huawei5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                huawei5.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        huawei5cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    huawei5cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }

        });

        huawei6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                huawei6.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        huawei6cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    huawei6cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }

        });
        lg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                lg1.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });
        lg1cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    lg1cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }

            }
        });


        lg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                lg2.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        lg2cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    lg2cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });

        lg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                lg3.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        lg3cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    lg3cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }

            }
        });

        lg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                lg4.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        lg4cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    lg4cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }

            }
        });
        lg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                lg5.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        lg5cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    lg5cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }

            }
        });

        lg6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                lg6.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        lg6cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    lg6cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }

            }
        });

        samsung1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                samsung1.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });
        samsung1cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    samsung1cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });


        samsung2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                samsung2.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        samsung2cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    samsung2cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });


        samsung3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                samsung3.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        samsung3cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    samsung3cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });


        samsung4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                samsung4.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        samsung4cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    samsung4cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });


        samsung5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                samsung5.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        samsung5cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    samsung5cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });


        samsung6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                samsung6.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        samsung6cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    samsung6cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });


        sony1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                sony1.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });
        sony1cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    sony1cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });

        sony2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                sony2.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        sony2cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    sony2cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });

        sony3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                sony3.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        sony3cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    sony3cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });

        sony4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                sony4.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        sony4cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    sony4cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });

        sony5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                sony5.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        sony5cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    sony5cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });

        sony6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                sony6.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        sony6cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    sony6cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });

        xiaomi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                xiaomi1.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });
        xiaomi1cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    xiaomi1cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });


        xiaomi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                xiaomi2.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        xiaomi2cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    xiaomi2cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });

        xiaomi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                xiaomi3.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        xiaomi3cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    xiaomi3cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });

        xiaomi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                xiaomi4.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        xiaomi4cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    xiaomi4cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });

        xiaomi5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                xiaomi5.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        xiaomi5cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    xiaomi5cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });

        xiaomi6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChosen = !isChosen;
                xiaomi6.setEnabled(false);
                clickcount++;

                if (clickcount == 1) {
                    firstChose++;
                    Toast.makeText(ChoseActivity.this, "you clicked a phone, now you add another phone or cancel the current phone", Toast.LENGTH_LONG).show();
                }
                if (clickcount == 2) {
                    onChosen(view);
                    Intent intentSelect = new Intent(ChoseActivity.this, MatchActivity.class);
                    startActivity(intentSelect);
                }
            }
        });

        xiaomi6cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickcount > 0) {
                    isChosen = !isChosen;
                    xiaomi6cancel.setEnabled(false);
                    clickcount--;
                    firstChose--;
                    Toast.makeText(ChoseActivity.this, "the phone cancel was done", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ChoseActivity.this, "You may not remove phone if did not add it before", Toast.LENGTH_LONG).show();
                }
            }
        });


        Toast.makeText(this, "Please select 2 phone by clicking the image phone to selected ", Toast.LENGTH_LONG).show();
        clickcount = 0;


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

        //recyclerView1 = findViewById(R.id.recyclerView);

        //MyAdapter myAdapter = new MyAdapter(this, strModel, strRelease, strLink, strCamera, strMemory, strScreen, strPrice, strCpu, strGpu, strBattery, photo);
        //recyclerView1.setAdapter(myAdapter);
        //recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        Button login = (Button) findViewById(R.id.loginC);

        Button qa = (Button) findViewById(R.id.qaC);

        Button review = (Button) findViewById(R.id.reviewC);

        Button search = (Button) findViewById(R.id.searchC);

        Button rate = (Button) findViewById(R.id.rateC);


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
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rate();
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

    public void rate() {
        Intent intentRa = new Intent(this, RateActivity.class);
        startActivity(intentRa);
    }


    public void onChosen(View view) {
        if (signCount) {
            if (firstChose == 1) {
                matchActivity.imagePhone1 = apple1;
            }
            if (clickcount == 2) {
                matchActivity.imagePhone2 = apple1;
            }
        }
        if (signCount) {
            if (firstChose == 1) {
                matchActivity.imagePhone1 = apple2;
            }
            if (clickcount == 2) {
                matchActivity.imagePhone2 = apple2;
            }
        }
        if (signCount) {
            if (firstChose == 1) {

            }
            if (clickcount == 2) {

            }
            if (signCount) {
                if (firstChose == 1) {

                }
                if (clickcount == 2) {

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }
                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) { //huawei

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) { //lg

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) { //samsung

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {//sony

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {//xiaomi

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }
                if (signCount) {

                    if (firstChose == 1) {

                    }
                    if (clickcount == 2) {

                    }

                }


            }
        }

    }
}

