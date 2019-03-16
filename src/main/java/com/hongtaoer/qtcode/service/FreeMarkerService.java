package com.hongtaoer.qtcode.service;

/**
 * 测试FreeMarker生成HTML模板
 *
 * @author LiangGzone
 * @version 2014-01-08
 */

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class FreeMarkerService {


    public static final String ftlQtcodePath = "/usr/local/qtcode/config/qt.ftl";

    public static final String qtCodeResult = "/usr/local/tomcat/webapps/qtcode/result/";


    public void createHTML(ContentBean contentBean) {

        HashMap<String, ContentBean> map = new HashMap<>();
        map.put("content", contentBean);
        createHTMLFile(ftlQtcodePath, qtCodeResult + contentBean.getCheckNumber() + ".html", map);

    }

    /**
     * 根据ftl模板文件,生成静态HTML文件
     *
     * @param ftlPath  FTL模板文件路径,例如["c:/liang/template.ftl"]
     * @param filePath 生成HMTL文件路径，例如["d:/liang/lianggzone.html"]
     * @param data     Map数据
     * @return
     */
    private boolean createHTMLFile(String ftlPath, String filePath, Map data) {
        Writer out = null;
        //获取HMTL文件目录
        String fileDirectory = StringUtils.substringBeforeLast(filePath, "/");
        //获取HMTL文件名
        String fileName = StringUtils.substringAfterLast(filePath, "/");
        //获取HMTL文件目录
        String ftlDirectory = StringUtils.substringBeforeLast(ftlPath, "/");
        //获取HMTL文件名
        String ftlName = StringUtils.substringAfterLast(ftlPath, "/");
        try {
            //文件递归创建生成文件目录
            File realDirectory = new File(fileDirectory);
            if (!realDirectory.exists()) {
                realDirectory.mkdirs();
            }
            //step1 获取freemarker的配置
            Configuration freemarkerCfg = new Configuration(Configuration.VERSION_2_3_23);
            //step2 设置freemarker模板所放置的位置(文件夹)
            freemarkerCfg.setDirectoryForTemplateLoading(new File(ftlDirectory));
            //step3 设置freemarker模板编码
            freemarkerCfg.setDefaultEncoding("UTF-8");
            freemarkerCfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            //step4 找到对应freemarker模板并实例化
            Template template = freemarkerCfg.getTemplate(ftlName);
            //step5 初始化一个IO流
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(filePath)), "UTF-8"));
            //step6 模板渲染出所要的内容
            template.process(data, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        FreeMarkerService test = new FreeMarkerService();
        ContentBean content = new ContentBean();
        content.setCheckNumber("123123123210998777");
        content.setYear("2017");
        content.setNumber("123");
        Map map = new HashMap();

        map.put("content", content);
        String filePath = System.getProperty("user.dir") + "/result/" + "1111.html";
        String ftlPath = FreeMarkerService.class.getResource("/").getPath() + "/public/" + "qt.ftl";
        String ftlPath3 = FreeMarkerService.class.getResource("/").getPath() + "";
        System.out.println(ftlPath3);


        boolean flag = test.createHTMLFile(ftlPath, filePath, map);
    }
}
