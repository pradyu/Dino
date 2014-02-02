package hello;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.Mongo;

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    
    @Override
    public String toString() {
      return "Greeting [id=" + id + ", content=" + content + "]";
    }
    
    public void saveData(MongoOperations mongoOps) {
    	//pass handle to ops in call
		mongoOps.insert(this);
    }
    
    public Greeting findOne(String content, MongoOperations mongoOps) throws Exception{
    	Query qry = new Query();
    	
    	//pass handle to ops in call
    	qry.addCriteria(Criteria.where("content").is(content));
    	Greeting greet = mongoOps.findOne(qry, Greeting.class);
    	return greet;
    }
}
