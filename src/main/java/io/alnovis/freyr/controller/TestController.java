package io.alnovis.freyr.controller;

import io.alnovis.freyr.dto.TestDTO;
import io.alnovis.freyr.service.SenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
public class TestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private SenderService senderService;

    @RequestMapping(value = "/test")
    public TestDTO test(@RequestParam(value="name", defaultValue="World") String name) {
        senderService.send("test", LocalDateTime.now().toString());
        return new TestDTO(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/getone")
    public TestDTO getOne() {

        return senderService.getDto();
    }

    @RequestMapping(value = "/getmany/{id}")
    public Collection<TestDTO> getMany(@RequestParam(value="size", defaultValue="0") int size,
                                       @PathVariable int id) {

        return senderService.getDtos(size);
    }

}
