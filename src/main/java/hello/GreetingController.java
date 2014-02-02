package hello;

import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.Mongo;

@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private MongoOperations mongoOps = null;

    @RequestMapping("/greeting")
    public @ResponseBody Greeting greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        
    	
    	
    	//create an ops handle and pasd that in your saveData() and findOne() calls 
    	Greeting greet = new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    	greet.saveData(getInstance());
    	
    	

    	
        Greeting getgreet = null;
        try {
			getgreet = greet.findOne(greet.getContent(), getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return getgreet;
        
        
    }
    
    public MongoOperations getInstance(){
    	if (mongoOps == null){
    		try {
				mongoOps = new MongoTemplate(new Mongo(), "greeting");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	return mongoOps;
    		
    }
}