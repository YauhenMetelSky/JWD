package by.metelski.compositechain.entity;

import java.util.ArrayList;
import java.util.List;

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
	public void add(TextComponent component) {
		list.add(component);
	}

	@Override
	public void remove(TextComponent component) {
		list.remove(component);

	}

	@Override
	public int countSymbols() {
		return list.stream().mapToInt(TextComponent::countSymbols).sum();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TextComposite [type=");
		builder.append(type);
		builder.append(", list=");
		builder.append(list);
		builder.append("]");
		return builder.toString();
	}

}
