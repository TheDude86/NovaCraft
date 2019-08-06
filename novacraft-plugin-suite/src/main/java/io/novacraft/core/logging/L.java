package io.novacraft.core.logging;

public class L {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void v(String message) {
        System.out.println("[Verbose]" + message);
    }

    public static void l(String message) {
        System.out.println(ANSI_BLUE + "[Log]: " + message + ANSI_RESET);
    }

    public static void d(String message) {
        System.out.println(ANSI_GREEN + "[Debug]: " + message + ANSI_RESET);
    }

    public static void e(String message) {
        System.out.println(ANSI_YELLOW + "[Error]: " + message + ANSI_RESET);
    }

    public static void a(String message) {
        System.out.println(ANSI_RED + "[Assert]: " + message + ANSI_RESET);
    }
}
