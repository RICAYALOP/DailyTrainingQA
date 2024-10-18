package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.EnvData;

import java.io.File;
import java.io.IOException;

public class SettingsTestData {

    private static EnvData envData;

    public static EnvData loadEnvData(String envName) throws IOException {
        if (envData == null) {
            ObjectMapper mapper = new ObjectMapper();
            envData = mapper.readValue(new File("src/test/resources/environment/" + envName + ".json"), EnvData.class);
        }
        return envData;
    }
}
