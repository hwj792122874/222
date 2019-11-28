package com.imooc.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    //@RequestMapping(value = "/hello",method = RequestMethod.GET)
    @GetMapping("/hello")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myid){

        return "id:"+myid;
    }
}
