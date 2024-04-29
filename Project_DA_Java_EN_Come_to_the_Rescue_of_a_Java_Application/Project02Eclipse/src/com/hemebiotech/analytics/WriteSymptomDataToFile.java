package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implementation of ISymptomWriter to write symptom data to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	private final String filePath;

	/**
     * Constructor for WriteSymptomDataToFile.
     *
     * @param filePath The path to the file where symptom data will be written.
     */
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }
    /**
     * Writes the given symptom data to the specified file.
     *
     * @param symptoms Map containing the symptoms and their counts to be written to the file.
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                fileWriter.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
}
