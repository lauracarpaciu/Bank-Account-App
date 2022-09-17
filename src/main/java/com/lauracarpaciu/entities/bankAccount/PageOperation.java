package com.lauracarpaciu.entities.bankAccount;

import java.io.Serializable;
import java.util.List;


public class PageOperation implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Operation> operations;
    private int page;
    private int opetationNumber;
    private int totalOperations;
    private int totalPages;

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getOpetationNumber() {
        return opetationNumber;
    }

    public void setOpetationNumber(int opetationNumber) {
        this.opetationNumber = opetationNumber;
    }

    public int getTotalOperations() {
        return totalOperations;
    }

    public void setTotalOperations(int totalOperations) {
        this.totalOperations = totalOperations;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
