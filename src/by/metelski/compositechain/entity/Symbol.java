package by.metelski.compositechain.entity.impl;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.TextComponent;

public class Leaf implements TextComponent {
    private static final int LEAF_COUNTER =1;
    private char value;
    private ComponentType componentType;
    public Leaf() {
    	
    }
    public Leaf(char value) {
    	this.value = value;
    }
    public Leaf(char value, ComponentType componentType) {
    	this.value = value;
    	this.componentType=componentType;
    }
	@Override
	public void operation() {				
	}

	@Override
	public void add(TextComponent c) {
		throw new UnsupportedOperationException("undone");
	}

	@Override
	public void remove(TextComponent c) {
		throw new UnsupportedOperationException("undone");
	}

	@Override
	public Object getChild(int index) {
		return null;
	}

	@Override
	public int countLeaf() {
			return LEAF_COUNTER;
	}
	

}
