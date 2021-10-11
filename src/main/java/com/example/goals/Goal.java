package com.example.goals;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goals")
public class Goal {
    private int id;
    private String itemName;
    private int targetAmount;
    private int creditAmount;

    public Goal() {
    }

    public Goal(int id, String itemName, int targetAmount) {
        this.id = id;
        this.itemName = itemName;
        this.targetAmount = targetAmount;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
//other setters and getters

	public void setId(Integer id2) {
		this.id = id2;
		
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public void setTargetAmount(int targetAmount) {
		this.targetAmount = targetAmount;
	}
	
	public int getTargetAmount() {
		return this.targetAmount;
	}
	
	public void setCreditAmount(int creditAmount) {
		this.creditAmount = creditAmount;
	}
	
	public int getCreditAmount() {
		return this.creditAmount;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(" Item Name : " + this.getItemName() + " Target Amount : " + this.getTargetAmount() + " Credit Amount :" +this.getCreditAmount()); 
		return str.toString();
	}
}
