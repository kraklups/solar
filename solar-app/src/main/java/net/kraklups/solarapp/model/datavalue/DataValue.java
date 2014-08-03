package net.kraklups.solarapp.model.datavalue;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import org.bson.types.ObjectId;

import org.hibernate.annotations.Type;

@Entity
@Table(name="DataValue")
public class DataValue implements Serializable {

	@Id
	private Long dataValueId;
	private String dataType;
	private String dataVal;
	private Calendar tvi;
	private Calendar tvf;
	
	
	public DataValue() {
		// TODO Auto-generated constructor stub
	}

}