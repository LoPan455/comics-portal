package marvel.util;

import com.mongodb.BasicDBObject;
import com.mongodb.CursorType;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import marvel.model.Change;
import marvel.model.Change.ChangeType;
import marvel.model.Character;
import marvel.repository.CharacterRepository;
import marvel.repository.MarvelDocument;
import marvel.service.ParameterAware;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.DocumentCallbackHandler;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Component;

@Component
public class CharacterChangeMonitor implements ParameterAware, Runnable {

  private boolean isRunning;

  @Autowired
  CharacterRepository characterRepository;

  @Autowired
  MongoTemplate mongoTemplate;

  ExecutorService executorService;

  MongoCursor cursor;

  private void initCursor() {
  }

  public void register() {
    if (!isRunning) {
      isRunning = true;
      executorService.submit(this::run);
    }
  }

  public void run() {
    if (!mongoTemplate.collectionExists(Character.COLLECTION)) {
      mongoTemplate.createCollection(Character.COLLECTION, CollectionOptions.empty().capped().size(100000).maxDocuments(5000));
    }
    // define the monitored collection
    MongoCollection monitoredCollection = mongoTemplate.getCollection(Character.COLLECTION);

    BasicDBObject query = new BasicDBObject();


    MongoCursor<Document> cursor = monitoredCollection.find(query).cursorType(CursorType.Tailable).iterator();

    while (cursor.hasNext() && isRunning) {
      System.out.println("The cursor picked something up!");
    }

    cursor.close();
  }
}

