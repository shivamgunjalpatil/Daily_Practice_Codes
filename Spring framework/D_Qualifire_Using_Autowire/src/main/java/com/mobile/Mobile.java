package com.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Mobile {

    @Autowired
    @Qualifier("snapdragon")
    MobileProcessor snapdragonProcessor;

    @Autowired
    @Qualifier("mediatek")
    MobileProcessor mediatekProcessor;

    public void config() {
        System.out.println("Mobile Configuration: Octa-core, 6GB RAM, 128GB Storage");

        System.out.print("Using Snapdragon:");
        snapdragonProcessor.process();

        System.out.print("Using MediaTek:");
        mediatekProcessor.process();
    }
}
