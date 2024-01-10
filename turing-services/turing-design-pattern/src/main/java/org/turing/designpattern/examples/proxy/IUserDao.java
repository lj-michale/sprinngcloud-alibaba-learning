package org.turing.designpattern.examples.proxy;

import org.turing.designpattern.examples.proxy.agent.Select;

public interface IUserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);

}