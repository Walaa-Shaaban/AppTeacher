package com.selwan.schools365teacher.ui.event.main


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.events.calendar.utils.EventsCalendarUtil
import com.events.calendar.views.EventsCalendar
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.event.AllEvent
import com.selwan.schools365teacher.ui.event.add_new.AddEventActivity
import com.selwan.schools365teacher.ui.event.rec.AllEventActivity
import kotlinx.android.synthetic.main.event_main_fragment.*
import java.util.*

class EventMainFragment : Fragment()
    , EventsCalendar.Callback {
    override fun onDayLongPressed(selectedDate: Calendar?) {
        Log.e(
            "LONG CLICKED",
            EventsCalendarUtil.getDateString(selectedDate, EventsCalendarUtil.DD_MM_YYYY)
        )
    }

    override fun onMonthChanged(monthStartDate: Calendar?) {
        Log.e("MON", "CHANGED")
    }

    override fun onDaySelected(selectedDate: Calendar?) {
        if (EventsCalendarUtil.getDateString(
                selectedDate,
                EventsCalendarUtil.YYYY_MM_DD
            ).replace("/", "-") in listOfEvents
        ) {
            val intent = Intent(this.context, AllEventActivity::class.java)
            intent.putExtra(
                "start_date", EventsCalendarUtil.getDateString(
                    selectedDate,
                    EventsCalendarUtil.YYYY_MM_DD
                ).replace("/", "-")
            )
            startActivity(intent)

            val snackbar =
                Snackbar.make(
                    view!!,
                    "Success",
                    Snackbar.LENGTH_LONG
                )
            val sbView = snackbar.view
            sbView.setBackgroundResource(R.color.green)
            snackbar.show()
        } else {
            val snackbar =
                Snackbar.make(
                    view!!,
                    "Not found event in this day",
                    Snackbar.LENGTH_SHORT
                )
            val sbView = snackbar.view
            sbView.setBackgroundResource(R.color.redHighDelete)
            snackbar.show()
        }

    }

    var listOfEvents = ArrayList<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            com.selwan.schools365teacher.R.layout.event_main_fragment,
            container,
            false
        )


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        getViewModel().allEvent.observe(this, androidx.lifecycle.Observer {
            for (item in it.events) {
                listOfEvents.add(item.startDate)
            }
        })

        add_event.setOnClickListener {
            startActivity(Intent(this.context, AddEventActivity::class.java))
        }
        var date: String? = null
        var allEvent: AllEvent? = null

//        selected.text = getDateString(eventsCalendar.getCurrentSelectedDate()?.timeInMillis)

        val today = Calendar.getInstance()
        val maxMonth: Calendar = Calendar.getInstance()
        maxMonth.add(Calendar.YEAR, 2021)

        eventsCalendar.setSelectionMode(eventsCalendar.SINGLE_SELECTION)
            .setToday(today)
            .setMonthRange(today, maxMonth)
            .setWeekStartDay(Calendar.SUNDAY, false)
            .setIsBoldTextOnSelectionEnabled(true)
            .setCallback(this)
            .build()

        val c = Calendar.getInstance()
        c.add(Calendar.DAY_OF_MONTH, 15)
//        c.add(Calendar.MONTH, 10)
//        c.add(Calendar.YEAR, 2019)

        eventsCalendar.addEvent(c)


//        eventsCalendar.addEvent(c)
//        c.add(Calendar.DAY_OF_MONTH, 3)
//        eventsCalendar.addEvent(c)
//        c.add(Calendar.DAY_OF_MONTH, 4)
//        eventsCalendar.addEvent(c)
//        c.add(Calendar.DAY_OF_MONTH, 7)
//        eventsCalendar.addEvent(c)

//        selected.setOnClickListener {
//            val dates = eventsCalendar.getDatesFromSelectedRange()
//            Log.e("SELECTED SIZE", dates.size.toString())
//        }
//        val dc = Calendar.getInstance()
//        dc.add(Calendar.DAY_OF_MONTH, 2)
    }

    private fun getDateString(time: Long?): String {
        if (time != null) {
            val cal = Calendar.getInstance()
            cal.timeInMillis = time
            val month = when (cal[Calendar.MONTH]) {
                Calendar.JANUARY -> "January"
                Calendar.FEBRUARY -> "February"
                Calendar.MARCH -> "March"
                Calendar.APRIL -> "April"
                Calendar.MAY -> "May"
                Calendar.JUNE -> "June"
                Calendar.JULY -> "July"
                Calendar.AUGUST -> "August"
                Calendar.SEPTEMBER -> "September"
                Calendar.OCTOBER -> "October"
                Calendar.NOVEMBER -> "November"
                Calendar.DECEMBER -> "December"
                else -> ""
            }
            return "$month ${cal[Calendar.DAY_OF_MONTH]}, ${cal[Calendar.YEAR]}"
        } else return ""
    }

    fun getViewModel(): EventMainViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return EventMainViewModel() as T
            }

        })[EventMainViewModel::class.java]
    }
}