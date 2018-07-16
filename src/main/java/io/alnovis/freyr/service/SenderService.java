package io.alnovis.freyr.service;

import io.alnovis.freyr.dto.TestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class SenderService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    /**
     *
     * @param topic sdasd
     * @param payload sdasdasd
     */
    public void send(String topic, String payload) {
        log.info("sending payload='{}' to topic='{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
        //kafkaTemplate.se
    }

    public TestDTO getDto() {

        TestDTO dto = new TestDTO(10L, "sadas");
        return dto;
    }

    public Collection<TestDTO> getDtos(int size) {

        List<TestDTO> list = new LinkedList<>();
        for (long i = 0; i < size; i++) {
            Long l = new Long(i);
            list.add(new TestDTO(
                    l,
                    l.toString()
            ));

        }
        return list;
    }
}
