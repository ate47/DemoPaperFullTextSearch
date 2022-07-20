package fr.atesab.demofulltext;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Triple {
	private final String subject, predicate, object;

	public String toNt() {
		return subject + " " + predicate + " " + object + " .";
	}
}
