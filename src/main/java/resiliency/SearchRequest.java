package resiliency;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

import static resiliency.SearchRequestType.TRANSACTION;

@Getter
@Setter
public class SearchRequest {
    @Size(max = 2)
    private String testString;

//    @SearchRequestTypeSubset(anyOf = {SearchRequestType.TRANSACTION})
//    private SearchRequestType searchRequestType;
    @NotNull(message = "searchRequestType: cannot be null, provide one of these valid values [TRANSACTION]")
    @ValueOfSearchRequestType(message = "searchRequestType: provide one of these valid values [TRANSACTION]", enumClass = SearchRequestType.class)
    private String searchRequestType;
//    private Map<String, String> searchAttributes;
}
