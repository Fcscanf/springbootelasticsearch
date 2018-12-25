package cn.fcsca.springbootelasticsearch.repository;

import cn.fcsca.springbootelasticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * BookRepository
 * SpringBoot-data操作Elasticsearch，Repository库传入对象和主键的类型<Book,Integer>
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 下午 19:00 2018-08-25
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
    
    /**
     * 自定义操作方法 
     *
     * @param bookName
     * @return 
     * @author Fcscanf@樊乘乘
     * @date 下午 19:54 2018-08-25 
     */
    public List<Book> findByBookNameLike(String bookName);
}
