package ru.netology.smart_house;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio sven = new Radio();

    @ParameterizedTest
    @CsvSource({"under min station, -1, 0",
                "equally min station, 0, 0",
                "over max station, 12, 9",
                "equally max station, 9, 9",
                "station in range, 5, 5"})
    void shouldRadioSetStation(String test, int numberStation, int expected) {
        sven.setCurrentStation(numberStation);
        int actual = sven.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldRadioIncreaseStation() {
        sven.increaseStation();
        int station = sven.getCurrentStation();
        int expected = 1;
        assertEquals(expected, station);
    }

    @Test
    void shouldRadioMaxStation() {
        int maxStation = sven.getMaxStation();
        sven.setCurrentStation(maxStation);
        sven.increaseStation();
        int currentStation = sven.getCurrentStation();
        int minStation = sven.getMinStation();
        assertEquals(minStation, currentStation);
    }

    @Test
    void shouldRadioMinStation() {
        int maxStation = sven.getMaxStation();
        sven.decreaseStation();
        int currentStation = sven.getCurrentStation();
        assertEquals(maxStation, currentStation);
    }

    @Test
    void shouldRadioDecreaseStation() {
        int currentStation = 1;
        sven.setCurrentStation(currentStation);
        sven.decreaseStation();
        int newStation = sven.getCurrentStation();
        int expected = currentStation - 1;
        assertEquals(expected, newStation);
    }

    @ParameterizedTest
    @CsvSource({"under min volume, -1, 0",
                "over max volume, 11, 10",
                "volume in range, 7, 7"})
    void shouldRadioSetVolume(String test, int numberVolume, int expected) {
        sven.setCurrentVolume(numberVolume);
        int actual = sven.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldRadioIncreaseVolume() {
        sven.increaseVolume();
        int volume = sven.getCurrentVolume();
        int expected = 1;
        assertEquals(expected, volume);
    }

    @Test
    void shouldRadioMaxVolume() {
        int maxVolume = sven.getMaxVolume();
        sven.setCurrentVolume(maxVolume);
        sven.increaseVolume();
        int currentVolume = sven.getCurrentVolume();
        assertEquals(maxVolume, currentVolume);
    }

    @Test
    void shouldRadioMinVolume() {
        int minVolume = sven.getMinVolume();
        sven.decreaseVolume();
        int currentVolume = sven.getCurrentVolume();
        assertEquals(minVolume, currentVolume);
    }

    @Test
    void shouldRadioDecreaseVolume() {
        int currentVolume = 7;
        sven.setCurrentVolume(currentVolume);
        sven.decreaseVolume();
        int newVolume = sven.getCurrentVolume();
        int expected = currentVolume - 1;
        assertEquals(expected, newVolume);
    }
}