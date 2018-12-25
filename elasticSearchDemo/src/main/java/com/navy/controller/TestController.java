package com.navy.controller;

import java.io.IOException;
import java.util.Map;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	
	@Autowired
	private TransportClient transportClient;
	
    @PostMapping("/test/add")
    public Object add(@RequestBody Map<String, Object> map){
        try {
            XContentBuilder content = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("title", map.get("title"))
                    .field("author", map.get("author"))
                    .field("wordCount", map.get("wordCount"))
                    .endObject();

            IndexResponse result = this.transportClient.prepareIndex("news", "novel")
                    .setSource(content)
                    .get();
            return result;
        }catch (IOException e){
           return e;
        }
    }
}
