package hexlet.code;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder

public class Difference {
    private String change;
    private String key;
    private Object oldValue;
    private Object newValue;
}
