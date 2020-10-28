package resiliency;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum SearchRequestType {
    TRANSACTION("transaction");
    private String value;
    private SearchRequestType(String value) {
        this.value=value;
    }
}
