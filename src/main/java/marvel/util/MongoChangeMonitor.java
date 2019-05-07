//package marvel.util;
//
//import com.mongodb.BasicDBObject;
//import com.mongodb.CursorType;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoCursor;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.concurrent.ExecutorService;
//import marvel.model.Change;
//import marvel.model.Change.ChangeType;
//import marvel.repository.CharacterRepository;
//import marvel.repository.MarvelDocument;
//import marvel.service.ParameterAware;
//import org.bson.Document;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.mongodb.core.CollectionOptions;
//import org.springframework.data.mongodb.core.DocumentCallbackHandler;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.index.Index;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MongoChangeMonitor implements ParameterAware, Runnable {
//
//  private final Date start = new Date();
//  private final static String SEED = "seed";
//  private boolean isRunning;
//
//  @Autowired
//  CharacterRepository characterRepository;
//
//  @Autowired
//  MongoTemplate mongoTemplate;
//
//  @Autowired
//  ExecutorService executorService;
//
//  MongoCursor cursor;
//
//  private void initCursor() {
//    return;
//  }
//
//  public void run() {
//    if (!mongoTemplate.collectionExists(Change.COLLECTION)) {
//      mongoTemplate.createCollection(Change.COLLECTION, CollectionOptions.empty().capped().size(100000).maxDocuments(5000));
//    }
//
//    // Add a minimum of one record
//    mongoTemplate.save(new Change(SEED, Change.ChangeType.ADDED, getGenericType().getSimpleName()));
//
//    // define the monitored collection
//    MongoCollection monitoredCollection = mongoTemplate.getCollection(Change.COLLECTION);
//
//    mongoTemplate.indexOps(Change.COLLECTION).ensureIndex(new Index().on(Change.MODIFIED,
//        Direction.ASC));
//
//    BasicDBObject query = new BasicDBObject();
//    query.put(Change.MODIFIED, new BasicDBObject("$gte", start));
//    query.put(Change.CLASS, getGenericType().getSimpleName());
//
//    MongoCursor<Document> cursor = monitoredCollection.find(query).sort(new Document("natural", 1)).cursorType(
//        CursorType.Tailable).iterator();
//
////    while (cursor.hasNext() && isRunning) {
////      Change change = mongoTemplate.getConverter().read(Change.class, cursor.hasNext());
////      if(null != change) {
////        for (ChangeHander handler : handlers) {
////          handler.handleChange(change);
////        }
////      }
////    }
//
//    cursor.close();
//  }
//}
