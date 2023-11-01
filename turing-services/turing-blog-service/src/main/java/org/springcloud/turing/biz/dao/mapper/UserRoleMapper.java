package org.springcloud.turing.biz.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springcloud.turing.biz.dao.entity.UserRoleDO;

import java.util.List;

/**
 * @descr 用户角色信息持久层
 *
 */
@Mapper
public interface UserRoleMapper  extends BaseMapper<UserRoleDO> {

    /**
     * 根据用户id查询角色id
     *
     * @param userId 用户id
     * @return 角色id
     */
    List<String> selectRoleIdByUserId(@Param("userId") Integer userId);

    /**
     * 添加用户角色
     *
     * @param userId     用户id
     * @param roleIdList 角色id集合
     */
    void insertUserRole(@Param("userId") Integer userId, @Param("roleIdList") List<String> roleIdList);

}
