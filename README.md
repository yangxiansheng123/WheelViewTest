# WheelViewTest
时间滚动选择

1.初始化数据：

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
    
    
    2.调用显示时间：
    
    
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


    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }
    
    
    
    
    3.Type.YEAR_MONTH_DAY有五种选择类型，分别为：年月日时分，年月日，时分，月日时分，年月
    
    ALL,
    YEAR_MONTH_DAY,
    HOURS_MINS,
    MONTH_DAY_HOUR_MIN,
    YEAR_MONTH,
    YEAR
