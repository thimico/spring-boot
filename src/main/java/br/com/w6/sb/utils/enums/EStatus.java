package br.com.w6.sb.utils.enums;

import lombok.Getter;

@Getter
public enum EStatus {
	A("Ativo", "Sim"),
	I("Inativo", "Não");

	private String nomeStatus;

	private String nomeAceitar;

	private String desc;

	EStatus(String nomeStatus, String nomeAceitar) {
		this.nomeStatus = nomeStatus;
		this.nomeAceitar = nomeAceitar;
		this.desc = nomeStatus;
	}
}
