package securitytemplatetest.templatesecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import securitytemplatetest.templatesecurity.rest.client.APIRegisterCache;
import securitytemplatetest.templatesecurity.security.vo.TargetCacheDTO;
import securitytemplatetest.templatesecurity.security.vo.TokenOak;

import java.util.Random;
import java.util.UUID;

@Service
public class OakTokenManagerService {

    @Autowired
    private APIRegisterCache apiRegisterCache;

    public TokenOak accessCache(){
        final TargetCacheDTO targetCacheDTO = new TargetCacheDTO(UUID.randomUUID().toString(), String.valueOf(new Random().nextFloat()));
        return apiRegisterCache.createCache(String.valueOf(new Random().nextInt()), targetCacheDTO);
    }


}
