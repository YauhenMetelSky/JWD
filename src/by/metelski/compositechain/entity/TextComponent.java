package by.metelski.compositechain.entity;

public interface TextComponent {
	void add(TextComponent component);
	void addByIndex(int index);
	void remove(TextComponent component);
	void removeByIndex(int index);
	int countSymbols();
}
