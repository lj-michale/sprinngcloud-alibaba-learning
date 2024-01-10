package org.turing.designpattern.template;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.turing.designpattern.examples.template.Bouilli;
import org.turing.designpattern.examples.template.DodishTemplate;
import org.turing.designpattern.examples.template.EggsWithTomato;


public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void testApp() {
        DodishTemplate eggsWithTomato = new EggsWithTomato();
        eggsWithTomato.dodish();

        System.out.println("-----------------------------");

        DodishTemplate bouilli = new Bouilli();
        bouilli.dodish();
    }

}