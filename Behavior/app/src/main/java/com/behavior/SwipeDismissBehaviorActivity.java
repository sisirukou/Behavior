package com.behavior;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SwipeDismissBehaviorActivity extends AppCompatActivity {

//    @BindView(R.id.toolBar)
//    Toolbar toolBar;
    @BindView(R.id.llSheetControl)
    LinearLayout llSheetControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipedismiss_behavior);

        ButterKnife.bind(this);

//        setSupportActionBar(toolBar);

        init();

    }

    private void init() {
        SwipeDismissBehavior swip=new SwipeDismissBehavior();
        /**
         * //设置滑动的方向，有3个值
         * SWIPE_DIRECTION_ANY 表示向左像右滑动都可以，
         * SWIPE_DIRECTION_START_TO_END，只能从左向右滑
         * SWIPE_DIRECTION_END_TO_START，只能从右向左滑
         */
        swip.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_START_TO_END);
        swip.setStartAlphaSwipeDistance(0f);
        swip.setSensitivity(0.2f);
        swip.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override
            public void onDismiss(View view) {
            }

            @Override
            public void onDragStateChanged(int state) {
            }
        });

        CoordinatorLayout.LayoutParams layoutParams= (CoordinatorLayout.LayoutParams)
                llSheetControl.getLayoutParams();

        if(layoutParams!=null){
            layoutParams.setBehavior(swip);
        }
    }

    @OnClick({R.id.llSheetControl})
    public void doClick(View view){
        switch (view.getId()) {
            case R.id.llSheetControl:

                break;
        }
    }
}
