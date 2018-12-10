package com.example.a13635.myapplication.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a13635.myapplication.R;

/**
 * Created by lazyeraser on 2018/11/16.
 */

public class ReviewActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        CustomTitleBar titleBar = (CustomTitleBar) findViewById(R.id.title_bar1);
        Button button1 = titleBar.getTitleBarLeftBtn();
        button1.setText("点击");
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(ReviewActivity.this, "you clicked me", Toast.LENGTH_SHORT).show();
            }
        });

        TagsLayout imageViewGroup = (TagsLayout) findViewById(R.id.image_layout);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        String[] strings = {"呵呵呵呵呵呵呵呵",
                "哈哈哈",
                "good",
                "dfsdfasdfsadf",
                "的发生飞洒范德萨发生"
        };
        for(int i = 0; i < 5; i++){
            TextView textView = new TextView(this);
            textView.setText(strings[i]);
            textView.setTextColor(Color.WHITE);
            textView.setBackgroundColor(Color.BLUE);
            imageViewGroup.addView(textView, lp);
        }

    }
}
