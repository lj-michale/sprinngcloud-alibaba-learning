package org.swagger.dao.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MapEnumUser {

    @Schema(description = "姓名",allowableValues = "张飞,关羽,赵云")
    private String name;

    @Schema(description = "枚举类型")
    private CourseType courseType;
}