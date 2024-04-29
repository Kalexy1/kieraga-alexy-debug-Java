package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * A symptom analyser that counts and sorts symptoms and writes the results to a file.
 */
public class AnalyticsCounter {
	
	private final ISymptomReader reader;
    private final ISymptomWriter writer;
	
    /**
     * AnalyticsCounter class constructor.
     *
     * @param reader Object implementing the ISymptomReader interface for reading symptoms.
     * @param writer Object implementing the ISymptomWriter interface for writing counted and sorted symptoms.
     */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

	/**
     * Retrieves the list of symptoms from the file.
     *
     * @return List of symptoms.
     */
    public List<String> getSymptoms() {
        return reader.GetSymptoms();
    }

    /**
     * Counts the number of occurrences of each symptom in the list provided.
     *
     * @param symptoms List of symptoms.
     * @return Map containing symptoms and their number of occurrences.
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        // Compter les occurrences de chaque symptôme
    	Map<String, Integer> symptomCount = new HashMap<>();

        for (String symptom : symptoms) {
            symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
        }

        return symptomCount;
    }

    /**
     * Sorts the list of symptoms and occurrences in alphabetical order.
     *
     * @param symptoms Map containing symptoms and their number of occurrences.
     * @return Map sorted alphabetically by symptoms.
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        
    	return symptoms.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, 
                        LinkedHashMap::new 
                ));
    }

    /**
     * Writes the result to the output file.
     *
     * @param symptoms Map sorted alphabetically by symptoms and number of occurrences.
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
    
    
}
