package org.turing.designpattern.service.abstractfactory.v2.factory.impl;

import org.turing.designpattern.service.abstractfactory.matter.EGM;
import org.turing.designpattern.service.abstractfactory.v2.factory.ICacheAdapter;

import java.util.concurrent.TimeUnit;

public class EGMCacheAdapter implements ICacheAdapter {

    private EGM egm = new EGM();

    public String get(String key) {
        return egm.gain(key);
    }

    public void set(String key, String value) {
        egm.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        egm.delete(key);
    }
}