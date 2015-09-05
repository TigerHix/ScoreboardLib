package me.tigerhix.lib.scoreboard.common;

import org.bukkit.ChatColor;

public final class Strings {

    private Strings() {
    }

    public static String format(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String repeat(String string, int count) {
        if (count <= 1) {
            return count == 0 ? "" : string;
        } else {
            int len = string.length();
            long longSize = (long) len * (long) count;
            int size = (int) longSize;
            if ((long) size != longSize) {
                throw new ArrayIndexOutOfBoundsException("Required array size too large: " + longSize);
            } else {
                char[] array = new char[size];
                string.getChars(0, len, array, 0);
                int n;
                for (n = len; n < size - n; n <<= 1) {
                    System.arraycopy(array, 0, array, n, n);
                }
                System.arraycopy(array, 0, array, n, size - n);
                return new String(array);
            }
        }
    }

}
