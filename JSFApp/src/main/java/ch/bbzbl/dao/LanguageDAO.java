package ch.bbzbl.dao;

import ch.bbzbl.entity.Language;

public class LanguageDAO extends GenericDAO<Language> {

	private static final long serialVersionUID = 1L;

	public LanguageDAO() {
		super(Language.class);
	}

	public void delete(Language language) {
		super.delete(language.getId());
	}

}