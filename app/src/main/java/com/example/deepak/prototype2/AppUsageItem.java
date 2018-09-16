package com.example.deepak.prototype2;

public class AppUsageItem
{
    private String appName;
    private String packageName;
    private int appIcon;
    private String usageTime;
    private long millis;

    public AppUsageItem(String appName, String packageName, int appIcon, String usageTime, long millis) {
        this.appName = appName;
        this.packageName = packageName;
        this.appIcon = appIcon;
        this.usageTime = usageTime;
        this.millis = millis;
    }

    public String getAppName() {
        return appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public int getAppIcon() {
        return appIcon;
    }

    public String getUsageTime() {
        return usageTime;
    }

    public long getMillis()
    {
        return millis;
    }
}
