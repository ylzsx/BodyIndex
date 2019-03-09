package cn.fhypayaso.bodyIndex.business.details.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.fhypayaso.bodyIndex.R;
import cn.fhypayaso.bodyIndex.base.annotation.ContentView;
import cn.fhypayaso.bodyIndex.base.annotation.RegisterPresenter;
import cn.fhypayaso.bodyIndex.base.mvp.view.BasePresenterActivity;
import cn.fhypayaso.bodyIndex.business.details.contract.TemperatureDetailContarct;
import cn.fhypayaso.bodyIndex.business.details.model.response.WarningResponseModel;
import cn.fhypayaso.bodyIndex.business.details.presenter.TemperatureDetailPresenter;
import cn.fhypayaso.bodyIndex.business.details.view.adapter.HeartWarningAdapter;

@ContentView(R.layout.activity_temperature_detail)
@RegisterPresenter(TemperatureDetailPresenter.class)
public class TemperatureDetailActivity extends BasePresenterActivity<TemperatureDetailContarct.Presenter> implements TemperatureDetailContarct.View {


    @BindView(R.id.img_back)
    ImageView mImgBack;
    @BindView(R.id.img_left)
    ImageView mImgLeft;
    @BindView(R.id.img_right)
    ImageView mImgRight;
    @BindView(R.id.linechart)
    LineChart mLinechart;
    @BindView(R.id.rcView_heart)
    RecyclerView mRcViewHeart;

    private List<WarningResponseModel> mTemperatureWarningList = new ArrayList<>();
    private HeartWarningAdapter adapter;
    // dataSets的个数便是曲线的条数
    ArrayList<ILineDataSet> dataSets = new ArrayList<>();

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {

        // 初始化RecyclerView
        mPresenter.initTemperatureWarningList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRcViewHeart.setLayoutManager(linearLayoutManager);

        adapter = new HeartWarningAdapter(mTemperatureWarningList);
        mRcViewHeart.setAdapter(adapter);

        // 初始化 LineChart
        initLineChart();
        //创建LineData对象 属于LineChart折线图的数据集合
        LineData data = new LineData(dataSets);
        // 添加到图表中
        mLinechart.setData(data);
        //绘制图表
        mLinechart.invalidate();
    }

    @OnClick({R.id.img_back})
    public void clickView(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            default:
                break;
        }
    }

    /**
     * 初始化直线图样式
     */
    private void initLineChart() {
        mLinechart.setNoDataText("没有数据");   //没有数据时显示的文字
        mLinechart.setNoDataTextColor(Color.WHITE); //没有数据时显示文字的颜色
        mLinechart.animateX(1000);  //绘制动画 从左到右
        mLinechart.setDoubleTapToZoomEnabled(false); //设置是否可以通过双击屏幕放大图表。默认是true
//        mLinechart.setDrawGridBackground(false);//chart 绘图区后面的背景矩形将绘制
//        mLinechart.setDrawBorders(false);//是否禁止绘制图表边框的线


        XAxis xAxis = mLinechart.getXAxis();       //获取x轴线
        xAxis.setEnabled(true);     // 设置显示x轴
        xAxis.setDrawGridLines(false);  // 设置隐藏其他横轴
        xAxis.setDrawLabels(true); //绘制标签  指x轴上的对应数值
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); //设置x轴的显示位置

        YAxis leftAxis = mLinechart.getAxisLeft();
        YAxis rightAxis = mLinechart.getAxisRight();
        rightAxis.setEnabled(false);   //设置是否使用 Y轴右边部分
        leftAxis.setEnabled(true);     //设置是否使用 Y轴左边部分

        mPresenter.initChartData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    /**
     * 初始化体温警告列表成功与失败回调
     */
    @Override
    public void initTemperatureWarningListSuccess(List<WarningResponseModel> temperatureWarningList) {
        mTemperatureWarningList = temperatureWarningList;
    }

    @Override
    public void initTemperatureWarningListFailed() {

    }

    /**
     * 初始化表格数据成功与失败回调
     */
    @Override
    public void initChartDataSuccess(final List<Entry> values) {
        XAxis xAxis = mLinechart.getXAxis();
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return values.get((int)value).getData().toString();
            }
        });

        LineDataSet set;    // 折线点集合，内部包含了线上点的值及其样式
        if (mLinechart.getData() != null && mLinechart.getData().getDataSetCount() > 0) {
            //获取数据
            set = (LineDataSet) mLinechart.getData().getDataSetByIndex(0);
            set.setValues(values);
            //刷新数据
            mLinechart.getData().notifyDataChanged();
            mLinechart.notifyDataSetChanged();
        } else {
            set = new LineDataSet(values, "体温曲线");
            set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            set.setColor(Color.parseColor("#88A80D"));
            set.setCircleColor(Color.parseColor("#88A80D"));
            set.setHighLightColor(Color.WHITE);//设置点击交点后显示高亮线的颜色
//            set.setHighlightEnabled(true);//是否使用点击高亮线
            set.setDrawCircles(true);
            set.setValueTextColor(Color.parseColor("#88A80D"));
            set.setLineWidth(2f);//设置线宽
            set.setCircleRadius(3f);//设置焦点圆心的大小
            set.setHighlightLineWidth(1f);//设置点击交点后显示高亮线宽
            set.enableDashedHighlightLine(10f, 5f, 0f);//点击后的高亮线的显示样式
            set.setValueTextSize(12f);//设置显示值的文字大小

            dataSets.add(set);

        }
    }

    @Override
    public void initChartDataFailed() {

    }
}
