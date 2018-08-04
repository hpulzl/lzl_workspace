package com.hpu.lzl.es;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

/**
*   
* @author:awo  
* @time:2018/7/15  下午6:55 
* @Description: 索引、查询、聚合
**/
@Repository
public class BookElasticsearchRepository {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public void addBook(Integer id,String type){
        String json = "{\"id\" : \"WX_001\",\"name\" : \"人生\",\"type\" : \"文学\"}";

//        IndexQuery indexQuery = new IndexQueryBuilder().withIndexName("book_index")
//                .withType("book_type").withId(id).withObject(json).build();

//        elasticsearchTemplate.index(indexQuery);
    }

    public String getBook(String id){
//        QueryBuilder queryBuilder =
//        SearchQuery searchQuery = new NativeSearchQuery()
        return null;
    }
}
