package ru.netology.smart_house;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
//    Radio sven = new Radio();

    @ParameterizedTest
    @CsvSource({"under min station, -1, 0",
                "equally min station, 0, 0",
                "over max station, 12, 9",
                "equally max station, 9, 9",
                "station in range, 5, 5"})
    void shouldRadioSetStation(String test, int numberStation, int expected) {
        Radio sven = new Radio();
        sven.setCurrentStation(numberStation);
        int actual = sven.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void sholdRadioSetCountStation() {
        Radio pioneer = new Radio(20);
        assertEquals(20, pioneer.getCountStation());
    }


    @Test
    void shouldRadioIncreaseStation() {
        Radio sven = new Radio();
        sven.increaseStation();
        int station = sven.getCurrentStation();
        int expected = 6;
        assertEquals(expected, station);
    }

    @Test
    void shouldRadioMaxStation() {
        Radio sven = new Radio();
        int maxStation = sven.getMaxStation();
        sven.setCurrentStation(maxStation);
        sven.increaseStation();
        int currentStation = sven.getCurrentStation();
        int minStation = sven.getMinStation();
        assertEquals(minStation, currentStation);
    }

    @Test
    void shouldRadioMaxStationWithSetCountStation() {
        Radio pioner = new Radio(19);
        int maxStation = pioner.getMaxStation();
        pioner.setCurrentStation(maxStation);
        pioner.increaseStation();
        int currentStation = pioner.getCurrentStation();
        int minStation = pioner.getMinStation();
        assertEquals(minStation, currentStation);
    }

    @Test
    void shouldRadioMinStation() {
        Radio sven = new Radio();
        int maxStation = sven.getMaxStation();
        sven.setCurrentStation(sven.getMinStation());
        sven.decreaseStation();
        int currentStation = sven.getCurrentStation();
        assertEquals(maxStation, currentStation);
    }

    @Test
    void shouldRadioMinStationWithSetCountStation() {
        Radio pioneer = new Radio(6);
        int maxStation = pioneer.getMaxStation();
        pioneer.setCurrentStation(pioneer.getMinStation());
        pioneer.decreaseStation();
        int currentStation = pioneer.getCurrentStation();
        assertEquals(maxStation, currentStation);
    }

    @Test
    void shouldRadioDecreaseStation() {
        Radio sven = new Radio();
        int currentStation = 5;
        sven.setCurrentStation(currentStation);
        sven.decreaseStation();
        int newStation = sven.getCurrentStation();
        int expected = currentStation - 1;
        assertEquals(expected, newStation);
    }

    @ParameterizedTest
    @CsvSource({"under min volume, -1, 0",
                "over max volume, 101, 100",
                "volume in range, 7, 7"})
    void shouldRadioSetVolume(String test, int numberVolume, int expected) {
        Radio sven = new Radio();
        sven.setCurrentVolume(numberVolume);
        int actual = sven.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldRadioIncreaseVolume() {
        Radio sven = new Radio();
        sven.increaseVolume();
        int volume = sven.getCurrentVolume();
        int expected = 26;
        assertEquals(expected, volume);
    }

    @Test
    void shouldRadioMaxVolume() {
        Radio sven = new Radio();
        int maxVolume = sven.getMaxVolume();
        sven.setCurrentVolume(maxVolume);
        sven.increaseVolume();
        int currentVolume = sven.getCurrentVolume();
        assertEquals(maxVolume, currentVolume);
    }

    @Test
    void shouldRadioMinVolume() {
        Radio sven = new Radio();
        int minVolume = sven.getMinVolume();
        sven.setCurrentVolume(0);
        sven.decreaseVolume();
        int currentVolume = sven.getCurrentVolume();
        assertEquals(minVolume, currentVolume);
    }

    @Test
    void shouldRadioDecreaseVolume() {
        Radio sven = new Radio();
        int currentVolume = 7;
        sven.setCurrentVolume(currentVolume);
        sven.decreaseVolume();
        int newVolume = sven.getCurrentVolume();
        int expected = currentVolume - 1;
        assertEquals(expected, newVolume);
    }
}