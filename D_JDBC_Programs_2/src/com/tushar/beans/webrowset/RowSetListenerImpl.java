package com.tushar.beans.webrowset;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class RowSetListenerImpl implements RowSetListener {

	@Override
	public void rowSetChanged(RowSetEvent event) {
		System.out.println("Row set changed.");
	}

	@Override
	public void rowChanged(RowSetEvent event) {
		System.out.println("Row changed.");
	}

	@Override
	public void cursorMoved(RowSetEvent event) {
		System.out.println("Cursor moved.");
	}

}
