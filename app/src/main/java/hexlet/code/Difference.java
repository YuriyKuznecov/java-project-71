package hexlet.code;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class Difference {
    private String change;
    private String key;
    private Object oldValue;
    private Object newValue;
}
