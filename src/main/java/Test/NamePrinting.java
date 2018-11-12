package Test;

public interface NamePrinting
{
	default String funnyNaming(String name) {
		return name + " blob";
	}

}
