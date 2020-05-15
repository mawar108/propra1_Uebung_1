package propra;

public class Gratulation {

	private String name;

	public Gratulation(String name){
		if (name == null || name.isBlank()) {
			this.name="Unbekannter Nummer 1";
		}
		else {
			this.name=name;
		}
	}

	String getAnrede() {
		return "Hallo " + name +",";
	}

	String[] getText() {
		return new String[] {
				"schön, dass Sie es geschafft haben das Gradle File zu reparieren.",
				"Wir hoffen, Sie schaffen auch den Rest der Aufgabe."
		};
	}



}
