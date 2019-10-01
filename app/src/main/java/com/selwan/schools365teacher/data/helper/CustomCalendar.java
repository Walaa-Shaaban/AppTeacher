package com.selwan.schools365teacher.data.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;


import com.selwan.schools365teacher.R;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;


public class CustomCalendar extends LinearLayout {

    private static final String DAY_OF_THE_WEEK_TEXT = "dayOfTheWeekText";
    private static final String DAY_OF_THE_WEEK_LAYOUT = "dayOfTheWeekLayout";
    private static final String DAY_OF_THE_MONTH_LAYOUT = "dayOfTheMonthLayout";
    private static final String DAY_OF_THE_MONTH_TEXT = "dayOfTheMonthText";
    private static final String DAY_OF_THE_MONTH_BACKGROUND = "dayOfTheMonthBackground";
    private static final String DAY_OF_THE_MONTH_CIRCLE_IMAGE_1 = "dayOfTheMonthCircleImage1";
    private static final String DAY_OF_THE_MONTH_CIRCLE_IMAGE_2 = "dayOfTheMonthCircleImage2";
    private static final String DAY_OF_THE_MONTH_CIRCLE_IMAGE_3 = "dayOfTheMonthCircleImage3";
    private static final String DAY_OF_THE_MONTH_CIRCLE_IMAGE_4 = "dayOfTheMonthCircleImage4";
    private static final String DAY_OF_THE_MONTH_CIRCLE_IMAGE_5 = "dayOfTheMonthCircleImage5";
    String dateText;
    private Context context;
    private TextView dateTitle;
    private ImageView leftButton;
    private ImageView rightButton;
    private View rootView;
    private ViewGroup robotoCalendarMonthLayout;
    // Class
    private RobotoCalendarListener robotoCalendarListener;
    private Calendar currentCalendar;
    private Calendar lastSelectedDayCalendar;
    private boolean shortWeekDays = false;

    // ************************************************************************************************************************************************************************
    // * Initialization methods
    // ************************************************************************************************************************************************************************
    private OnClickListener onDayOfMonthClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {

            // Extract day selected
            ViewGroup dayOfTheMonthContainer = (ViewGroup) view;
            String tagId = (String) dayOfTheMonthContainer.getTag();
            tagId = tagId.substring(DAY_OF_THE_MONTH_LAYOUT.length());
            TextView dayOfTheMonthText = view.findViewWithTag(DAY_OF_THE_MONTH_TEXT + tagId);

            // Extract the day from the text
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, currentCalendar.get(Calendar.YEAR));
            calendar.set(Calendar.MONTH, currentCalendar.get(Calendar.MONTH));
            calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(dayOfTheMonthText.getText().toString()));

            markDayAsSelectedDay(calendar);

            // Fire event
            if (robotoCalendarListener == null) {
                throw new IllegalStateException("You must assign a valid RobotoCalendarListener first!");
            } else {
                robotoCalendarListener.onDayClick(calendar);
            }
        }
    };
    private OnLongClickListener onDayOfMonthLongClickListener = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {

            // Extract day selected
            ViewGroup dayOfTheMonthContainer = (ViewGroup) view;
            String tagId = (String) dayOfTheMonthContainer.getTag();
            tagId = tagId.substring(DAY_OF_THE_MONTH_LAYOUT.length());
            TextView dayOfTheMonthText = view.findViewWithTag(DAY_OF_THE_MONTH_TEXT + tagId);

            // Extract the day from the text
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, currentCalendar.get(Calendar.YEAR));
            calendar.set(Calendar.MONTH, currentCalendar.get(Calendar.MONTH));
            calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(dayOfTheMonthText.getText().toString()));

            markDayAsSelectedDay(calendar);

            // Fire event
            if (robotoCalendarListener == null) {
                throw new IllegalStateException("You must assign a valid RobotoCalendarListener first!");
            } else {
                robotoCalendarListener.onDayLongClick(calendar);
            }
            return true;
        }
    };

    public CustomCalendar(Context context) {
        super(context);
        this.context = context;
        onCreateView();
    }

    public CustomCalendar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        if (isInEditMode()) {
            return;
        }
        onCreateView();
    }

    private View onCreateView() {
        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rootView = inflate.inflate(R.layout.roboto_calendar_picker_layout, this, true);
        findViewsById(rootView);
        setUpEventListeners();

        Calendar currentCalendar = Calendar.getInstance();
        setCalendar(currentCalendar);

        return rootView;
    }


    // ************************************************************************************************************************************************************************
    // * Auxiliary UI methods
    // ************************************************************************************************************************************************************************

    private void findViewsById(View view) {

        robotoCalendarMonthLayout = view.findViewById(R.id.robotoCalendarDateTitleContainer);
        leftButton = view.findViewById(R.id.leftButton);
        rightButton = view.findViewById(R.id.rightButton);
        dateTitle = view.findViewById(R.id.monthText);

        for (int i = 0; i < 42; i++) {

            LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            int weekIndex = (i % 7) + 1;
            ViewGroup dayOfTheWeekLayout = view.findViewWithTag(DAY_OF_THE_WEEK_LAYOUT + weekIndex);

            // Create day of the month
            View dayOfTheMonthLayout = inflate.inflate(R.layout.roboto_calendar_day_of_the_month_layout, null);
            View dayOfTheMonthText = dayOfTheMonthLayout.findViewWithTag(DAY_OF_THE_MONTH_TEXT);
            View dayOfTheMonthBackground = dayOfTheMonthLayout.findViewWithTag(DAY_OF_THE_MONTH_BACKGROUND);
            View dayOfTheMonthCircleImage1 = dayOfTheMonthLayout.findViewWithTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_1);
            View dayOfTheMonthCircleImage2 = dayOfTheMonthLayout.findViewWithTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_2);
            View dayOfTheMonthCircleImage3 = dayOfTheMonthLayout.findViewWithTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_3);
            View dayOfTheMonthCircleImage4 = dayOfTheMonthLayout.findViewWithTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_4);
            View dayOfTheMonthCircleImage5 = dayOfTheMonthLayout.findViewWithTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_5);

            // Set tags to identify them
            int viewIndex = i + 1;
            dayOfTheMonthLayout.setTag(DAY_OF_THE_MONTH_LAYOUT + viewIndex);
            dayOfTheMonthText.setTag(DAY_OF_THE_MONTH_TEXT + viewIndex);
            dayOfTheMonthBackground.setTag(DAY_OF_THE_MONTH_BACKGROUND + viewIndex);
            dayOfTheMonthCircleImage1.setTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_1 + viewIndex);
            dayOfTheMonthCircleImage2.setTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_2 + viewIndex);
            dayOfTheMonthCircleImage3.setTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_3 + viewIndex);
            dayOfTheMonthCircleImage4.setTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_4 + viewIndex);
            dayOfTheMonthCircleImage5.setTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_5 + viewIndex);
            dayOfTheWeekLayout.addView(dayOfTheMonthLayout);


//            Log.e("circle iv tag", dayOfTheMonthCircleImage1.getTag().toString()+"..");

        }
    }

    private void setUpEventListeners() {

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (robotoCalendarListener == null) {
                    throw new IllegalStateException("You must assign a valid RobotoCalendarListener first!");
                }

                // Decrease month
                currentCalendar.add(Calendar.MONTH, -1);
                Log.e("currentMonthvv", currentCalendar.toString());
                lastSelectedDayCalendar = null;
                updateView();
                robotoCalendarListener.onLeftButtonClick();
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (robotoCalendarListener == null) {
                    throw new IllegalStateException("You must assign a valid RobotoCalendarListener first!");
                }

                // Increase month
                currentCalendar.add(Calendar.MONTH, 1);
                lastSelectedDayCalendar = null;
                updateView();
                robotoCalendarListener.onRightButtonClick();
            }
        });
    }

    private void setUpMonthLayout() {
        dateText = new DateFormatSymbols(Locale.getDefault()).getMonths()[currentCalendar.get(Calendar.MONTH)];
        dateText = dateText.substring(0, 1).toUpperCase() + dateText.subSequence(1, dateText.length());
        Calendar calendar = Calendar.getInstance();
        if (currentCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
            dateTitle.setText(dateText);
        } else {
            dateTitle.setText(String.format("%s %s", dateText, currentCalendar.get(Calendar.YEAR)));
        }
    }

    private void setUpWeekDaysLayout() {
        TextView dayOfWeek;
        String dayOfTheWeekString;
        String[] weekDaysArray = new DateFormatSymbols(Locale.getDefault()).getWeekdays();
        for (int i = 1; i < weekDaysArray.length; i++) {
            dayOfWeek = rootView.findViewWithTag(DAY_OF_THE_WEEK_TEXT + getWeekIndex(i, currentCalendar));
            dayOfTheWeekString = weekDaysArray[i];
            if (shortWeekDays) {
                dayOfTheWeekString = checkSpecificLocales(dayOfTheWeekString, i);
            } else {
                dayOfTheWeekString = dayOfTheWeekString.substring(0, 1).toUpperCase() + dayOfTheWeekString.substring(1, 3);
            }
            dayOfWeek.setText(dayOfTheWeekString);
        }
    }

    private void setUpDaysOfMonthLayout() {

        TextView dayOfTheMonthText;
        View circleImage1;
        View circleImage2;
        View circleImage3;
        View circleImage4;
        View circleImage5;
        ViewGroup dayOfTheMonthContainer;
        ViewGroup dayOfTheMonthBackground;

        for (int i = 1; i < 43; i++) {

            dayOfTheMonthContainer = rootView.findViewWithTag(DAY_OF_THE_MONTH_LAYOUT + i);
            dayOfTheMonthBackground = rootView.findViewWithTag(DAY_OF_THE_MONTH_BACKGROUND + i);
            dayOfTheMonthText = rootView.findViewWithTag(DAY_OF_THE_MONTH_TEXT + i);
            circleImage1 = rootView.findViewWithTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_1 + i);
            circleImage2 = rootView.findViewWithTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_2 + i);
            circleImage3 = rootView.findViewWithTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_3 + i);
            circleImage4 = rootView.findViewWithTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_4 + i);
            circleImage5 = rootView.findViewWithTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_5 + i);

            dayOfTheMonthText.setVisibility(View.INVISIBLE);
            circleImage1.setVisibility(View.GONE);
            circleImage2.setVisibility(View.GONE);
            circleImage3.setVisibility(View.GONE);
            circleImage4.setVisibility(View.GONE);
            circleImage5.setVisibility(View.GONE);


            // Apply styles
            dayOfTheMonthText.setBackgroundResource(android.R.color.transparent);
            dayOfTheMonthText.setTypeface(null, Typeface.NORMAL);
            dayOfTheMonthText.setTextColor(ContextCompat.getColor(context, R.color.roboto_calendar_day_of_the_month_font));
            dayOfTheMonthContainer.setBackgroundResource(android.R.color.transparent);
            dayOfTheMonthContainer.setOnClickListener(null);
            dayOfTheMonthBackground.setBackgroundResource(android.R.color.transparent);
        }
    }

    private void setUpDaysInCalendar() {

        Calendar auxCalendar = Calendar.getInstance(Locale.getDefault());
        auxCalendar.setTime(currentCalendar.getTime());
        auxCalendar.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfMonth = auxCalendar.get(Calendar.DAY_OF_WEEK);
        TextView dayOfTheMonthText;
        ViewGroup dayOfTheMonthContainer;
        ViewGroup dayOfTheMonthLayout;

        // Calculate dayOfTheMonthIndex
        int dayOfTheMonthIndex = getWeekIndex(firstDayOfMonth, auxCalendar);

        for (int i = 1; i <= auxCalendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++, dayOfTheMonthIndex++) {
            dayOfTheMonthContainer = rootView.findViewWithTag(DAY_OF_THE_MONTH_LAYOUT + dayOfTheMonthIndex);
            dayOfTheMonthText = rootView.findViewWithTag(DAY_OF_THE_MONTH_TEXT + dayOfTheMonthIndex);
            if (dayOfTheMonthText == null) {
                break;
            }
            dayOfTheMonthContainer.setOnClickListener(onDayOfMonthClickListener);
            dayOfTheMonthContainer.setOnLongClickListener(onDayOfMonthLongClickListener);
            dayOfTheMonthText.setVisibility(View.VISIBLE);
            dayOfTheMonthText.setText(String.valueOf(i));
        }

        for (int i = 36; i < 43; i++) {
            dayOfTheMonthText = rootView.findViewWithTag(DAY_OF_THE_MONTH_TEXT + i);
            dayOfTheMonthLayout = rootView.findViewWithTag(DAY_OF_THE_MONTH_LAYOUT + i);
            if (dayOfTheMonthText.getVisibility() == INVISIBLE) {
                dayOfTheMonthLayout.setVisibility(GONE);
            } else {
                dayOfTheMonthLayout.setVisibility(VISIBLE);
            }
        }
    }

    private void markDayAsCurrentDay() {
        // If it's the current month, mark current day
        Calendar nowCalendar = Calendar.getInstance();
        if (nowCalendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR) && nowCalendar.get(Calendar.MONTH) == currentCalendar.get(Calendar.MONTH)) {
            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTime(nowCalendar.getTime());

            ViewGroup dayOfTheMonthBackground = getDayOfMonthBackground(currentCalendar);
            dayOfTheMonthBackground.setBackgroundResource(R.drawable.ring);
        }
    }

    private void markDayAsSelectedDay(Calendar calendar) {

        // Clear previous current day mark
        clearSelectedDay(lastSelectedDayCalendar);

        // Store current values as last values
        lastSelectedDayCalendar = calendar;

        // Mark current day as selected
        ViewGroup dayOfTheMonthBackground = getDayOfMonthBackground(calendar);
        dayOfTheMonthBackground.setBackgroundResource(R.drawable.circle_blue);

        TextView dayOfTheMonth = getDayOfMonthText(calendar);
        dayOfTheMonth.setTextColor(ContextCompat.getColor(context, R.color.roboto_calendar_selected_day_font));

        ImageView circleImage1 = getCircleImage1(calendar);
        ImageView circleImage2 = getCircleImage2(calendar);
        ImageView circleImage3 = getCircleImage3(calendar);
        ImageView circleImage4 = getCircleImage3(calendar);
        ImageView circleImage5 = getCircleImage3(calendar);


        if (circleImage1.getVisibility() == VISIBLE) {
            DrawableCompat.setTint(circleImage1.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_selected_day_font));
        }

        if (circleImage2.getVisibility() == VISIBLE) {
            DrawableCompat.setTint(circleImage2.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_selected_day_font));
        }

        if (circleImage3.getVisibility() == VISIBLE) {
            DrawableCompat.setTint(circleImage3.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_selected_day_font));
        }

        if (circleImage4.getVisibility() == VISIBLE) {
            DrawableCompat.setTint(circleImage4.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_selected_day_font));
        }

        if (circleImage5.getVisibility() == VISIBLE) {
            DrawableCompat.setTint(circleImage5.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_selected_day_font));
        }

    }

    // ************************************************************************************************************************************************************************
    // * Public calendar methods
    // ************************************************************************************************************************************************************************

    private void clearSelectedDay(Calendar calendar) {
        if (calendar != null) {

            ViewGroup dayOfTheMonthBackground = getDayOfMonthBackground(calendar);

            // If it's today, keep the current day style
            Calendar nowCalendar = Calendar.getInstance();
            if (nowCalendar.get(Calendar.YEAR) == lastSelectedDayCalendar.get(Calendar.YEAR) && nowCalendar.get(Calendar.DAY_OF_YEAR) == lastSelectedDayCalendar.get(Calendar.DAY_OF_YEAR)) {
                dayOfTheMonthBackground.setBackgroundResource(R.drawable.ring);
            } else {
                dayOfTheMonthBackground.setBackgroundResource(android.R.color.transparent);
            }

            TextView dayOfTheMonth = getDayOfMonthText(calendar);
            dayOfTheMonth.setTextColor(ContextCompat.getColor(context, R.color.roboto_calendar_day_of_the_month_font));

            ImageView circleImage1 = getCircleImage1(calendar);
            ImageView circleImage2 = getCircleImage2(calendar);
            ImageView circleImage3 = getCircleImage3(calendar);
            ImageView circleImage4 = getCircleImage3(calendar);
            ImageView circleImage5 = getCircleImage3(calendar);


            if (circleImage1.getVisibility() == VISIBLE) {
                DrawableCompat.setTint(circleImage1.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_circle_1));
            }

            if (circleImage2.getVisibility() == VISIBLE) {
                DrawableCompat.setTint(circleImage2.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_circle_2));
            }

            if (circleImage3.getVisibility() == VISIBLE) {
                DrawableCompat.setTint(circleImage3.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_circle_3));
            }

            if (circleImage4.getVisibility() == VISIBLE) {
                DrawableCompat.setTint(circleImage4.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_circle_4));
            }

            if (circleImage5.getVisibility() == VISIBLE) {
                DrawableCompat.setTint(circleImage5.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_circle_5));
            }
        }
    }

    private String checkSpecificLocales(String dayOfTheWeekString, int i) {
        // Set Wednesday as "X" in Spanish Locale.getDefault()
        if (i == 4 && Locale.getDefault().getCountry().equals("ES")) {
            dayOfTheWeekString = "X";
        } else {
            dayOfTheWeekString = dayOfTheWeekString.substring(0, 1).toUpperCase();
        }
        return dayOfTheWeekString;
    }

    /**
     * Set an specific calendar to the view
     *
     * @param calendar
     */
    public void setCalendar(Calendar calendar) {
        this.currentCalendar = calendar;
        updateView();
    }

    /**
     * Update the calendar view
     */
    public void updateView() {
        setUpMonthLayout();
        setUpWeekDaysLayout();
        setUpDaysOfMonthLayout();
        setUpDaysInCalendar();
        markDayAsCurrentDay();
    }

    public void setShortWeekDays(boolean shortWeekDays) {
        this.shortWeekDays = shortWeekDays;
    }

    /**
     * Clear the view of marks and selections
     */
    public void clearCalendar() {
        updateView();
    }

    public void markCircleImage1(Calendar calendar) {
        ImageView circleImage1 = getCircleImage1(calendar);
        circleImage1.setVisibility(View.VISIBLE);
        DrawableCompat.setTint(circleImage1.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_circle_1));
        ViewGroup dayOfTheMonthBackground = getDayOfMonthBackground(calendar);
//        dayOfTheMonthBackground.setBackgroundResource(R.drawable.circle_blue);
    }

    public void markCircleImage2(Calendar calendar) {
        ImageView circleImage2 = getCircleImage2(calendar);
        Log.e("calender", calendar.toString() + "..");
        Log.e("imv", circleImage2.toString() + "..");
        circleImage2.setVisibility(View.VISIBLE);
        DrawableCompat.setTint(circleImage2.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_circle_2));
        ViewGroup dayOfTheMonthBackground = getDayOfMonthBackground(calendar);
//        dayOfTheMonthBackground.setBackgroundResource(R.drawable.circle_blue);
        Log.e("position", "markCircleImage2");
    }

    public void markCircleImage3(Calendar calendar) {
        ImageView circleImage3 = getCircleImage3(calendar);
        circleImage3.setVisibility(View.VISIBLE);
        DrawableCompat.setTint(circleImage3.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_circle_3));
//        ViewGroup dayOfTheMonthBackground = getDayOfMonthBackground(calendar);
        //dayOfTheMonthBackground.setBackgroundResource(R.drawable.circle_blue);
    }

    public void markCircleImage4(Calendar calendar) {
        ImageView circleImage4 = getCircleImage4(calendar);
        circleImage4.setVisibility(View.VISIBLE);
        DrawableCompat.setTint(circleImage4.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_circle_4));
//        ViewGroup dayOfTheMonthBackground = getDayOfMonthBackground(calendar);
        //dayOfTheMonthBackground.setBackgroundResource(R.drawable.circle_blue);
    }

    // ************************************************************************************************************************************************************************
    // * Public interface
    // ************************************************************************************************************************************************************************

    public void markCircleImage5(Calendar calendar) {
        ImageView circleImage5 = getCircleImage5(calendar);
        circleImage5.setVisibility(View.VISIBLE);
        DrawableCompat.setTint(circleImage5.getDrawable(), ContextCompat.getColor(context, R.color.roboto_calendar_circle_5));
//        ViewGroup dayOfTheMonthBackground = getDayOfMonthBackground(calendar);
        //dayOfTheMonthBackground.setBackgroundResource(R.drawable.circle_blue);
    }

    public void showDateTitle(boolean show) {
        if (show) {
            robotoCalendarMonthLayout.setVisibility(VISIBLE);
        } else {
            robotoCalendarMonthLayout.setVisibility(GONE);
        }
    }

    // ************************************************************************************************************************************************************************
    // * Event handler methods
    // ************************************************************************************************************************************************************************

    public void setRobotoCalendarListener(RobotoCalendarListener robotoCalendarListener) {
        this.robotoCalendarListener = robotoCalendarListener;
    }

    private ViewGroup getDayOfMonthBackground(Calendar currentCalendar) {
        return (ViewGroup) getView(DAY_OF_THE_MONTH_BACKGROUND, currentCalendar);
    }

    // ************************************************************************************************************************************************************************
    // * Getter methods
    // ************************************************************************************************************************************************************************

    private TextView getDayOfMonthText(Calendar currentCalendar) {
        return (TextView) getView(DAY_OF_THE_MONTH_TEXT, currentCalendar);
    }

    private ImageView getCircleImage1(Calendar currentCalendar) {
        return (ImageView) getView(DAY_OF_THE_MONTH_CIRCLE_IMAGE_1, currentCalendar);
    }

    private ImageView getCircleImage2(Calendar currentCalendar) {
        return (ImageView) getView(DAY_OF_THE_MONTH_CIRCLE_IMAGE_2, currentCalendar);
    }

    private ImageView getCircleImage3(Calendar currentCalendar) {
        return (ImageView) getView(DAY_OF_THE_MONTH_CIRCLE_IMAGE_3, currentCalendar);
    }

    private ImageView getCircleImage4(Calendar currentCalendar) {
        return (ImageView) getView(DAY_OF_THE_MONTH_CIRCLE_IMAGE_4, currentCalendar);
    }

    private ImageView getCircleImage5(Calendar currentCalendar) {
        return (ImageView) getView(DAY_OF_THE_MONTH_CIRCLE_IMAGE_5, currentCalendar);
    }

    private int getDayIndexByDate(Calendar currentCalendar) {
        int monthOffset = getMonthOffset(currentCalendar);
        int currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH);
        return currentDay + monthOffset;
    }

    private int getMonthOffset(Calendar currentCalendar) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentCalendar.getTime());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayWeekPosition = calendar.getFirstDayOfWeek();
        int dayPosition = calendar.get(Calendar.DAY_OF_WEEK);

        if (firstDayWeekPosition == 1) {
            return dayPosition - 1;
        } else {

            if (dayPosition == 1) {
                return 6;
            } else {
                return dayPosition - 2;
            }
        }
    }

    private int getWeekIndex(int weekIndex, Calendar currentCalendar) {
        int firstDayWeekPosition = currentCalendar.getFirstDayOfWeek();

        if (firstDayWeekPosition == 1) {
            return weekIndex;
        } else {

            if (weekIndex == 1) {
                return 7;
            } else {
                return weekIndex - 1;
            }
        }
    }

    private View getView(String key, Calendar currentCalendar) {
        int index = getDayIndexByDate(currentCalendar);
        View view = rootView.findViewWithTag(key + index);
        return view;
    }

    public interface RobotoCalendarListener {

        void onDayClick(Calendar daySelectedCalendar);

        void onDayLongClick(Calendar daySelectedCalendar);

        void onRightButtonClick();

        void onLeftButtonClick();
    }

}
