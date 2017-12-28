package com.example.swart.selectcarheader;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import win.swt6.selectcarlib.OnItemClickListener;
import win.swt6.selectcarlib.OnShrinkButtonClickListener;
import win.swt6.selectcarlib.ScreenUtil;
import win.swt6.selectcarlib.SelectCharHeaderView;

public class MainActivity extends Activity {
    TextView mTextView;
    RelativeLayout mLayout;
    private PopupWindow mPopWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView= (TextView) findViewById(R.id.tv_car_num_header);
        mLayout= (RelativeLayout) findViewById(R.id.rlayout);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectCarPopWindow();
            }
        });
    }
    void showSelectCarPopWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(this).inflate(R.layout.popwindow_select_car, null);
        mPopWindow = new PopupWindow(contentView,
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setWidth(ScreenUtil.getScreenWidth(this));
        mPopWindow.setContentView(contentView);
        mPopWindow.setBackgroundDrawable(
                new ColorDrawable(getResources().getColor(R.color.selectcarlib_transparent)));
        // 使其聚焦
        mPopWindow.setFocusable(true);
        // 设置允许在外点击消失
        mPopWindow.setOutsideTouchable(true);

        //设置各个控件的点击响应
        SelectCharHeaderView selectCharHeaderView = contentView.findViewById(R.id.schv);
        selectCharHeaderView.setItemClickListener(new OnItemClickListener() {
            @Override
            public void selectString(String select) {
                mTextView.setText(select);
                mPopWindow.dismiss();
            }
        });
        selectCharHeaderView.setShrinkButtonClickListener(new OnShrinkButtonClickListener() {
            @Override
            public void click() {
                mPopWindow.dismiss();
            }
        });
        //显示PopupWindow
        mPopWindow.showAtLocation(mLayout, Gravity.BOTTOM, 0, 0);
    }
}
