package com.bee.controller;

import com.bee.common.Result;
import com.bee.common.util.JsonUtil;
import com.bee.common.util.Md5Util;
import com.bee.controller.dto.LoginVO;
import com.bee.controller.dto.UserVO;
import com.bee.domain.User;
import com.bee.repository.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Example;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * created by guos on 2018/11/10
 */
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Resource
    private UserRepository userRepository;

    @PostMapping("/login")
    public Result<Map> login(@RequestBody LoginVO loginVO, HttpServletRequest httpServletRequest) {
        User param = new User();
        param.setUsername(loginVO.getUsername());
        Example<User> example = Example.of(param);
        Optional<User> userDOOptional = userRepository.findOne(example);
        if (!userDOOptional.isPresent()) {
            throw new RuntimeException("用户不存在");
        }
        String token = Md5Util.generateRandomToken();
        httpServletRequest.getSession().setAttribute(token, userDOOptional.get());
        Map<String, Object> resultMap = new HashMap<>(1);
        resultMap.put("token", token);
        return Result.successfulResponse(resultMap);
    }

    @GetMapping("/info")
    public Result<UserVO> getUser(@RequestParam String token, HttpServletRequest request) {
        if (StringUtils.isEmpty(token)) {
            return Result.unAuthResponse();
        }
        User user = (User) request.getSession().getAttribute(token);
        List userRoles = JsonUtil.fromJsonString(user.getRoles(), List.class);
        UserVO userDTO = new UserVO();
        userDTO.setName(user.getRealname());
        userDTO.setRoles(userRoles);
        return Result.successfulResponse(userDTO);
    }


    @PostMapping("/logOut")
    public Result<Void> logOut(@RequestParam String token, HttpServletRequest request) {
        request.getSession().removeAttribute(token);
        return Result.successfulResponse();
    }
}
