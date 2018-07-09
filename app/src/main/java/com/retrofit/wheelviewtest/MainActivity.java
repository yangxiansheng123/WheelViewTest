package com.retrofit.wheelviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.wangchenlong.datescroller.widget.DateScrollerDialog;
import org.wangchenlong.datescroller.widget.data.Type;
import org.wangchenlong.datescroller.widget.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final long HUNDRED_YEARS = 100L * 365 * 1000 * 60 * 60 * 24L;
    protected TextView btnYearMonthDay;
    protected TextView tvTime;
    protected RelativeLayout activityMain;

    private TextView mTvTime;
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    /**
     * 上次设置的时间
     */
    private long mLastTime = System.currentTimeMillis();

    /**
     * 数据的回调
     */
    private OnDateSetListener mOnDateSetListener = new OnDateSetListener() {
        @Override
        public void onDateSet(DateScrollerDialog timePickerView, long milliseconds) {
            mLastTime = milliseconds;
            String text = getDateToString(milliseconds);
            mTvTime.setText(text);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnYearMonthDay = (TextView) findViewById(R.id.btn_year_month_day);
        tvTime = (TextView) findViewById(R.id.tv_time);
        activityMain = (RelativeLayout) findViewById(R.id.activity_main);
        showDate(tvTime);
    }


    /**
     * 显示日期
     *
     * @param view 视图
     */
    public void showDate(View view) {
        // 出生日期
        DateScrollerDialog dialog = new DateScrollerDialog.Builder()
                .setType(Type.YEAR_MONTH_DAY)
                .setTitleStringId("请选择出生日期")
                .setMinMilliseconds(System.currentTimeMillis() - HUNDRED_YEARS)
                .setMaxMilliseconds(System.currentTimeMillis())
                .setCurMilliseconds(mLastTime)
                .setCallback(mOnDateSetListener)
                .build();

        if (dialog != null) {
            if (!dialog.isAdded()) {
                dialog.show(getSupportFragmentManager(), "year_month_day");
            }
        }
    }


    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }
}
