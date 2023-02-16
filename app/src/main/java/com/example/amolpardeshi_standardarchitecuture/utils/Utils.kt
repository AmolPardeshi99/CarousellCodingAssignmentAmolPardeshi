package com.example.amolpardeshi_standardarchitecuture.utils

import android.annotation.SuppressLint
import android.content.Context
import com.example.amolpardeshi_standardarchitecuture.R
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.roundToInt


object Utils {

    private val tzFormatDate = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

    fun getFormattedDate(dateString: String?): Calendar {
        if (!dateString.isNullOrEmpty()) {
            try {
                val dateFormat: DateFormat = SimpleDateFormat(tzFormatDate)
                val date: Date = dateFormat.parse(dateString)
                val cal = Calendar.getInstance()
                cal.time = date
                return cal
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }
        return Calendar.getInstance()
    }

    fun getFormattedDate(dateString: Date?): Calendar {
        if (dateString != null) {
            try {
                val cal = Calendar.getInstance()
                cal.time = dateString
                return cal
            } catch (e: ParseException) {
                e.printStackTrace()
            }

        }
        return Calendar.getInstance()
    }

    fun getFormattedDate(timeInMillis: Long?): Calendar {
        if (timeInMillis != null) {
            try {
                val date: Date = Date(timeInMillis)
                val cal = Calendar.getInstance()
                cal.time = date
                return cal
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }
        return Calendar.getInstance()
    }

//    fun getFormattedStringForAdapter(date1: Long, date2: Long = System.currentTimeMillis()) {
//        val cal1 = getFormattedDate(date2-date1)
//
//        val hoursLeft = cal1.minimalDaysInFirstWeek
//        val daysLeft = TimeUnit.DAYS.toDays(diffInMillis)
//        val weeksLeft = daysLeft / 7
//        val monthsLeft = weeksLeft / 4
//        val yearsLeft = monthsLeft/12
//
//        return if (yearsLeft > 0) {
//            "$yearsLeft years ago"
//        } else if (monthsLeft > 0) {
//            "$monthsLeft months ago"
//        } else if (weeksLeft > 0) {
//            "$weeksLeft weeks ago"
//        } else if (daysLeft > 0) {
//            "$daysLeft days ago"
//        } else if (hoursLeft > 0) {
//            "$hoursLeft hours ago"
//        } else if (hoursLeft < 0) {
//            "recently posted"
//        } else ""
//    } catch (e: Exception) {
//        return ""
//    }
//    }

    fun getDateTime(dateString: Date?, hour: Int, minute: Int): Date {
        if (dateString != null) {
            try {
                val cal = getFormattedDate(dateString)
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                return cal.time
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }
        return Date()
    }


    fun stringFromTimestampToCurrentDate(dateTimeStamp: String): String {
        if (dateTimeStamp.isNullOrEmpty()) return ""
        try {
            val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh")
            val currTimeMillis = System.currentTimeMillis()/1000
            val givenTimeMillis = dateTimeStamp.toLong()

            val diffInMillis = currTimeMillis-givenTimeMillis;

            val hoursLeft = TimeUnit.HOURS.toHours(diffInMillis)
            val daysLeft = TimeUnit.DAYS.toDays(diffInMillis)
            val weeksLeft = daysLeft / 7
            val monthsLeft = weeksLeft / 4
            val yearsLeft = monthsLeft/12


            return if (yearsLeft > 0) {
                "$yearsLeft years ago"
            } else if (monthsLeft > 0) {
                "$monthsLeft months ago"
            } else if (weeksLeft > 0) {
                "$weeksLeft weeks ago"
            } else if (daysLeft > 0) {
                "$daysLeft days ago"
            } else if (hoursLeft > 0) {
                "$hoursLeft hours ago"
            } else if (hoursLeft < 0) {
                "recently posted"
            } else ""
        } catch (e: Exception) {
            return ""
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun dateFormatter(milliseconds: String): String {
        return SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Date(milliseconds.toLong()))
    }

    private fun epochToIso8601(time: Long): String {
        val format = "dd MMM yyyy HH:mm:ss" // you can add the format you need
        val sdf = SimpleDateFormat(format, Locale.getDefault()) // default local
        sdf.timeZone = TimeZone.getDefault() // set anytime zone you need
        return sdf.format(Date(time * 1000))
    }

    fun convertEpochMillisToDate(timeStamp: Long): Date {
        return Date(timeStamp)
//        val timeStamp = Timestamp(System.currentTimeMillis()) val date = Date(timeStamp.getTime())
    }

    fun timeAgo(context: Context, time_ago: Long): String {
        val curTime = Calendar.getInstance().timeInMillis / 1000
        val timeElapsed = curTime - (time_ago)
        val minutes = (timeElapsed / 60).toFloat().roundToInt()
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