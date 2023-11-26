package pl.edu.pl.mini.zpoif.gradedtask.first;

import java.util.Collection;

public interface Exchangeable {
	Collection<?> parseFile(String path) throws ParsingException;
	Collection<?> getSortedVehicles(Collection<?> parsedStuffs);
	Collection<?> getHorses(Collection<?> parsedStuff);
}
