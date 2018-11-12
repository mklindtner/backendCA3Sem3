package entities.DTOConverter;

import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.toSet;

public interface BaseDTOMapper<Input, Output> extends Function<Input, Output>
{
	default Set<Output> convertToSet(Set<Input> inputs) {
		return inputs.stream().map(this::apply).collect(toSet());
	}

}
