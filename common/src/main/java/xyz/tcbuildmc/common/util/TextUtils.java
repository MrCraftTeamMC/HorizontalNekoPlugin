package xyz.tcbuildmc.common.util;

public final class TextUtils {
    public static String format(final String string, final Object... args) {
        String message = string;

        for (Object o : args) {
            message = message.replaceFirst("%*%", o.toString());
        }

        return message;
    }
}
