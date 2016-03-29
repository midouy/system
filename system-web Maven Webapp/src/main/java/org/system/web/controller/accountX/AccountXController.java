package org.system.web.controller.accountX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.system.service.accountX.AccountXService;

/**
 * Created by Midouy on 2016/3/28.
 */
@Controller
@RequestMapping("/accountX")
public class AccountXController {

    @Autowired
    private AccountXService accountXService;

    @RequestMapping("/index")
    public String index(){
        return "accountX/index";
    }

}
