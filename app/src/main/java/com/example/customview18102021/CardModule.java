package com.example.customview18102021;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CardModule extends LinearLayout {

    ImageView mIcon;
    TextView mTvTitle, mTvDescription;

    int mColorBackgroundData, mIconModuleData;
    String mTextTitleData, mTextDescriptionData;

    private OnClickListener onClickListener;

    public CardModule(Context context) {
        super(context);
        initView(context, null);
    }

    public CardModule(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public CardModule(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initView(Context context, AttributeSet attributeSet) {
        if (attributeSet != null && context != null) {
            // Chuyển layout sang kiểu view
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.custom_layout_module, this, true);
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CardModule);
            mColorBackgroundData = typedArray.getColor(R.styleable.CardModule_backgroundIcon, Color.WHITE);
            mIconModuleData = typedArray.getResourceId(R.styleable.CardModule_iconModule, R.drawable.ic_address);
            mTextTitleData = typedArray.getString(R.styleable.CardModule_titleModule);
            mTextDescriptionData = typedArray.getString(R.styleable.CardModule_descriptionModule);
            typedArray.recycle();
            mapView(view);
            event(view);
        }
    }

    private void event(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null){
                    onClickListener.onClick();
                }
            }
        });
    }

    private void mapView(View view) {
        mIcon = view.findViewById(R.id.imageViewIconModule);
        mTvDescription = view.findViewById(R.id.textViewDescriptionModule);
        mTvTitle = view.findViewById(R.id.textViewTitleModule);

        GradientDrawable shapeDrawable = (GradientDrawable) mIcon.getBackground();
        shapeDrawable.mutate();
        shapeDrawable.setColor(mColorBackgroundData);

        mIcon.setImageResource(mIconModuleData);
        mTvTitle.setText(mTextTitleData);
        mTvDescription.setText(mTextDescriptionData);
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        public void onClick();
    }
}
