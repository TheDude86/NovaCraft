package io.novacraft.util;

/*
 * Created by snowbud56 on July 24, 2019
 * Do not change or use this code without permission
 */

public class TimeUtil {

    public static String convertmstoTime(long ms) {
        if (ms > 86400000) {
            return Math.round((((double) ms / (double) 86400000) * 100.0) / 10.0) / 10.0 + " days";
        } else if (ms > 3600000) {
            return Math.round((((double) ms / (double) 3600000) * 100.0) / 10.0) / 10.0 + " hours";
        } else if (ms > 60000) {
            return Math.round((((double) ms / (double) 60000) * 100.0) / 10.0) / 10.0 + " minutes";
        } else {
            return Math.round((((double) ms / (double) 1000) * 100.0) / 10.0) / 10.0 + " seconds";
        }
    }
}
