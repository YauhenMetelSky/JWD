package by.metelski.compositechain.entity;

import java.util.List;

public interface TextComponent {
	void add(TextComponent component);
	void addByIndex(int index,TextComponent component);
	void remove(TextComponent component);
	void removeByIndex(int index);
	void setComponents(List<TextComponent> components);
	List<TextComponent> getComponents();
	ComponentType getType();
	int countSymbols();
}
