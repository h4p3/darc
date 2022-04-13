package xyz.h4p3.darc.model;

import java.util.Set;

/**
 * @author neal.armstrong
 * @version 1.0
 * @since 2022-04-12
 */
public class IndexModel {
    private String name;
    private Set<String> fields;
    private String type;
    private String method;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getFields() {
        return fields;
    }

    public void setFields(Set<String> fields) {
        this.fields = fields;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
