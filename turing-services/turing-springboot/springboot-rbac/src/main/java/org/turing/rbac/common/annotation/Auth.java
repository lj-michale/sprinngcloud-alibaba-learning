package org.turing.rbac.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2023/12/22 14:42
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE}) // Indicates that this annotation can be applied to both classes and methods.
public @interface Auth {

    /**
     * permission ID，unique
     */
    long id();
    /**
     * permission name
     */
    String name();

}