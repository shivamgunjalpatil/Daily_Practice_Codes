package com.mobile;

import org.springframework.stereotype.Component;

@Component("snapdragon")
public class Snapdragon implements MobileProcessor {
    public void process() {
        System.out.println("Snapdragon processor is fast");
    }
}
