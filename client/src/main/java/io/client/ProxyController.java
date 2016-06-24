package io.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Piotr on 24.06.2016.
 */

@RestController
public class ProxyController {

    @Autowired
    private ProxyService proxyService;

    @RequestMapping("/proxy")
    public String proxy() {
        return proxyService.proxy();
    }

}
