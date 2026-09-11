package dev.wows.buk.JavaKafka.plain;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class PlainController {
    private final PlainProducer plainProducer;

    public PlainController(PlainProducer plainProducer) {
        this.plainProducer = plainProducer;
    }

    @PostMapping ("/plain/send")
    public String send(@RequestParam String event) {
        plainProducer.sendEvent(event);
        return "Event sent: " + event;
    }
}
