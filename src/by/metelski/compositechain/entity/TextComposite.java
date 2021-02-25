package by.metelski.compositechain.entity.impl;

import java.util.ArrayList;
import java.util.List;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.TextComponent;

public class TextComposite implements TextComponent {
	private ComponentType type;
	private List<TextComponent> list = new ArrayList<>();
	
	public TextComposite() {
		
	}
	public TextComposite(ComponentType type) {
		this.type = type;
	}
	
	public void setType(ComponentType type) {
		this.type = type;
	}

	@Override
	public void operation() {		
	}

	@Override
	public void add(TextComponent component) {		
		list.add(component);
	}

	@Override
	public void remove(TextComponent component) {
		list.remove(component);
		
	}

	@Override
	public Object getChild(int index) {	
		return null;
	}
	@Override
	public int countLeaf() {
		return list.stream().mapToInt(TextComponent::countLeaf).sum();
	}
	

}
