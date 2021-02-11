package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Board;

public class BoardDao extends AbstractJpaDao<Long, Board>{

	public BoardDao() {
		super(Board.class);
	}

}
