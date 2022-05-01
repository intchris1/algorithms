package com.algorithms.chris.additional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardsStoreTest {

    private final BoardsStore sut = new BoardsStore();

    @Test
    void store() {
        sut.store(1000, 2.5);
        assertThat(sut.pull(700)).isEqualTo(1750);
        assertThat(sut.checkFirstBatch().getAmount()).isEqualTo(300);
        sut.store(200, 2.4);
        assertThat(sut.checkFirstBatch().getAmount()).isEqualTo(200);
        sut.store(1000, 2.3);
        assertThat(sut.checkFirstBatch().getAmount()).isEqualTo(1000);
        assertThat(sut.pull(1000)).isEqualTo(2380);
        assertThat(sut.checkFirstBatch().getAmount()).isEqualTo(500);
    }

    @Test
    void store2() {
        sut.store(1000, 2.5);
        assertThat(sut.pull(1000)).isEqualTo(2500);
        assertThat(sut.checkFirstBatch()).isNull();
    }
}