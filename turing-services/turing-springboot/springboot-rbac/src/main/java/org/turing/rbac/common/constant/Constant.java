package org.turing.rbac.common.constant;

/**
 * 常量接口
 */
public interface Constant {

    /**
     * 系统异常码：数据校验不通过
     */
    Integer PARAM_CHECKED_ERROR = 4000001;

    /**
     * MD5 加密的盐
     */
    String MD5_SALT = "RBAC";

    /**
     * 默认登录密码
     */
    String DEFAULT_PASSWORD = "123456";

    /**
     * 保存上传文件的文件夹
     */
    String UPLOAD_FOLDER = "upload";

    /**
     * 权限类型 菜单 1
     */
    Integer PERMISSION_TYPE_MENU = 1;

    /**
     * 权限类型 按钮 2
     */
    Integer PERMISSION_TYPE_BTN = 2;

    /**
     * 一级菜单
     */
    Integer MENU_LV1 = 0;
}
