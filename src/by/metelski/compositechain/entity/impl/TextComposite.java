package by.metelski.compositechain.entity.impl;

import java.util.ArrayList;
import java.util.List;

import by.metelski.compositechain.entity.Component;

public class Composite implements Component {
	private List<Component> list = new ArrayList<>();

	@Override
	public void operation() {		
	}

	@Override
	public void add(Component component) {		
		list.add(component);
	}

	@Override
	public void remove(Component component) {
		
		
	}

	@Override
	public Object getChild(int index) {	
		return null;
	}

}
