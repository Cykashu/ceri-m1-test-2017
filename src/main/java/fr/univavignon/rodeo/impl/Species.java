/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univavignon.rodeo.impl;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.ISpecies;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author uapv1604337
 */
public abstract class Species implements ISpecies {
	protected final int area;
	protected final List<IAnimal> animals;
	public Species(int a, List<IAnimal> as) {
		this.area = a;
		this.animals = new ArrayList();
		this.animals.addAll(as);
	}
	public final int getArea() {
		return this.area;
	}
	public final List<IAnimal> getAnimals() {
		return this.animals;
	}
}
