package securitytemplatetest.templatesecurity.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import securitytemplatetest.templatesecurity.security.vo.TokenOak;
import securitytemplatetest.templatesecurity.service.OakTokenManagerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/security/auth/test")
public class GenerateController {

    @Autowired
    private OakTokenManagerService oakTokenManagerService;

    @PostMapping("/generate")
    public ResponseEntity<TokenOak> generateToken(@RequestHeader("id") String id){
        List<Integer> test = new ArrayList<>();
        for(int i = 0; i< 30 ; i++){
            test.add(i);
        }
        ForkJoinPool forkJoinPool =  new ForkJoinPool(20);

        forkJoinPool.submit(()-> test.stream().parallel().forEach(a-> oakTokenManagerService.accessCache())).join();

        return ResponseEntity.ok(oakTokenManagerService.accessCache());

    }

}
