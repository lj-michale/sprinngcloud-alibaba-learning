package org.turing.ddd.domain.model.aggregates;


import org.turing.ddd.domain.model.vo.UserInfo;
import org.turing.ddd.domain.model.vo.UserSchool;

import java.util.List;

/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2024/1/5 17:50
 */
public class UserRichInfo {

    private UserInfo userInfo;
    private List<UserSchool> userSchoolList;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<UserSchool> getUserSchoolList() {
        return userSchoolList;
    }

    public void setUserSchoolList(List<UserSchool> userSchoolList) {
        this.userSchoolList = userSchoolList;
    }

}