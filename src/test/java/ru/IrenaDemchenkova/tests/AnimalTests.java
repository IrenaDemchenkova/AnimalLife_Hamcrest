package ru.IrenaDemchenkova.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import ru.IrenaDemchenkova.Activity;
import ru.IrenaDemchenkova.Animal;
import ru.IrenaDemchenkova.InvalidStateException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Testable
public class AnimalTests {
    private static Animal cat;
    private static Animal mouse;

    @BeforeEach
    public void setup() {
        cat = new Animal("Barsik", 2, 10);
        mouse = new Animal("Myshik", 1, 1);
    }

    @AfterEach
    public void teardown() {
        cat = null;
        mouse = null;
    }

    @Test
    public void ifSleepingTest() {
        assertThat(mouse.ifSleeping(), equalTo(false));
    }

    @Test
    public void massAfterEatTest() throws InvalidStateException {
        int expected = 3;
        int massFood = 2;
        assertThat(mouse.massAfterEat(massFood), equalTo(expected));
    }

    @Test
    public void testAnimalException() {
        mouse.setActivity(Activity.SLEEPING);
        String message;
        try {
            mouse.massAfterEat(5);
            message = "failed";
        } catch (InvalidStateException e) {
            message = "succeeded";
        }
        assertThat(message, is("succeeded"));
    }

    @Test
    public void checkCatName() {
        assertThat(cat.getName(), is(notNullValue()));
    }

    @Test
    public void checkCatClass() {
        assertThat(cat.getClass(), is(Animal.class));
    }
}
