package org.swagger.dao.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "用户信息")
public class UserSchema {

    @Schema(description = "主键id",defaultValue = "1",title = "注解id-title")
    private String id;

    @Schema(description = "名称",defaultValue = "张飞")
    private String name;

    @Schema(description = "part实体信息")
    private PartSchema partSchema;

    public PartSchema getPartSchema() {
        return partSchema;
    }

    public void setPartSchema(PartSchema partSchema) {
        this.partSchema = partSchema;
    }

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