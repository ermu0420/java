package com.ermu.reflect.entity;

import com.ermu.reflect.annotation.ClassAnnotation;
import com.ermu.reflect.annotation.FieldAnnotation;
import com.ermu.reflect.annotation.MenthodAnnotation;

/**
 * @author：xusonglin
 * ===============================
 * Created with IDEA.
 * Date：2019/1/10
 * Time：14:26
 * ================================
 */
@ClassAnnotation
public class TestEntity extends PrentEntity{
    @FieldAnnotation
    private String privateFiled;
    public String openField;
    protected String protectedField;
    String defaultField;

    private String getPrivateFiled() {
        return privateFiled;
    }

    private void setPrivateFiled(String privateFiled) {
        this.privateFiled = privateFiled;
    }

    public String getOpenField() {
        return openField;
    }

    public void setOpenField(String openField) {
        this.openField = openField;
    }

    protected String getProtectedField() {
        return protectedField;
    }

    protected void setProtectedField(String protectedField) {
        this.protectedField = protectedField;
    }

    String getDefaultField() {
        return defaultField;
    }

     void setDefaultField(String defaultField) {
        this.defaultField = defaultField;
    }

    @MenthodAnnotation
    public void sendEmail(){
        System.out.println("send email");
    }
}
