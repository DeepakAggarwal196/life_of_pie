package com.example.deepak.prototype2;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppUsage
{
    private Context context;
    private ArrayList<AppUsageItem> appUsageList;
    private ArrayList<String> appNameList;
    private ArrayList<String> excludedKeywords;

    public AppUsage(Context context)
    {
        this.context = context;
        appUsageList = new ArrayList<>();
        appNameList = new ArrayList<>();
        initExcludedApps();
    }

    public ArrayList<AppUsageItem> getAppUsageList()
    {
        final UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);// Context.USAGE_STATS_SERVICE);
        Calendar beginCal = Calendar.getInstance();
        beginCal.set(Calendar.DAY_OF_MONTH, 15);
        beginCal.set(Calendar.MONTH, 8);
        beginCal.set(Calendar.YEAR, 2018);
        beginCal.set(Calendar.HOUR,0);
        beginCal.set(Calendar.MINUTE,0);
        beginCal.set(Calendar.SECOND,0);

        Calendar endCal = Calendar.getInstance();
        endCal.set(Calendar.DAY_OF_MONTH, 15);
        endCal.set(Calendar.MONTH, 8);
        endCal.set(Calendar.YEAR, 2018);
        endCal.set(Calendar.HOUR,23);
        endCal.set(Calendar.MINUTE,59);
        endCal.set(Calendar.SECOND,59);

        final List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, beginCal.getTimeInMillis(), endCal.getTimeInMillis());
        System.out.println("\n\n\nresults for " + beginCal.getTime().toGMTString() + " - " + endCal.getTime().toGMTString());
        System.out.println("SIZE: "+queryUsageStats.size());

        for (UsageStats app : queryUsageStats) {

//            System.out.println(getAppNameFromPackageName(app.getPackageName()) + " | " + (float) (app.getTotalTimeInForeground() / 1000));
            addItemToList(app);

        }

        sortList();

        return appUsageList;
    }

    private void addItemToList(UsageStats app)
    {
        String packageName = app.getPackageName();
        String appName = getAppNameFromPackageName(packageName);

        for(String excludedWord : excludedKeywords)
        {
            if(appName.toLowerCase().contains(excludedWord))
                return;
        }


        long millis = 0L;

        if(appNameList.contains(appName))
        {
            int position=-1;
            for(int i=0;i<appUsageList.size();i++)
            {
                AppUsageItem item = appUsageList.get(i);
                if(item.getAppName() == appName)
                {
                    millis += item.getMillis();
                    position = i;
                    break;
                }
            }

            if(position>=0)
                appUsageList.remove(position);
        }
        else
            appNameList.add(appName);

        millis += app.getTotalTimeInForeground();
        String usageTime = getUsageTimeInFormat(millis);
        if(usageTime == null)
            return;

        AppUsageItem item = new AppUsageItem(appName, packageName, 1, usageTime, millis);
        appUsageList.add(item);

    }

    private String getUsageTimeInFormat(long millis)
    {
        long hours =  TimeUnit.MILLISECONDS.toHours(millis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis));



        if(hours == 0 && minutes==0 && seconds==0)
            return null;

        String time = "";

        if(hours==0 && minutes==0)
            time = String.format("%02d sec", seconds);
        else if(hours==0)
            time = String.format("%02d min %02d sec", minutes, seconds);
        else
            time = String.format("%02d hr %02d min %02d sec", hours, minutes, seconds);

        return time;
    }

    private String getAppNameFromPackageName(String packageName)
    {
        final PackageManager pm = context.getApplicationContext().getPackageManager();
        ApplicationInfo ai;
        try {
            ai = pm.getApplicationInfo( packageName, 0);
        } catch (final PackageManager.NameNotFoundException e) {
            ai = null;
        }
        String applicationName = (String) (ai != null ? pm.getApplicationLabel(ai) : "(unknown)");
        return applicationName;
    }

    private void sortList()
    {
        Collections.sort(appUsageList, new Comparator<AppUsageItem>(){

            public int compare(AppUsageItem o1, AppUsageItem o2)
            {
                return ((Long)o2.getMillis()).compareTo((Long)o1.getMillis());
            }
        });
    }

    private void initExcludedApps()
    {
        excludedKeywords = new ArrayList<>();
        excludedKeywords.add("Launcher");
        excludedKeywords.add("System UI");
    }
}
