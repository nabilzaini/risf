package fr.rsif.salestaxes.utils;

public class Utils {
    private static final double ROUND_OFF = 0.05;
    public static double truncateDouble(double value) {
        return Math.floor(value * 100) / 100;
    }
    public static double roundOff(double value) {
        return (int) (value / ROUND_OFF + 0.5) * ROUND_OFF;
    }
}
