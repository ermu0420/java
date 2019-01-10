package com.ermu.reflect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author：xusonglin
 * ===============================
 * Created with IDEA.
 * Date：2019/1/10
 * Time：14:17
 * ================================
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
public @interface ClassAnnotation {
}
