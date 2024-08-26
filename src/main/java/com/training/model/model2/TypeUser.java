package com.training.model.model2;

import lombok.Getter;

@Getter
public enum TypeUser {

	STORE(1, "LOJA"), USER(2, "CLIENTE");

	TypeUser(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	
	private int id;
	
	private String description;
	
	public static TypeUser toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (TypeUser x : TypeUser.values()) {
			if (x.equals(id)) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + id);
	}
	
	public static TypeUser toEnum(String desc) {
		if (desc == null) {
			return null;
		}
		for (TypeUser x : TypeUser.values()) {
			if (x.description.equals(desc)) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + desc);
	}
}
