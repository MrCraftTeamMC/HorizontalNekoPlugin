package xyz.tcbuildmc.common.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.Getter;
import org.apache.commons.io.IOUtils;
import xyz.tcbuildmc.common.annotations.Testing;
import xyz.tcbuildmc.minecraft.hnp.common.util.Constants;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Testing
public abstract class UpdateChecker {
    @Getter
    private final String version;
    @Getter
    private final String url;
    private final ObjectMapper mapper = new JsonMapper();

    public UpdateChecker(String version, String url) {
        this.version = version;
        this.url = url;
    }

    public boolean checkLatest() throws IOException {
        String s = IOUtils.toString(new URL(url), StandardCharsets.UTF_8);
        Map<String, ?> map = this.mapper.readValue(s, new TypeReference<>() {});

        String latest = (String) map.get("latest");
        for (Map<String, ?> ver : (List<Map<String, ?>>) map.get("versions")) {
            if (ver.get("id").equals(latest) && ver.get("id").equals(Constants.VERSION)) {
                return true;
            }
        }

        return false;
    }
}
