package by.metelski.compositechain.entity;

import java.util.List;

public class Symbol implements TextComponent {
    private static final int SYMBOL_COUNTER =1;
    private char value;
    private ComponentType type;
  
    public Symbol() {  	
    }
    public Symbol(char value) {
    	this.value = value;
    }
    public Symbol(char value, ComponentType componentType) {
    	this.value = value;
    	this.type=componentType;
    }
	@Override
	public void add(TextComponent c) {
		throw new UnsupportedOperationException("Operation not supported for Symbol.class");
	}
	@Override
	public void addByIndex(int index, TextComponent component) {
		throw new UnsupportedOperationException("Operation not supported for Symbol.class");		
	}
	@Override
	public void removeByIndex(int index) {
		throw new UnsupportedOperationException("Operation not supported for Symbol.class");	
	}
	@Override
	public void remove(TextComponent c) {
		throw new UnsupportedOperationException("Operation not supported for Symbol.class");
	}
	@Override
	public List<TextComponent> getComponents() {
		throw new UnsupportedOperationException("Operation not supported for Symbol.class");
	}
	@Override
	public int countSymbols() {
			return SYMBOL_COUNTER;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + value;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Symbol other = (Symbol) obj;
		if (type != other.type)
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return Character.toString(value);
	}
	@Override
	public ComponentType getType() {
		return type;
	}
}
