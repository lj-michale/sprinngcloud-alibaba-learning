package org.turing.ddd.infrastructure.po;


/**
 * @descri: 数据库实体对象；用户实体
 *
 * @author: lj.michale
 * @date: 2024/1/5 17:54
 */
public class UserEntity {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}