package com.laine.casimir.tetris.swing;

public final class SwingTetrisSettings {

    public static final int DEFAULT_NEXT_QUEUE_COUNT = 3;

    private int nextQueueCount = DEFAULT_NEXT_QUEUE_COUNT;

    public int getNextQueueCount() {
        return nextQueueCount;
    }

    public void setNextQueueCount(int nextQueueCount) {
        this.nextQueueCount = Math.max(1, Math.min(nextQueueCount, 6));
    }
}
