package org.ClAssignateur.domain;

import java.util.LinkedList;

import java.util.Queue;
import java.util.Date;

public class FileDemande {

	private Queue<Demande> file = new LinkedList<Demande>();

	public int taille() {
		return this.file.size();
	}

	public void ajouter(Date dateDebut, Date dateFin, int nombreParticipant, Organisateur organisateur) {
		Demande demandeAjoutee = new Demande(dateDebut, dateFin, nombreParticipant, organisateur);
		
		this.file.offer(demandeAjoutee);
	}

	public void vider() {
		this.file.clear();
	}

	public Demande retirer() {
		return this.file.poll();
	}

}
