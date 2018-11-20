package com.behavior;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BottomSheetDialogActivity extends AppCompatActivity {

    @BindView(R.id.toolBar)
    Toolbar toolBar;

    private BottomSheetDialog mBottomSheetDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomsheet_behavior);

        ButterKnife.bind(this);
        setSupportActionBar(toolBar);

        init();

    }



    private void init() {
        mBottomSheetDialog=new BottomSheetDialog(this);
        View view= LayoutInflater.from(this).inflate(R.layout.view_bottomsheet_dialog,null,false);
        mBottomSheetDialog.setContentView(view);
        setRecycleView(view);
    }

    private void setRecycleView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView= LayoutInflater.from(BottomSheetDialogActivity.this).inflate(R.layout.adapter_bottomsheetdialog_item,parent,false);
                ViewHolder viewHolder=new ViewHolder(itemView);
                return viewHolder;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 100;
            }
        });
    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @OnClick({R.id.btnSheetControl})
    public void doClick(View view){
        switch (view.getId()) {
            case R.id.btnSheetControl:
                if(mBottomSheetDialog.isShowing()){
                    mBottomSheetDialog.dismiss();
                    setBehaviorCallBack();
                }else {
                    mBottomSheetDialog.show();
                }
                break;
        }
    }

    private void setBehaviorCallBack() {
        View view =mBottomSheetDialog.getDelegate().findViewById(android.support.design.R.id.design_bottom_sheet);
        final BottomSheetBehavior bottomSheetBehavior=BottomSheetBehavior.from(view);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState==BottomSheetBehavior.STATE_HIDDEN){
                    mBottomSheetDialog.dismiss();
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }


}
