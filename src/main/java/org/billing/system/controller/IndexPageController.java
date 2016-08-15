package org.billing.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by msahel on 8/11/2016.
 */
@Controller
public class IndexPageController {

    @RequestMapping(
            value = "/",
    method = RequestMethod.GET
    )
    public String getIndexPage(){
        return "index";
    }
}
