package ch.bbzbl.dao;

import ch.bbzbl.entity.Hobby;

public class HobbyDAO extends GenericDAO<Hobby> {

	private static final long serialVersionUID = 1L;

	public HobbyDAO() {
		super(Hobby.class);
	}

	public void delete(Hobby hobby) {
		super.delete(hobby.getId());
	}

}