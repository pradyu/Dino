package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    /*private MongoOperations mongoOps = null;*/
    @Autowired
    private GreetingRepository repository;

    @RequestMapping("/greeting")
    public @ResponseBody Greeting greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	Greeting greet = new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    	repository.save(greet);   
        return repository.findByContent(greet.getContent()).get(0);
    }
}   