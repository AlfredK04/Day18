package dev.wows.buk.JavaKafka.fanout;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping ("/fanout")
public class FanoutController {


    private final FanoutProducer fanoutProducer;

    public FanoutController(FanoutProducer fanoutProducer) {
        this.fanoutProducer = fanoutProducer;
    }

    @PostMapping ("/send")
    public String send(@RequestParam String event) {
        fanoutProducer.sendEvent(event);
        return "Event sent: " + event;
    }
}
