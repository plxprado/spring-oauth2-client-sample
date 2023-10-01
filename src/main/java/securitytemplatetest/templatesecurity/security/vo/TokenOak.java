package securitytemplatetest.templatesecurity.security.vo;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class TokenOak {

    private String id;
    private String payload;
}
