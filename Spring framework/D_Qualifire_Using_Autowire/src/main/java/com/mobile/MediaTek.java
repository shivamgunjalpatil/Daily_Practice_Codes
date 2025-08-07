package com.mobile;

import org.springframework.stereotype.Component;

@Component("mediatek")
public class MediaTek implements MobileProcessor {
    public void process() {
        System.out.println("MediaTek processor is power efficient");
    }
}
