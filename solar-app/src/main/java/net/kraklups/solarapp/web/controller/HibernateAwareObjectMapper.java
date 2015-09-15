package net.kraklups.solarapp.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 7078834862636761834L;

	public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
    }
}