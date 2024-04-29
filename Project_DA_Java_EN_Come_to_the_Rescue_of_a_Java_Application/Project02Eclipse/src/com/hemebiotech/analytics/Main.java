package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Main class to run the symptom analytics application.
 */
public class Main {

	/**
     * Main method to instantiate required objects and execute the analytics process.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
    	// Instantiation of ISymptomReader object
        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");  // Remplacez YourSymptomReaderImplementation par la classe réelle que vous avez implémentée

        // Instantiation of ISymptomWriter object
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");  // Remplacez YourSymptomWriterImplementation par la classe réelle que vous avez implémentée

        // Instantiation of AnalyticsCounter object
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // Call the counterProcess method of AnalyticsCounter to execute the processing steps in the correct order
        counterProcess(counter);
    }

    /**
     * Executes the analytics counter process.
     *
     * @param counter AnalyticsCounter object to perform the analytics.
     */
    public static void counterProcess(AnalyticsCounter counter) {
        List<String> symptoms = counter.getSymptoms();
        Map<String, Integer> countedSymptoms = counter.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countedSymptoms);
        counter.writeSymptoms(sortedSymptoms);
    }
}

