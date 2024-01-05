package org.turing.ddd.domain.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.turing.ddd.application.service.UserService;
import org.turing.ddd.domain.model.aggregates.UserRichInfo;
import org.turing.ddd.domain.model.vo.UserInfo;
import org.turing.ddd.domain.model.vo.UserSchool;
import org.turing.ddd.domain.repository.IUserRepository;
import org.turing.ddd.infrastructure.po.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2024/1/5 17:52
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userRepository")
    private IUserRepository userRepository;

    @Override
    public UserRichInfo queryUserInfoById(Long id) {

        // 查询资源库
        UserEntity userEntity = userRepository.query(id);

        UserInfo userInfo = new UserInfo();
        userInfo.setName(userEntity.getName());

        // TODO 查询学校信息，外部接口
        UserSchool userSchool_01 = new UserSchool();
        userSchool_01.setSchoolName("振华高级实验中学");

        UserSchool userSchool_02 = new UserSchool();
        userSchool_02.setSchoolName("东北电力大学");

        List<UserSchool> userSchoolList = new ArrayList<>();
        userSchoolList.add(userSchool_01);
        userSchoolList.add(userSchool_02);

        UserRichInfo userRichInfo = new UserRichInfo();
        userRichInfo.setUserInfo(userInfo);
        userRichInfo.setUserSchoolList(userSchoolList);

        return userRichInfo;
    }

}