package com.vritti.mystackview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StackView stackView;
    private Button buttonPrevious;
    private Button buttonNext;

    private final String[] IMAGE_NAMES= {"soft_emo","mild_emo", "harsh_emo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.stackView = (StackView) findViewById(R.id.stackView);
        this.buttonNext =(Button) findViewById(R.id.button_next);
        this.buttonPrevious= (Button) findViewById(R.id.button_previous);

        List<StackItem> items = new ArrayList<StackItem>();

        for(String imageName: IMAGE_NAMES) {
            items.add(new StackItem(imageName+".png", imageName));
        }

        StackAdapter adapt = new StackAdapter(this, R.layout.stack_item, items);
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
