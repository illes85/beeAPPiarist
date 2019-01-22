package com.example.illes.beeappiaristtry2;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private ToggleButton iconQueen, iconFood, iconWorm, iconHoney, iconWarning;
    private ImageButton btHive1;
    private Button btPrev, btMore, btPrev2, btMore2, btBack, btBack2;
    private GridLayout gridLayoutHiveInside, gridLayoutHiveInside2ndPage;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        final MediaPlayer soundIcons = MediaPlayer.create(this, R.raw.tiny_button_push);
        final MediaPlayer soundPopup = MediaPlayer.create(this, R.raw.zapsplat_cartoon_squeeze_pop_squelchy_20001);



        btHive1 = findViewById(R.id.btHive1);

        btPrev = findViewById(R.id.button_prev);
        btMore = findViewById(R.id.button_more);
        btPrev2 = findViewById(R.id.button_prev2);
        btMore2 = findViewById(R.id.button_more2);
        btBack = findViewById(R.id.button_back);
        btBack2 = findViewById(R.id.button_back2);

        gridLayoutHiveInside = findViewById(R.id.grid_layout_hive_inside);
        gridLayoutHiveInside2ndPage = findViewById(R.id.grid_layout_hive_inside_2nd_page);

        iconQueen = findViewById(R.id.iconQueen);
        iconFood = findViewById(R.id.iconFood);
        iconWorm = findViewById(R.id.iconWorm);
        iconHoney = findViewById(R.id.iconHoney);
        iconWarning = findViewById(R.id.iconWarning);




        Spinner spinnerHives = findViewById(R.id.spinner_hives);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Hives, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHives.setAdapter(adapter);
        spinnerHives.setOnItemSelectedListener(this);


        Hive hive1 = new Hive();
        hive1.setName("1");


        btHive1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gridLayoutHiveInside.getVisibility() != View.VISIBLE)
                {
                    soundPopup.start();
                    // i hide the on-off icons next to the hive
                    iconQueen.setVisibility(View.GONE);
                    iconWorm.setVisibility(View.GONE);
                    iconFood.setVisibility(View.GONE);
                    iconHoney.setVisibility(View.GONE);
                    gridLayoutHiveInside.setVisibility(View.VISIBLE);
                    btMore.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gridLayoutHiveInside.setVisibility(View.GONE);
                            gridLayoutHiveInside2ndPage.setVisibility(View.VISIBLE);
                            btPrev2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    gridLayoutHiveInside2ndPage.setVisibility(View.GONE);
                                    gridLayoutHiveInside.setVisibility(View.VISIBLE);
                                }
                            });
                        }
                    });
                } else
                {
                    gridLayoutHiveInside.setVisibility(View.GONE);
                    gridLayoutHiveInside2ndPage.setVisibility(View.GONE);
                    iconQueen.setVisibility(View.VISIBLE);
                    iconWorm.setVisibility(View.VISIBLE);
                    iconFood.setVisibility(View.VISIBLE);
                    iconHoney.setVisibility(View.VISIBLE);
                }
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridLayoutHiveInside.setVisibility(View.INVISIBLE);
                gridLayoutHiveInside2ndPage.setVisibility(View.INVISIBLE);
                iconQueen.setVisibility(View.VISIBLE);
                iconWorm.setVisibility(View.VISIBLE);
                iconFood.setVisibility(View.VISIBLE);
                iconHoney.setVisibility(View.VISIBLE);
            }
        });
        btBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridLayoutHiveInside.setVisibility(View.INVISIBLE);
                gridLayoutHiveInside2ndPage.setVisibility(View.INVISIBLE);
                iconQueen.setVisibility(View.VISIBLE);
                iconWorm.setVisibility(View.VISIBLE);
                iconFood.setVisibility(View.VISIBLE);
                iconHoney.setVisibility(View.VISIBLE);
            }
        });

        /*
        btHive1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PopupMenu pm = new PopupMenu(MainActivity.this, btHive1);
                pm.getMenuInflater().inflate(R.menu.menu_hive, pm.getMenu());
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        Toast.makeText(MainActivity.this, item.getTitle() + " clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                pm.show();
            }
        });
        */


        // There comes the icons-section
        iconQueen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iconQueen.isChecked())
                {
                    //vibrator.vibrate(20);
                    soundIcons.start();
                    Toast.makeText(MainActivity.this, "Queen icon is ON", Toast.LENGTH_SHORT).show();
                }
            }
        });
        iconFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iconFood.isChecked())
                {
                    //vibrator.vibrate(20);
                    soundIcons.start();
                    Toast.makeText(MainActivity.this, "Food icon is ON", Toast.LENGTH_SHORT).show();
                }
            }
        });
        iconWorm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iconWorm.isChecked())
                {
                    //vibrator.vibrate(20);
                    soundIcons.start();
                    Toast.makeText(MainActivity.this, "Worm icon is ON", Toast.LENGTH_SHORT).show();
                }
            }
        });
        iconHoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iconHoney.isChecked())
                {
                    //vibrator.vibrate(20);
                    soundIcons.start();
                    Toast.makeText(MainActivity.this, "Honey icon is ON", Toast.LENGTH_SHORT).show();
                }
            }
        });
        iconWarning.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (iconWarning.isChecked())
            {
                //vibrator.vibrate(20);
                soundIcons.start();
                Toast.makeText(MainActivity.this, "Warning icon is ON", Toast.LENGTH_SHORT).show();
            }
        }
    });

        /*
        spinnerLang.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PopupMenu pm = new PopupMenu(MainActivity.this, spinnerLang);
                pm.getMenuInflater().inflate(R.menu.menu_language, pm.getMenu());
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        Toast.makeText(MainActivity.this, item.getTitle() + " clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                pm.show();
            }
        });*/
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String selectedHive = parent.getItemAtPosition(position).toString();
        TextView tvHiveNumber = (TextView) findViewById(R.id.tv_hive_number);
        tvHiveNumber.setText(selectedHive);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }

    private void showAlertMessage(final String message)
    {
        AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
        alertbox.setMessage(message);
        alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Ok kiválasztva
            }
        });
        alertbox.show();
    }

    public void newHive(View view)
    {
        System.out.println("NEW HIVE - BUTTON clicked.");
    }
}
