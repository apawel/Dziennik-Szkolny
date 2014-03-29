package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Pawel
 * 
 */
@Entity
public class SubjectMark {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "makrId")
	private int markId;
	/**
	 * 
	 */
	@Column (name = "value")
	private int value;
	/**
	 * 
	 */
	@Column (name = "weight")
	private int weight;
	/**
	 * 
	 */
	@Column(name = "timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	/**
	 * 
	 */
	@Column (name = "description")
	private String description;
	
	
	
	
}
