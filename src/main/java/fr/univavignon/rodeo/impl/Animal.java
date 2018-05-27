/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univavignon.rodeo.impl;

import fr.univavignon.rodeo.api.IAnimal;

/**
 *
 * @author uapv1604337
 */
public abstract class Animal implements IAnimal {
	protected final String name;
	protected final int xp;
	protected final boolean issecrect;
	protected final boolean isendangered;
	protected final boolean isboss;
	public Animal(String n, int xp, boolean s, boolean e, boolean b) {
		this.name = n;
		this.xp = xp;
		this.issecrect = s;
		this.isendangered = e;
		this.isboss = b;
	}
	@Override
	public int getXP() {
		return this.xp;
	}

	@Override
	public boolean isSecret() {
		return this.issecrect;
	}

	@Override
	public boolean isEndangered() {
		return this.isendangered;
	}

	@Override
	public boolean isBoss() {
		return this.isboss;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {return false;}
		if (this == obj) {return true;}
		if (!(obj instanceof Animal)) {return false;}
		Animal other = (Animal)obj;
		return (
			this.getName().equals(other.getName()) &&
			(this.getXP() == other.getXP()) &&
			(this.isSecret() == other.isSecret()) &&
			(this.isEndangered() == other.isEndangered()) &&
			(this.isBoss() == other.isBoss())
		);
	}
}
