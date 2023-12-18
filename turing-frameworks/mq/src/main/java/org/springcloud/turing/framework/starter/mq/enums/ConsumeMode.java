package org.springcloud.turing.framework.starter.mq.enums;

/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2023/12/18 11:16
 */
public enum ConsumeMode {
    /**
     * CONCURRENTLY
     * 使用线程池并发消费
     */
    CONCURRENTLY("CONCURRENTLY"),
    /**
     * ORDERLY
     * 单线程消费
     */
    ORDERLY("ORDERLY");

    private String mode;

    ConsumeMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}