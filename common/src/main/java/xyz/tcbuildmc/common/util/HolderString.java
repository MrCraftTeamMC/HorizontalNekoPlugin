package xyz.tcbuildmc.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolderString {
    private String string;

    public HolderString replaceHolder(String holder, Object value) {
        String regex = "%" + holder + "%";
        this.string = this.string.replaceFirst(regex, value.toString());
        return this;
    }

    public HolderString replaceAllHolder(String holder, Object value) {
        String regex = "%" + holder + "%";
        this.string = this.string.replaceAll(regex, value.toString());
        return this;
    }

    public HolderString replaceHolders(Map<String, Object> map) {
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
