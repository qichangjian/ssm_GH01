package com.qcj.controller;

import com.qcj.pojo.UserInfos;
import com.qcj.service.UserInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserInfosController {
    @Autowired
    private UserInfosService userInfosService;

    @RequestMapping("/queryAll.do")
    public String queryAll(Model model){
        model.addAttribute("users",userInfosService.queryAll());
        return "show";
    }

    @RequestMapping("/toAdd.do")
    public String toAdd(Model model){
        return "insert";//跳转到insert页面
    }

    @RequestMapping("/insert.do")
    public String insertUser(Model model, UserInfos userInfos){
        int result = userInfosService.insertUser(userInfos);
        if(result == 1){
            model.addAttribute("insertMsg","插入成功");
            return "forward:queryAll.do";//重定向到原来页面
        }else{
            model.addAttribute("insertMsg","插入失败");
            return "forward:queryAll.do";//重定向到原来页面
        }
    }

    @RequestMapping("/toUpdate.do")
    public String toUpdate(Model model, UserInfos userInfos){
        model.addAttribute("userinfos",userInfos);
        System.out.println(userInfos);
        return "update";//跳转到insert页面
    }

    @RequestMapping("/update.do")
    public String updateUser(Model model, UserInfos userInfos){
        int result = userInfosService.updateUser(userInfos);
        if(result == 1){
            model.addAttribute("updateMsg","修改成功");
            return "forward:queryAll.do";//重定向到原来页面
        }else{
            model.addAttribute("updateMsg","修改失败");
            return "forward:queryAll.do";//重定向到原来页面
        }
    }

    @RequestMapping("/delete.do")
    public String deleteUser(Model model, String uid){
        System.out.println("进入" + uid);
        int uuid = Integer.parseInt(uid);
        int result = userInfosService.deleteUser(uuid);
        if(result == 1){
            model.addAttribute("deleteMsg","删除成功");
            return "forward:queryAll.do";//重定向到原来页面
        }else{
            model.addAttribute("deleteMsg","删除失败");
            return "forward:queryAll.do";//重定向到原来页面
        }
    }


}
