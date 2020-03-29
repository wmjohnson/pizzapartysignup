/**
 * 
 */
package org.pizzaparty.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * @author wjohnson
 *
 */
@Entity
@Table(name="contacts")
public class ContactEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7980122516275842422L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false,length = 50)
	private String name;
	
	@Column(nullable=false,length = 100)
	private String email;
	
	@Column(nullable=false,length = 100, unique = true)
	private String phone;
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
