package cn.fcsca.springbootelasticsearch.bean;

import io.searchbox.annotations.JestId;
import lombok.Data;

/**
 * Article
 * @JestId 使用Jest模板需要指明其主键
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 下午 16:12 2018-08-25
 */
@Data
public class Article {

    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;
}
