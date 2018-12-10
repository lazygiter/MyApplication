package com.example.a13635.myapplication.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.a13635.myapplication.R;

/**
 * Created by lazyeraser on 2018/11/17.
 */

public class TagsLayout extends ViewGroup
{
    private int childHorizontalSpace;
    private int childVerticalSpace;

    public TagsLayout(Context context, AttributeSet attrs){
        super(context, attrs);
        TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.TagsLayout);
        if (attrArray != null){
            childHorizontalSpace = attrArray.getDimensionPixelSize(R.styleable.TagsLayout_tagHorizontalSpace, 0);
            childVerticalSpace = attrArray.getDimensionPixelSize(R.styleable.TagsLayout_tagVerticalSpace, 0);
            attrArray.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        int width = 0;
        int height = 0;

        int lineWidth = 0;

        int lineHeight = 0;

        int count = getChildCount();
        int left = getPaddingLeft();
        int top = getPaddingTop();

        for(int i = 0; i < count; i++){
            View child = getChildAt(i);
            if(child.getVisibility() == GONE){
                continue;
            }
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin + childHorizontalSpace;
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin + childVerticalSpace;

            if (lineWidth + childWidth > sizeWidth - getPaddingLeft() - getPaddingRight()){
                width = Math.max(lineWidth, childWidth);
                lineWidth = childWidth;
                height += lineHeight;
                lineHeight = childHeight;
                child.setTag(new Location(left, top + height, childWidth + left - childHorizontalSpace, height + child.getMeasuredHeight() + top));
            }else{
                child.setTag(new Location(lineWidth + left, top + height, lineWidth + childWidth - childHorizontalSpace + left, height + child.getMeasuredHeight() + top));
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }
        }
        width = Math.max(width, lineWidth) + getPaddingLeft() + getPaddingRight();
        height += lineHeight;
        sizeHeight += getPaddingTop() + getPaddingBottom();
        height += getPaddingTop() + getPaddingBottom();
        setMeasuredDimension((modeWidth == MeasureSpec.EXACTLY) ? sizeWidth : width, (modeHeight == MeasureSpec.EXACTLY) ? sizeHeight : height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {
        int count = getChildCount();
        for (int i = 0; i < count; i++){
            View child = getChildAt(i);
            if(child.getVisibility() == GONE){
                continue;
            }
            Location location = (Location) child.getTag();
            child.layout(location.left, location.top, location.right, location.bottom);
        }
    }

    public class Location{
        public int left;
        public int top;
        public int right;
        public int bottom;

        public Location(int left, int top, int right, int bottom){
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }
    }
}
