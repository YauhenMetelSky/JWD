package by.metelski.compositechain.entity.impl;

import by.metelski.compositechain.entity.Component;

public class Leaf implements Component {

	@Override
	public void operation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Component c) {
		throw new UnsupportedOperationException("undone");
		
	}

	@Override
	public void remove(Component c) {
		throw new UnsupportedOperationException("undone");
		//ff
	}

	@Override
	public Object getChild(int index) {
	//as
		return null;
	}

}
