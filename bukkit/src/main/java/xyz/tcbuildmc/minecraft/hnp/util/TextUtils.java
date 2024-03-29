package xyz.tcbuildmc.minecraft.hnp.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.Map;

public final class TextUtils {
    public static String format(final ChatColor color, final String string, final Object... args) {
        String message = color + string;

        for (Object o : args) {
            message = message.replaceFirst("%*%", o.toString());
        }

        return message;
    }

    public static TextUtils.FormattedString formatted(String s) {
        return new TextUtils.FormattedString(s);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FormattedString {
        private String string;

        public TextUtils.FormattedString appendColor(ChatColor color) {
            this.string = color + this.string;
            return this;
        }

        public TextUtils.FormattedString replaceHolder(String holder, Object value) {
            String regex = "%" + holder + "%";
            this.string = this.string.replaceFirst(regex, value.toString());
            return this;
        }

        public TextUtils.FormattedString replaceAllHolder(String holder, Object value) {
            String regex = "%" + holder + "%";
            this.string = this.string.replaceAll(regex, value.toString());
            return this;
        }

        public TextUtils.FormattedString replaceHolders(Map<String, Object> map) {
            map.forEach((str, o) -> {
                String regex = "%" + str + "%";

                if (o instanceof List<?> list) {
                    list.forEach(o1 -> this.string = this.string.replaceFirst(regex, o1.toString()));
                }
                this.string = this.string.replaceFirst(regex, o.toString());
            });
            return this;
        }

        @Override
        public String toString() {
            return this.string;
        }
    }
}
