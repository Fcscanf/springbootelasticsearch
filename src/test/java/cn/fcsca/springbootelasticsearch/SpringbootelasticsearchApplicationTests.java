package cn.fcsca.springbootelasticsearch;

import cn.fcsca.springbootelasticsearch.bean.Article;
import cn.fcsca.springbootelasticsearch.bean.Book;
import cn.fcsca.springbootelasticsearch.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootelasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void springBootDataElasticsearch() {
        Book book = new Book();
        book.setId(1);
        book.setBookName("西游记");
        book.setAuthor("吴承恩");
        bookRepository.index(book);
    }

    @Test
    public void springBootDataElasticsearchByBookName() {
        for (Book book : bookRepository.findByBookNameLike("游")) {
            System.out.println(book);
        }
    }

    @Test
    public void contextLoadsJest() {
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("Fcscanf");
        article.setContent("HelloWorld");

        //构建一个索引功能
        Index index = new Index.Builder(article).index("fcscanf").type("news").build();

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchJest() {
        //构建查询表达式
        String json = "{\n" +
                "     \"query\" : {\n" +
                "         \"match\" : {\n" +
                "             \"content\" : \"hello\"\n" +
                "         }\n" +
                "     }\n" +
                "}";
        //构建搜索操作
        Search build = new Search.Builder(json).addIndex("fcscanf").addType("news").build();
        //执行
        try {
            SearchResult result = jestClient.execute(build);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
