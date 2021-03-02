package com.sunflower;

import com.sunflower.proxy.Factory;

public class NikeFactory implements Factory {
    @Override
    public void Production() {
        System.out.println("生产一批Aj1");
    }
}
