package com.sda.spring.notepad;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class Censore {
    private Map<String, String> blacklist = new HashMap<>();

    @PostConstruct
    public void init() {
        blacklist.put("twoja stara", "twoja szanowna mamusia");
        blacklist.put("wypierdzielaj", "zapraszam wypierdalac");
    }

    public Note censore(Note note) {
        String content = note.getContent();

        for (String key : blacklist.keySet()) {
            String censoredContent = content.replaceAll(key, blacklist.get(key));
            content = censoredContent;
        }

        note.setContent(content);
        return note;
    }

}
