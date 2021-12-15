package com.example;

import org.springframework.stereotype.Component;

// because java can't convert if first and second letter of the class are uppercase it can't automatically pick a name
// for the bean in this case (RE being uppercase). So we need to put a specific name for that bean.
@Component("restFortune")
public class RESTFortuneService implements FortuneService {


    @Override
    public String getFortune() {
        return null;
    }

}
