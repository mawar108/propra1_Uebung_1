package propra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Eine Gratulation")
public class GratulationTest {

	@Test
	@DisplayName("hat als Anrede den richtigen Namen, wenn ein valider Name übergeben wird")
	void testValidName(){
		assertThat(new Gratulation("Jaques").getAnrede()).isEqualTo("Hallo Jaques,");
	}

	@Test
	@DisplayName("hat als Anrede Unbekannter Nummer 1, wenn null übergeben wird")
	void testNameNull(){
		assertThat(new Gratulation(null).getAnrede()).isEqualTo("Hallo Unbekannter Nummer 1,");
	}

	@Test
	@DisplayName("hat als Anrede Unbekannter Nummer 1, wenn ein leerer Name übergeben wird")
	void testNameEmpty(){
		assertThat(new Gratulation("").getAnrede()).isEqualTo("Hallo Unbekannter Nummer 1,");
	}

	@Test
	@DisplayName("hat als Anrede Unbekannter Nummer 1, wenn ein Name aus Leerzeichen oder Tabs übergeben wird")
	void testNameBlanks(){
		assertThat(new Gratulation(" ").getAnrede()).isEqualTo("Hallo Unbekannter Nummer 1,");
		assertThat(new Gratulation("\t").getAnrede()).isEqualTo("Hallo Unbekannter Nummer 1,");
		assertThat(new Gratulation("\n").getAnrede()).isEqualTo("Hallo Unbekannter Nummer 1,");
		assertThat(new Gratulation(" \n").getAnrede()).isEqualTo("Hallo Unbekannter Nummer 1,");
		assertThat(new Gratulation("\t \t").getAnrede()).isEqualTo("Hallo Unbekannter Nummer 1,");
	}





}
