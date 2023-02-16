package com.example.amolpardeshi_standardarchitecuture.utils

import android.content.Context
import com.example.amolpardeshi_standardarchitecuture.R
import java.util.*
import kotlin.math.roundToInt


object Utils {

    fun getCustomTimeStringFromTimeStamp(context: Context, time_ago: Long): String {
        val curTime = Calendar.getInstance().timeInMillis / 1000
        val timeElapsed = curTime - (time_ago)
        val hours = (timeElapsed / 3600).toFloat().roundToInt()
        val days = (timeElapsed / 86400).toFloat().roundToInt()
        val weeks = (timeElapsed / 604800).toFloat().roundToInt()
        val months = (timeElapsed / 2600640).toFloat().roundToInt()
        val years = (timeElapsed / 31207680).toFloat().roundToInt()

        // Seconds
        return when {
            timeElapsed <= 60 -> context.getString(R.string.recently)
            hours <= 24 -> when (hours) {
                1 -> context.getString(R.string.x_hour_ago, hours)
                else -> context.getString(R.string.x_hours_ago, hours)
            }
            days <= 7 -> when (days) {
                1 -> context.getString(R.string.x_day_ago,days)
                else -> context.getString(R.string.x_days_ago, days)
            }
            weeks <= 4.3 -> when (weeks) {
                1 -> context.getString(R.string.x_week_ago, weeks)
                else -> context.getString(R.string.x_weeks_ago, weeks)
            }
            months <= 12 -> when (months) {
                1 -> context.getString(R.string.x_month_ago, months)
                else -> context.getString(R.string.x_months_ago, months)
            }
            else -> when (years) {
                1 -> context.getString(R.string.x_year_ago, years)
                else -> context.getString(R.string.x_years_ago, years)
            }
        }

    }

}