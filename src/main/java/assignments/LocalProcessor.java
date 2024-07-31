package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {
    private String processorVersion;
    private String processorName;
    private long period = 10_000_000_000_000L;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList = new LinkedList<>();

    public LocalProcessor() {
    }

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    @ListIteratorAnnotation
    public void iterate(List<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (String element : stringArrayList) {
            System.out.println(element.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        StringBuilder processorSB = new StringBuilder(processorName);
        for (String element : stringList) {
            processorSB.append(element);
        }
        processorName = processorSB.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        StringBuilder processorVersionSB = new StringBuilder(processorVersion);
        try (Scanner scanner = new Scanner(file)) {
            informationScanner = scanner;
            while (informationScanner.hasNext()) {
                processorVersionSB.append(informationScanner.nextLine());
            }
        } finally {
            informationScanner = null;
        }
        processorVersion = processorVersionSB.toString();
    }
}
