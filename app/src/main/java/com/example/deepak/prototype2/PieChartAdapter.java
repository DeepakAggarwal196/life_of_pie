package com.example.deepak.prototype2;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.numetriclabz.numandroidcharts.ChartData;
import com.numetriclabz.numandroidcharts.GaugeChart;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PieChartAdapter {


    public void drawChartLocation(View view, String steps, String calories)
    {
        PieChart pieChart = (PieChart) view.findViewById(R.id.piechart_location);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10,5, 5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues =new ArrayList<>();

        yValues.add(new PieEntry(3f, "Home"));
        yValues.add(new PieEntry(8.2f, "Office"));
        yValues.add(new PieEntry(8.65f, "Sleep"));
        yValues.add(new PieEntry(1.48f, "Gym"));
        yValues.add(new PieEntry(1.3f, "Travel"));
        yValues.add(new PieEntry(0.6f, "Other"));

        Description description = new Description();
        description.setText("Location Today");
        description.setTextSize(15);
        pieChart.setDescription(description);


        pieChart.animateY(1000, Easing.EasingOption.EaseInCubic);

        PieDataSet dataSet = new PieDataSet(yValues, "Locations");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        //dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        dataSet.setValueLineColor(Color.parseColor("#888888"));
        dataSet.setValueFormatter(new MyValueFormatter());

        PieData data  = new PieData(dataSet);
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.parseColor("#555555"));

        pieChart.setData(data);

        ImageView inside_imageview = (ImageView) view.findViewById(R.id.inside_imageview);
        inside_imageview.setImageResource(R.drawable.day_night);

        formatHomeListView(view, steps, calories);

        formatHealthScoreGaugeChart(view);

    }

    private void formatHomeListView(View view, String steps, String calories)
    {
        ((CardView)view.findViewById(R.id.card_view_home)).setCardBackgroundColor(Color.parseColor("#ffeaaa"));
        ((TextView)view.findViewById(R.id.textViewTitle_home)).setText("09 September");
        ((TextView)view.findViewById(R.id.textViewTimeDuration_home)).setText("Thursday");
        ((ImageView)view.findViewById(R.id.imageViewTravel_home)).setImageResource(R.drawable.car);
        ((TextView)view.findViewById(R.id.textViewTimeStamp_home)).setText("1 hr 20 min");
        ((TextView)view.findViewById(R.id.textViewSteps_home)).setText(steps);
        ((TextView)view.findViewById(R.id.textViewCalories_home)).setText(calories);
        ((ImageView)view.findViewById(R.id.imageView_home)).setImageResource(R.drawable.calendar_bw);
    }

    private void formatHealthScoreGaugeChart(View view)
    {
//        GaugeChart gauge = (GaugeChart) view.findViewById(R.id.gauge_chart_home);
//
//        List values = new ArrayList();
//        values.add(new ChartData(60f));
//        values.add(new ChartData(65f));
//        values.add(new ChartData(55f));
//
//        gauge.setAngle(45);
//        gauge.setData(values);
//
//        ((TextView)view.findViewById(R.id.textViewHealthScore_home)).setText("Focus more on fitness");
    }
}

class MyValueFormatter implements IValueFormatter {

    private DecimalFormat mFormat;

    public MyValueFormatter() {
        mFormat = new DecimalFormat("###,###,##0.0"); // use one decimal
    }

    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        // write your logic here
        return mFormat.format(value) + "%";
    }
}
