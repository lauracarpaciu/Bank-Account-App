
package com.lauracarpaciu.entity.bankAccount;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Withdrawal extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
