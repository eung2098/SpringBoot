package com.example.get.controller;

import com.example.get.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") // http://localhost:9090/api/get/hello
    public String hello(){
        return "get hello";
    }

    @RequestMapping(path = "/hi",method = RequestMethod.GET) // get  http://localhost:9090/api/get/hi
    public String hi(){
        return "hi";
    }

    // http://local:9090/api/get/path-variable/{name}

//    @GetMapping("/path-variable/{name}")
//    public String pathVariable(@PathVariable String name){
//        System.out.println("PathVariable : +name");
//
//        return name;
//    }

    // http://local:9090/api/get/path-variable/{name}

//    @GetMapping("/path-variable/{id}")
//    public String pathVariable1(@PathVariable(name = "id") String pathName){
//        System.out.println("PathVariable : +pathName");
//
//        return pathName;
//    }

    // intellij 검색 주소
    //https://www.google.com/
    // search?q=intellij
    // &rlz=1C1NDCM_koKR960KR960
    // &oq=intellij
    // &aqs=chrome..69i57j69i59j0i512l8.2148j1j15
    // &sourceid=chrome
    // &ie=UTF-8
    // ? key=value&key2=value2&key3=value3

    //http://localhost:9090/api/get/query-param?user=eung2098&email=jeg8421@google.co.kr&age=27
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println(" ");

            sb.append(entry.getKey()+" = "+ entry.getValue()+" ");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }

    //UserRequest 이용
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
