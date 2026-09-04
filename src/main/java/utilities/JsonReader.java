package utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonReader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode getJsonData(String relativeFilePath) {
        try {
            File file = new File(relativeFilePath);
            if (!file.exists()) {
                throw new RuntimeException("Test data file not found at: " + file.getAbsolutePath());
            }
            return objectMapper.readTree(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse JSON test data file: " + relativeFilePath);
        }
    }

    public static JsonNode getSectionData(String relativeFilePath, String nodeKey) {
        JsonNode rootNode = getJsonData(relativeFilePath);
        JsonNode section = rootNode.get(nodeKey);
        if (section == null) {
            throw medicalKeyNotFoundException(relativeFilePath, nodeKey);
        }
        return section;
    }

    public static String getStringValue(String relativeFilePath, String nodeKey, String fieldName) {
        JsonNode section = getSectionData(relativeFilePath, nodeKey);
        if (section != null && section.has(fieldName)) {
            return section.get(fieldName).asText();
        }
        throw new RuntimeException(
                "Field '" + fieldName + "' not found under section '" + nodeKey + "' in " + relativeFilePath);
    }

    private static RuntimeException medicalKeyNotFoundException(String file, String key) {
        return new RuntimeException("Key '" + key + "' was not found in JSON data file: " + file);
    }
}
