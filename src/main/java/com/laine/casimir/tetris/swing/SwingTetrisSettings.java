package com.laine.casimir.tetris.swing;

public final class SwingTetrisSettings {

    public static final int NEXT_QUEUE_COUNT_MIN = 1;
    public static final int NEXT_QUEUE_COUNT_MAX = 6;
    public static final int NEXT_QUEUE_COUNT_DEFAULT = 3;

    private int nextQueueCount = NEXT_QUEUE_COUNT_DEFAULT;

    public int getNextQueueCount() {
        return nextQueueCount;
    }

    public void setNextQueueCount(int nextQueueCount) {
        this.nextQueueCount = Math.max(NEXT_QUEUE_COUNT_MIN, Math.min(nextQueueCount, NEXT_QUEUE_COUNT_MAX));
    }
}
