package com.example.a13635.myapplication.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a13635.myapplication.R;

/**
 * Created by lazyeraser on 2018/11/16.
 */

public class CustomTitleBar extends RelativeLayout
{
    private Button titleBarLeftBtn;
    private Button titleBarRightBtn;
    private TextView titleBarTitle;

    public CustomTitleBar(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.custom_title_bar, this, true);
        titleBarLeftBtn = (Button) findViewById(R.id.title_bar_left);
        titleBarRightBtn = (Button) findViewById(R.id.title_bar_right);
        titleBarTitle = (TextView) findViewById(R.id.title_bar_title);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomTitleBar);
        if (attributes != null){
            //设置titlebar背景颜色
            int titleBarBackGround = attributes.getResourceId(R.styleable.CustomTitleBar_title_background_color, Color.GREEN);
            setBackgroundResource(titleBarBackGround);

            //设置leftbutton是否可视
            boolean leftButtonVisible = attributes.getBoolean(R.styleable.CustomTitleBar_left_button_visible, true);
            if (leftButtonVisible){
                titleBarLeftBtn.setVisibility(View.VISIBLE);
            }else{
                titleBarLeftBtn.setVisibility(View.INVISIBLE);
            }
            //设置leftbutton的文字
            String leftButtonText = attributes.getString(R.styleable.CustomTitleBar_left_button_text);
            if(!TextUtils.isEmpty(leftButtonText)){
                titleBarLeftBtn.setText(leftButtonText);
                int leftButtonTextColor = attributes.getColor(R.styleable.CustomTitleBar_left_button_text_color, Color.WHITE);
                titleBarLeftBtn.setTextColor(leftButtonTextColor);
            }
            //设置leftbutton的图片
            int leftButtonDrawable = attributes.getResourceId(R.styleable.CustomTitleBar_left_button_drawable, -1);
            if (leftButtonDrawable != -1){
                titleBarLeftBtn.setCompoundDrawablesWithIntrinsicBounds(leftButtonDrawable, 0, 0, 0);
            }

            //设置标题是否显示图片
            int titleTextDrawbale = attributes.getResourceId(R.styleable.CustomTitleBar_title_text_drawable, -1);
            if (titleTextDrawbale != -1){//-1表示不显示图片
                titleBarTitle.setBackgroundResource(titleTextDrawbale);
            }else{
                String titleText = attributes.getString(R.styleable.CustomTitleBar_title_text);
                if (!TextUtils.isEmpty(titleText)){
                    titleBarTitle.setText(titleText);
                }
                //文字颜色
                int titleTextColor = attributes.getColor(R.styleable.CustomTitleBar_title_text_color, Color.WHITE);
                titleBarTitle.setTextColor(titleTextColor);
            }

            //设置rightbutton是否显示
            boolean rightButtonVisible = attributes.getBoolean(R.styleable.CustomTitleBar_right_button_visible, true);
            if (rightButtonVisible){
                titleBarRightBtn.setVisibility(View.VISIBLE);
            }else{
                titleBarRightBtn.setVisibility(View.INVISIBLE);
            }
            //设置rightbutton文字
            String rightButtonText = attributes.getString(R.styleable.CustomTitleBar_right_button_text);
            if (!TextUtils.isEmpty(rightButtonText)){
                titleBarRightBtn.setText(rightButtonText);
                int rightButtonTextColor = attributes.getColor(R.styleable.CustomTitleBar_right_button_text_color, Color.WHITE);
                titleBarRightBtn.setTextColor(rightButtonTextColor);
            }
            int rightButtonDrawable = attributes.getResourceId(R.styleable.CustomTitleBar_right_button_drawable, -1);
            if (rightButtonDrawable != -1){
                titleBarRightBtn.setCompoundDrawablesWithIntrinsicBounds(0, 0, rightButtonDrawable, 0);
            }
            attributes.recycle();
        }
    }

    public void setTitleClickListener(OnClickListener onClickListener){
        if (onClickListener != null){
            titleBarLeftBtn.setOnClickListener(onClickListener);
            titleBarRightBtn.setOnClickListener(onClickListener);
        }
    }

    public Button getTitleBarLeftBtn(){
        return titleBarLeftBtn;
    }

    public Button getTitleBarRightBtn(){
        return titleBarRightBtn;
    }

    public TextView getTitleBarTitle(){
        return titleBarTitle;
    }

}
