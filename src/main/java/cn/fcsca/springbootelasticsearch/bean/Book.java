package cn.fcsca.springbootelasticsearch.bean;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Book
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 下午 18:53 2018-08-25
 */
@Document(indexName = "fcscanf",type = "book")
@Data
public class Book {

    private Integer id;
    private String bookName;
    private String author;

}
