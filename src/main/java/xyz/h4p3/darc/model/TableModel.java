package xyz.h4p3.darc.model;

import lombok.Data;
import xyz.h4p3.darc.util.FreeMakerUtil;
import xyz.h4p3.darc.util.JdbcUtil;

import java.util.Set;

/**
 * @author neal.armstrong
 * @version 1.0
 * @since 2022-04-12
 */
@Data
public class TableModel {
    private String name;
    private String desc;
    private String engine;
    private String charset;
    private String sort;
    private Set<FieldModel> fields;
    private Set<IndexModel> indexes;

    private static final String URL = "jdbc:mysql://xx.xxx.x.xx:3306/table?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT&allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PWD = "xxxxxx";

    public void generate() {
        String sql = FreeMakerUtil.generate("table.ftl", this);
        JdbcUtil.execute(sql, URL, USER, PWD);
    }
}
