package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface for writing symptom data to a file.
 */
public interface ISymptomWriter {
	/**
     * Writes the given symptom data to a file.
     *
     * @param symptoms Map containing the symptoms and their counts to be written to the file.
     */
	public void writeSymptoms(Map<String, Integer> symptoms);
}

