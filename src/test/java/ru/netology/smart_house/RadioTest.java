package ru.netology.smart_house;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio sven = new Radio();

    @Test
    void shouldIncreaseVolume() {
        sven.increaseVolume();
        int volume = sven.getCurrentVolume();
        int expected = 1;
        assertEquals(expected, volume);
    }

    @Test
    void shouldMaxVolume() {
        int maxVolume = sven.getMaxVolume();
        sven.setCurrentVolume(maxVolume);
        sven.increaseVolume();
        int currentVolume = sven.getCurrentVolume();
        assertEquals(maxVolume, currentVolume);
    }

    @Test
    void shouldMinVolume() {
        int minVolume = sven.getMinVolume();
        sven.decreaseVolume();
        int currentVolume = sven.getCurrentVolume();
        assertEquals(minVolume, currentVolume);
    }

    @Test
    void shouldDecreaseVolume() {
        int currentVolume = 8;
        sven.setCurrentVolume(currentVolume);
        sven.decreaseVolume();
        int newVolume = sven.getCurrentVolume();
        int expected = currentVolume - 1;
        assertEquals(expected, newVolume);
    }

    @Test
    void shouldIncreaseStation() {
        sven.increaseStation();
        int station = sven.getCurrentStation();
        int expected = 1;
        assertEquals(expected, station);
    }

    @Test
    void shouldMaxStation() {
        int maxStation = sven.getMaxStation();
        sven.setCurrentStation(maxStation);
        sven.increaseStation();
        int currentStation = sven.getCurrentStation();
        int minStation = sven.getMinStation();
        assertEquals(minStation, currentStation);
    }

    @Test
    void shouldMinStation() {
        int maxStation = sven.getMaxStation();
        sven.decreaseStation();
        int currentStation = sven.getCurrentStation();
        assertEquals(maxStation, currentStation);
    }

    @Test
    void shouldDecreaseStation() {
        int currentStation = 6;
        sven.setCurrentStation(currentStation);
        sven.decreaseStation();
        int newStation = sven.getCurrentStation();
        int expected = currentStation - 1;
        assertEquals(expected, newStation);
    }
}