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
 * Time：14:20
 * ================================
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface  MenthodAnnotation {

}
