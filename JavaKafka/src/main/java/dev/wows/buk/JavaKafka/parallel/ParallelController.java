package dev.wows.buk.JavaKafka.parallel;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping ("/parallel")
public class ParallelController {
    private final ParallelProducer parallelProducer;

    public ParallelController(ParallelProducer parallelProducer) {
        this.parallelProducer = parallelProducer;
    }

    @PostMapping ("/send")
    public String send(@RequestParam String event) {
        parallelProducer.sendEvent(event);
        return "Event sent: " + event;
    }
}
