package org.springcloud.turing.biz.common.annotation;

import java.lang.annotation.*;

/**
 * @descri 方法功能描述注解
 *
 * @author orange
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.SOURCE)
public @interface Ability {

    String function = "";

}
