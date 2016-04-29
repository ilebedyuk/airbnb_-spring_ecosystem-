//package org.airbnb.conf;
//
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//
///**
// * @author ilebedyuk
// */
//@Configuration
//public class MongoConf {
//    @Value("${mongo.db}")
//    String mongoDB;
//
//    @Value("${mongo.uri}")
//    String mongoURI;
//
//    @Bean
//    public MongoDbFactory mongoDbFactory() throws Exception {
//        MongoClientURI mongoClientURI = new MongoClientURI(mongoURI);
//        return new SimpleMongoDbFactory(new MongoClient(mongoClientURI), mongoDB);
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
//        return mongoTemplate;
//    }
//}
