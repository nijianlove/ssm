package com.itcast.controller;

import com.itcast.domain.PageBean;
import com.itcast.domain.User;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    //设置允许上传的文件类型
    private String[] allowType = {"image/jpeg", "image/png"};

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User users, HttpSession session, Integer ck, HttpServletResponse response) throws Exception {
        User user = userService.login(users);
        if (user != null) {
            Cookie cookieName = new Cookie("username",user.getUsername());
            Cookie cookiePassword = new Cookie("password",user.getPassword());

            if(ck!=null&&ck==1){
            cookieName.setMaxAge(7*24*60*60);
            cookiePassword.setMaxAge(7*24*60*60);
        }else {
                cookieName.setMaxAge(0);
                cookiePassword.setMaxAge(0);
            }

            cookieName.setPath("/");
            cookiePassword.setPath("/");

            response.addCookie(cookieName);
            response.addCookie(cookiePassword);

            session.setAttribute("user",user);
            return "index1";
        } else {
            return "loginError";
        }
    }

    @RequestMapping("/findAll")
    public String findAll(
            User user,
            Model model,
            @RequestParam(name="currentPage",required = false,defaultValue = "1") Integer currentPage,
            @RequestParam(name="rows",required = false,defaultValue = "4")Integer rows
    ) throws Exception {

        PageBean pageBean = new PageBean();
        pageBean.setUser(user);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        Integer counts = userService.findCounts(pageBean);
        pageBean.setCounts(counts);
        System.out.println(counts);
        pageBean.setStartPage((currentPage-1)*rows);
        pageBean.setTotalPages((int)Math.ceil((counts*1.0)/rows));
        List<User> users = userService.findAll(pageBean);
        model.addAttribute("userList", users);
        model.addAttribute("pageBean",pageBean);
        return "list";
    }

    @RequestMapping("/saveUser")
    public String saveUser(HttpServletRequest req, MultipartFile picName, User user) throws Exception {
        if (!Arrays.asList(allowType).contains(picName.getContentType())) {
            throw new RuntimeException("你上传的文档类型不符合要求");
        }
        String path = req.getSession().getServletContext().getRealPath("/pics/");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = picName.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid+"_"+fileName;
        picName.transferTo(new File(path, fileName));
        user.setPic("/pics/"+fileName);
        userService.saveUser(user);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/findById")
    public String findById(Integer id,Model model) throws Exception{
       User user = userService.findById(id);
       model.addAttribute("user",user);
       return "update";
    }

    @RequestMapping("/findByIds")
    public String findByIds(Integer id,Model model) throws Exception{
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "detail";
    }

    @RequestMapping("/updateUser")
    public String updateUser(HttpServletRequest req, MultipartFile picName, User user) throws Exception{
        if (!Arrays.asList(allowType).contains(picName.getContentType())) {
            throw new RuntimeException("你上传的文档类型不符合要求");
        }
        String path = req.getSession().getServletContext().getRealPath("/pics/");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = picName.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid+"_"+fileName;
        picName.transferTo(new File(path, fileName));
        user.setPic("/pics/"+fileName);
        userService.updateUser(user);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/deleteById")
    public String deleteById(Integer id) throws Exception{
        userService.deleteById(id);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/deleteByIds")
    public String deleteByIds(HttpServletRequest request) throws Exception{
        String[] id = request.getParameterValues("cb");
        Integer[] ids = new Integer[id.length];
        for (int i = 0; i < id.length; i++) {
            ids[i]=Integer.parseInt(id[i]);
        }
        userService.deleteByIds(ids);
        return "redirect:/user/findAll";
    }


}
