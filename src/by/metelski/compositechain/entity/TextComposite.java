package by.metelski.compositechain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextComposite implements TextComponent {
	public static final String SPACE = " ";
	public static final String TAB = "\t";
	private ComponentType type;
	private List<TextComponent> components = new ArrayList<>();

	public TextComposite() {
	}
	public TextComposite(ComponentType type) {
		this.type = type;
	}
	public TextComposite(List<TextComponent> value,ComponentType type) {
		this.type = type;
	}
	public void setType(ComponentType type) {
		this.type = type;
	}
	public ComponentType getType() {
		return type;
	}
	@Override
	public List<TextComponent> getComponents(){
			return Collections.unmodifiableList(components);
	}
	@Override
	public void setComponents(List<TextComponent> components){
		this.components = components;
	}
	@Override
	public void add(TextComponent component) {
		components.add(component);
	}	
	@Override
	public void remove(TextComponent component) {
		components.remove(component);
	}
	@Override
	public int countSymbols() {
		return components.stream().mapToInt(TextComponent::countSymbols).sum();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((components == null) ? 0 : components.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		TextComposite other = (TextComposite) obj;
		if (components == null) {
			if (other.components != null)
				return false;
		} else if (!components.equals(other.components))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(TextComponent component : components) {
			builder.append(component.toString());
			if(component.getType() == ComponentType.LEXEME) {
				builder.append(SPACE);
			}
			if(component.getType()==ComponentType.PARAGRAPH) {
				builder.append(TAB);
			}
		}
		return builder.toString();
	}

}
