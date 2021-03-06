package org.ClAssignateur.domain;

import static org.junit.Assert.*;

import org.w3c.dom.ranges.RangeException;

import org.junit.Before;
import java.util.Date;
import org.junit.Test;

public class DemandeTest {

	private static final Date DATE_DEBUT = new Date(2015,07,1, 12,29,0);
	private static final Date DATE_FIN = new Date(2015,07,1, 12,30,0);
	private static final Organisateur ORGANISATEUR = new Organisateur("Simon");
	private static final int NOMBRE_PARTICIPANT = 10;
	private static final int NOMBRE_PARTICIPANT_INCORRECTE = 0;
	
	private Demande demande;
	
	@Before
	public void creerLaDemande(){
		demande = new Demande(DATE_DEBUT, DATE_FIN, NOMBRE_PARTICIPANT, ORGANISATEUR);
	}
	
	@Test
	public void DemandePossedeIntialementLeChampsDebutCommeDefiniDansLeConstructeur(){
		Date dateDebut = demande.getDebut();
		assertEquals(DATE_DEBUT, dateDebut);
	}
	
	@Test
	public void DemandePossedeIntialementLeChampsFinCommeDefiniDansLeConstructeur(){
		Date dateFin = demande.getFin();
		assertEquals(DATE_FIN, dateFin);
	}
	
	@Test
	public void DemandePossedeIntialementLeChampsNbParticipantCommeDefiniDansLeConstructeur(){
		int nbParticipant = demande.getNbParticipant();
		assertEquals(NOMBRE_PARTICIPANT, nbParticipant);
	}
	
	@Test
	public void DemandePossedeIntialementLeChampsOrganisateurCommeDefiniDansLeConstructeur(){
		Organisateur organisateur = demande.getOrganisateur();
		assertEquals(ORGANISATEUR, organisateur);
	}
	
	@Test(expected = RangeException.class)
	public void DemandeDoitAvoirUneDateDeDebutInferieurALaDateDeFin(){
		new Demande(DATE_FIN, DATE_DEBUT, NOMBRE_PARTICIPANT, ORGANISATEUR);
	}
	
	@Test(expected = RangeException.class)
	public void DemandeDoitAvoirUneDateDeDebutStrictementInferieurALaDateDeFin(){
		new Demande(DATE_FIN, DATE_FIN, NOMBRE_PARTICIPANT, ORGANISATEUR);
	}
	
	@Test(expected = RangeException.class)
	public void DemandeDoitAvoirUneNombreDeParticipantsStrictementSuperieurAuNombreDeParticipantMinimum(){
		new Demande(DATE_DEBUT, DATE_FIN, NOMBRE_PARTICIPANT_INCORRECTE, ORGANISATEUR);
	}
}
