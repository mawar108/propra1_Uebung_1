package propra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Eine Gratulation")
public class GratulationTest {

    @Test
    @DisplayName("hat als Anrede den richtigen Namen, wenn ein valider Name übergeben wird")
    void testValidName(){
        assertThat(Gratulation.create("Jaques").getAnrede()).isEqualTo("Hallo Jaques,");
    }

    @Test
    @DisplayName("hat als Anrede Unbekannter Nummer 1, wenn null übergeben wird")
    void testNameNull(){
     assertThat(Gratulation.create(null).getAnrede()).isEqualTo("Hallo Unbekannter Nummer 1,");
    }

    @Test
    @DisplayName("hat als Anrede Unbekannter Nummer 1, wenn ein leerer Name übergeben wird")
    void testNameEmpty(){
     assertThat(Gratulation.create("").getAnrede()).isEqualTo("Hallo Unbekannter Nummer 1,");
    }

    @Test
    @DisplayName("hat als Anrede Unbekannter Nummer 1, wenn ein Name aus Leerzeichen oder Tabs übergeben wird")
    void testNameBlanks(){
        assertThat(Gratulation.create(" ").getAnrede()).isEqualTo("Hallo Unbekannter Nummer 1,");
        assertThat(Gratulation.create("\t").getAnrede()).isEqualTo("Hallo Unbekannter Nummer 1,");
        assertThat(Gratulation.create("\n").getAnrede()).isEqualTo("Hallo Unbekannter Nummer 1,");
        assertThat(Gratulation.create(" \n").getAnrede()).isEqualTo("Hallo Unbekannter Nummer 1,");
        assertThat(Gratulation.create("\t \t").getAnrede()).isEqualTo("Hallo Unbekannter Nummer 1,");
    }





}
