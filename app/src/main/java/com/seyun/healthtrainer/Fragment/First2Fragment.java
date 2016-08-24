package com.seyun.healthtrainer.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.seyun.healthtrainer.R;

import java.util.ArrayList;
import java.util.List;

public class First2Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first2, container, false);
        BarChart chart = (BarChart) view.findViewById(R.id.chart);
        // programmatically create a LineChart


        List<BarEntry> entries = new ArrayList<BarEntry>();

        // turn your data into Entry objects
        entries.add(new BarEntry(1,2));
        entries.add(new BarEntry(3,5));
        entries.add(new BarEntry(3,8));
        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        chart.setData(data);
        chart.setFitBars(true); // make the x-axis fit exactly all bars
        chart.invalidate(); // refresh

        return view;
    }
}