package xyz.h4p3.darc.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @author neal.armstrong
 * @version 1.0
 * @since 2022-04-12
 */
public class FreeMakerUtil {

    public static String generate(String templateName, Object data) {
        // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setClassForTemplateLoading(FreeMakerUtil.class, "/templates");
        configuration.setDefaultEncoding("utf-8");
        Template template;
        StringWriter stringWriter = new StringWriter();
        try {
            template = configuration.getTemplate(templateName);
            template.process(data, stringWriter);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }
}
