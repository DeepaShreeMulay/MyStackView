package com.vritti.mystackview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private StackView stackView;
    private Button buttonPrevious;
    private Button buttonNext;

    private final String[] TITLE= {"Bal_0_15","Bal_16_30", "Bal_31_60","Bal_61_90", "Bal_m_90", "Last"};
    private final int[] DRAWABLE= {R.drawable.edt_border_1,R.drawable.edt_border_2, R.drawable.edt_border_3,R.drawable.edt_border_4, R.drawable.edt_border_5,R.drawable.edt_border_1};
    private final String[] AMOUNT= {"\u20B9 30","\u20B9 60", "\u20B9 90","\u20B9 120", "\u20B9 150", "\u20B9 180"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.stackView = (StackView) findViewById(R.id.stackView);
        this.buttonNext =(Button) findViewById(R.id.button_next);
        this.buttonPrevious= (Button) findViewById(R.id.button_previous);

        List<StackItem2> items = new ArrayList<StackItem2>();

        for(int i = 0 ; i < TITLE.length; i++) {
            items.add(new StackItem2(AMOUNT[i], TITLE[i], DRAWABLE[i]));
        }

        StackAdapter2 adapt = new StackAdapter2(this, R.layout.stack_bal_item, items);
        stackView.setAdapter(adapt);
        stackView.setHorizontalScrollBarEnabled(true);
        stackView.setBackgroundColor(Color.rgb(230, 255, 255));

        buttonNext.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                stackView.showNext();
            }
        });

        buttonPrevious.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                stackView.showPrevious();
            }
        });
    }

}
