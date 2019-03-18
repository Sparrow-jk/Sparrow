package com.sparrow.sample;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sparrow
 * @description @RestController =@Controller + @ResponseBody
 */

@RestController
public class SampleController {

    Map<String, Object> paraMap = new HashMap<>();

    @RequestMapping("/")
    public String home() {
        return "Hello World !";
    }

    @RequestMapping("/test")
    public Map<String, Object> testMap() {
        paraMap.clear();
        paraMap.put("name", "sparrow");
        return paraMap;
    }

    //@RequestMapping(value = "{city_id}/{user_id}", method = RequestMethod.GET)
    @GetMapping(value = "finduser/{city_id}/{user_id}")
    public Map<String, Object> findUser(@PathVariable("city_id") String cityId,
                                        @PathVariable("user_id") String userId) {
        paraMap.clear();
        paraMap.put("cityId", cityId);
        paraMap.put("userId", userId);
        return paraMap;
    }

    @GetMapping(value = "finduser2")
    public Map<String, Object> findUser2(@RequestParam(name = "city_id", defaultValue = "China") String cityId,
                                         @RequestParam(name = "user_id") String userId) {
        paraMap.clear();
        paraMap.put("cityId", cityId);
        paraMap.put("userId", userId);
        return paraMap;
    }

    //前端数据传过来必须是 application/json charset = utf-8
    @PostMapping("saveuser")
    public Map<String, Object> saveUser(@RequestBody User user) {
        paraMap.clear();
        paraMap.put("user", user);
        return paraMap;
    }

    @GetMapping(value = "header")
    public Map<String, Object> getheader(@RequestHeader("token") String token, String id) {
        paraMap.clear();
        paraMap.put("token", token);
        paraMap.put("id", id);
        return paraMap;
    }

    @GetMapping(value = "httpservletrequest")
    public Map<String, Object> findUser2(HttpServletRequest request) {
        paraMap.clear();
        paraMap.put("id", request.getParameter("id"));
        return paraMap;
    }

    // @ModelAttribute("user")
    public User getUser() {
        User user = new User();
        user.setId("Sparrow");
        user.setPassword("worraps");
        return user;
    }

    @GetMapping("model_attribute")
    public Object getModel(Map<String, Object> map) {
        return map.get("user");
    }


}

