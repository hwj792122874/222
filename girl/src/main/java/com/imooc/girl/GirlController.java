package com.imooc.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    /*
    * 查询所有女生列表
    * */
    @GetMapping("/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }
    /*
    * 添加一个女生
    * */
    @GetMapping(value = "/girls1")
    public Girl girlAdd(@RequestParam("age")Integer age,@RequestParam("cupSize") String cupSize){
        Girl girl=new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }
    //查询一个女生
    @GetMapping("/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
     return girlRepository.findById(id).orElse(null);
    }
    //更新
    @PutMapping("/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @PathVariable("cupSize") String cupSize,
                           @PathVariable("age") Integer age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);

    }
    @DeleteMapping("/girls/{id}")
    public void GirlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }
    //通过年龄查询女生列表
    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
       return girlRepository.findByAge(age);
    }
    @GetMapping("/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }
}
