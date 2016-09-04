package org.billing.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by msahel on 8/15/2016.
 */
@Controller
public class LayoutController {

    @RequestMapping("product/layout")
    public String getProductLayoutPage(){return "product/layout";}

    @RequestMapping("products/layout")
    public String getAllProductLayoutPage(){return "products/layout";}

    @RequestMapping("bill/layout")
    public String getBillingLayoutPage(){return "bill/layout";}


}
