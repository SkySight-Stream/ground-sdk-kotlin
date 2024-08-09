package com.parrot.hellodrone

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class AnalyticActivity : AppCompatActivity() {

    private lateinit var barChart: BarChart
    private lateinit var lineChart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analytic)

        barChart = findViewById(R.id.barChart)
        lineChart = findViewById(R.id.lineChart)

        // Setup the charts
        setupBarChart()
        setupLineChart()
    }

    private fun setupBarChart() {
        val entries = mutableListOf(
            BarEntry(0f, 2f),
            BarEntry(1f, 4f),
            BarEntry(2f, 6f),
            BarEntry(3f, 5f),
            BarEntry(4f, 7f)
        )

        // Create the BarDataSet
        val barDataSet = BarDataSet(entries, "Bar Data").apply {
            color = Color.parseColor("#85FF5722") // Set the bar color to orange
        }

        // Create BarData and set the bar width
        val barData = BarData(barDataSet).apply {
            barWidth = 0.5f // Set the bar width (default is 0.85f)
        }

        barChart.data = barData
        barChart.invalidate() // Refresh the chart
    }

    private fun setupLineChart() {
        val lineEntries = mutableListOf(
            Entry(0f, 1f),
            Entry(1f, 3f),
            Entry(2f, 5f),
            Entry(3f, 7f),
            Entry(4f, 4f)
        )

        // Create the LineDataSet
        val lineDataSet = LineDataSet(lineEntries, "Line Data").apply {
            color = Color.parseColor("#85FF5722") // Set the bar color to orange
            valueTextColor = Color.BLACK // Optional: change value text color
            lineWidth = 2f // Set the line width
            circleColors = listOf(Color.RED) // Set circle color for points on the line
        }

        val lineData = LineData(lineDataSet)
        lineChart.data = lineData
        lineChart.invalidate() // Refresh the chart
    }
}