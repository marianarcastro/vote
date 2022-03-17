package com.vote.exception;

public class PautaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PautaNotFoundException(Long id) {
		super("Não foi possível achar a pauta " + id);
	}
}
