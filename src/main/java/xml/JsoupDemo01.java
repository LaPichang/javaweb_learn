package xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo01 {

    public static void main(String[] args) throws IOException {

        // 根据xml文档获取Document对象
        // 获取student.xml的path
        String path = JsoupDemo01.class.getClassLoader().getResource("student.xml").getPath();
        // 解析xml文档，加载文档进内存，获取dom树
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 获取元素对象
        Elements elements = document.getElementsByTag("name");
        // 获取name的Element对象
        Element element = elements.get(0);
        String name = element.text();
        System.out.println(name);
    }
}
