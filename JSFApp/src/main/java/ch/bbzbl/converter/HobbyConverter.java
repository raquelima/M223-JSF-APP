package ch.bbzbl.converter;


import ch.bbzbl.entity.Hobby;
import ch.bbzbl.facade.HobbyFacade;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Hobby.class)
public class HobbyConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		HobbyFacade lngFacade = new HobbyFacade();
		int hobbyId;

		try {
			hobbyId = Integer.parseInt(arg2);
		} catch (NumberFormatException exception) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Type the name of a hobby and select it (or use the dropdown)", "Type the name of a hobby and select it (or use the dropdown)"));
		}

		return lngFacade.findHobby(hobbyId);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		if (arg2 == null) {
			return "";
		}
		Hobby hobby = (Hobby) arg2;
		return String.valueOf(hobby.getId());
	}
}
