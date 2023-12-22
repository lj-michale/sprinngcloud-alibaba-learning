package org.swagger.dao.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "文件part对象",description = "Part信息")
public class PartSchema {

    @Schema(description = "part部分id",defaultValue = "1")
    private String id;

    @Schema(description = "part部分名称",defaultValue = "张飞")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
