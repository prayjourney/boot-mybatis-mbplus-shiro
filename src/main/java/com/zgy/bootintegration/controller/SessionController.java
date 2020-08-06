package com.zgy.bootintegration.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author renjiaxin
 * @Date 2020/8/6
 * @Description
 */
@Controller
@RequestMapping("session")
@Slf4j
public class SessionController {
    /**
     * 创建session
     *
     * @param request
     * @return str
     */
    @GetMapping("create")
    @ResponseBody
    public String createSession(HttpServletRequest request) {
        log.info("如果是第一次请求，那就创建session");
        // true表示如果这个HTTP请求中有session，则直接通过getSession获取当前的session，若没有session，则会自动新建一个session
        HttpSession session = request.getSession(true);
        // false表示只能获取当前请求中的session，如果没有也不能自动创建。
        // HttpSession session=request.getSession(false);

        session.setAttribute("username","TOM");
        session.setAttribute("password","tommmm");
        return "已经创建好了session, 给前端返回了session id";
    }


    /**
     * 创建session, 并且给前端返回sessionID
     *
     * @param request
     * @return str
     */
    @GetMapping("create2browser")
    @ResponseBody
    public String createSession2Browser(HttpServletRequest request, HttpServletResponse response) {
        log.info("如果是第一次请求，那就创建session");
        // true表示如果这个HTTP请求中有session，则直接通过getSession获取当前的session，若没有session，则会自动新建一个session
        HttpSession session = request.getSession(true);
        // false表示只能获取当前请求中的session，如果没有也不能自动创建。
        // HttpSession session=request.getSession(false);

        session.setAttribute("username","TOM");
        session.setAttribute("password","tommmm");
        Cookie c1 = new Cookie("name", "zhangsan");
        response.addCookie(c1);
        return "已经创建好了session, 给前端返回了session id, cookie值，请通过F12在network之中查看";
    }


    /**
     * 获取session, 查看sessionid和前端返回的是否一致
     *
     * @param request
     * @return str
     */
    @GetMapping("get")
    @ResponseBody
    public String getSession(HttpServletRequest request) {
        log.info("如果是第一次请求，那就创建session");
        // false表示只能获取当前请求中的session，如果没有也不能自动创建, 当没有持久化的时候，就会为null
        HttpSession session=request.getSession(false);
        if(null != session){
            String sessionId = session.getId();
            String userName = session.getAttribute("username").toString();
            log.info("从session之中获取sessionId:" + sessionId);
            log.info("从session之中获取userName:" + userName);

            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                String name = cookies[i].getName();
                String value = cookies[i].getValue();
                log.info("从cookie之中获取key：" + name);
                log.info("从cookie之中获取value:" + value);
                if (sessionId.equals(value)){
                    log.info("前端传来的sessionID和后端的sessionID相等!" + sessionId + "," + value);
                }
            }
            return "已经创建好了session, 给前端返回了session id, cookie值，请通过F12在network之中查看";
        }else {
            return "session为空！";
        }
    }


}