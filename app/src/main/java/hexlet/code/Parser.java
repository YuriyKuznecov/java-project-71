package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String type) throws JsonProcessingException {
        ObjectMapper objectMapper;
        switch (type) {
            case "json" -> {
                objectMapper = new ObjectMapper();
                return objectMapper.readValue(content, new TypeReference<>() {
                });
            }
            case "yml", "yaml" -> {
                objectMapper = new YAMLMapper();
                return objectMapper.readValue(content, new TypeReference<>() {
                });
            }
            default -> throw new RuntimeException("Unsupported type");
        }
    }
}
