package securitytemplatetest.templatesecurity.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import securitytemplatetest.templatesecurity.security.config.feign.OAuthFeignConfig;
import securitytemplatetest.templatesecurity.security.vo.TargetCacheDTO;
import securitytemplatetest.templatesecurity.security.vo.TokenOak;

@FeignClient(name = "register-cache-client", url = "${api.client.register.cache}", configuration = OAuthFeignConfig.class)
public interface APIRegisterCache {

    @PostMapping("/testing_token")
    TokenOak createCache(@RequestHeader("id") String id,  @RequestBody TargetCacheDTO targetCacheDTO);

}
