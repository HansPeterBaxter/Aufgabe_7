package de.hrw.swep.biblio.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import de.hrw.swep.biblio.persistence.DBInterface;
import de.hrw.swep.biblio.persistence.dto.BenutzerDTO;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Testet die Bibliotheks-Klasse mit einem Mock-Objekt
 * 
 * @author Sandra
 *
 */
public class BibliothekTestMitMock {

	/**
	 * Testet, ob ein Buch mit gegebenem Titel gefunden wird.
	 */

	Bibliothek bib;
	private DBInterface db;

	@Before
	public void setUp() {
		db = Mockito.mock(DBInterface.class);
		Mockito.when(db.getBenutzerById(1)).thenReturn(
				new BenutzerDTO(1, "erceng", "Gesperrt"));

		// db.When.getBuchByAutor("Kaka").thenReturn

		bib.setDb(db);

	}

	@Test
	public void testSucheBuchNachTitel() {
		fail("Not yet implemented");
	}

	/**
	 * Testet, ob ein Buch mit gegebenem Autor gefunden wird.
	 */
	@Test
	public void testSucheBuchNachAutor() {
		fail("Not yet implemented");
	}

	/**
	 * Testet, ob ein Benutzer mit gegebenem Namen gefunden wird.
	 */
	@Test
	public void testSucheBenutzerNachName() {
		fail("Not yet implemented");
	}

	/**
	 * Testet, ob ein Benutzer mit einer gegebenen ID gefunden wird.
	 */
	@Test
	public void testSucheBenutzerNachId() {
		bib = new Bibliothek();

		assertTrue(bib.sucheBenutzerNachId(1).getName() == "erceng");

	}
}
