package ch.bbzbl.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ch.bbzbl.dao.EntityManagerHelper;

@ApplicationScoped
@ManagedBean(eager=true)
public class StartupBean {

	/**
	 * initialize EntityManagerFactory at application startup
	 */
	@PostConstruct
	public void init() {
		EntityManagerHelper.init();
	}
}
