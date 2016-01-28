package de.hrw.swep.biblio.service.gegenstaende;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.hrw.swep.biblio.service.IllegalStateTransition;
import de.hrw.swep.biblio.service.benutzer.Benutzer;

public class BuchStatusTest {

	@Test(expected = IllegalStateTransition.class)
	public void testVerlorenAusleihenIllegalStateTrans() {
		Buch b = new Buch("Lost and Found", "Karl Kaos");
		b.setState(new Verloren(b));

		b.verloren();

	}

	@Test
	public void testfreiesBuchVerloren() {
		Buch b = new Buch("Lost and Found", "Karl Kaos");
		b.setState(new Frei(b));

		b.verloren();
		assertEquals("de.hrw.swep.biblio.service.gegenstaende.Verloren", b
				.getState().getClass().getName());

	}

	@Test
	public void testfreiesBuchAusgeliehen() {

		Buch b = new Buch("Lost and Found", "Karl Kaos");
		Benutzer user = new Benutzer(1, "Zeki ERCENGIZ");
		b.setState(new Frei(b));

		b.ausleihen(user);
		assertEquals("de.hrw.swep.biblio.service.gegenstaende.Ausgeliehen", b
				.getState().getClass().getName());

	}

	@Test(expected = IllegalStateTransition.class)
	public void testAusgeliehenesBuchAusgeliehen() {

		Buch b = new Buch("Lost and Found", "Karl Kaos");
		Benutzer user = new Benutzer(1, "Zeki ERCENGIZ");
		b.setState(new Ausgeliehen(b));

		b.ausleihen(user);

		// assertEquals("de.hrw.swep.biblio.service.gegenstaende.Ausgeliehen", b
		// .getState().getClass().getName());

	}

	@Test(expected = IllegalStateTransition.class)
	public void testVerlorenesBuchAusleihen() {

		Buch b = new Buch("Lost and Found", "Karl Kaos");
		Benutzer user = new Benutzer(1, "Zeki ERCENGIZ");
		b.setState(new Ausgeliehen(b));

		b.ausleihen(user);

		// assertEquals("de.hrw.swep.biblio.service.gegenstaende.Ausgeliehen", b
		// .getState().getClass().getName());

	}

	@Test
	public void testAusgeliehenesBuchVerlieren() {

		Buch b = new Buch("Lost and Found", "Karl Kaos");
		Benutzer user = new Benutzer(1, "Zeki ERCENGIZ");
		b.setState(new Ausgeliehen(b));

		b.verloren();

		assertEquals("de.hrw.swep.biblio.service.gegenstaende.Verloren", b
				.getState().getClass().getName());

	}

}
