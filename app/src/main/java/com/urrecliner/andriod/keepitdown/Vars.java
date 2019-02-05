package com.urrecliner.andriod.keepitdown;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Vars {
    static Context mainContext;
    static int colorOn, colorOnBack, colorInactiveBack, colorOff, colorOffBack, colorActive, colorActiveBack;
    static long dbCount;
    static int nowPosition, nowUniqueId;
    static int oneTimeId = -12345;
    static int xSize; // width for each week in AddActivity
    static int addViewWeek[] = new int[7];
    static int listViewWeek[] = new int[7];
    static String weekName[] = new String[7];
    static Utils utils = null;
    static MainActivity mainActivity;
    static AddActivity addActivity;
    static TimerActivity timerActivity;

    static final SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    static final SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    static final SimpleDateFormat sdfLog = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss sss", Locale.US);

}
