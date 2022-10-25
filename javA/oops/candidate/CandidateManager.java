package oops.candidate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CandidateManager {

    private ArrayList<Candidate> candidates;

    public CandidateManager() {
        this.candidates = new ArrayList<>();
    }


    public boolean readData(String textFile) {

        try {
            File file = new File(textFile);
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {

                String line = fileReader.nextLine();

                String[] arrayString = line.split("\\|");

                String id = arrayString[0].strip();
                String name = arrayString[1].strip();
                String selection = arrayString[2].strip();
                String sex = arrayString[3].strip();
                int year = Integer.parseInt(arrayString[4].strip());
                int priority = Integer.parseInt(arrayString[5].strip());

                Candidate person = new Candidate(id, name, selection, sex, year, priority);
                this.candidates.add(person);
            }

            fileReader.close();
            return true;
        }

        catch (FileNotFoundException fnfe) {
            return false;
        }
    }


    public ArrayList<Candidate> getSelectionCandidates(String selection) {

        ArrayList<Candidate> selectionCandidates = new ArrayList<>();

        for (Candidate person : this.candidates) {

            if (person.getSelection().equals(selection)) {
                selectionCandidates.add(person);
            }
        }

        return selectionCandidates;
    }


    public ArrayList<Candidate> getPriorityCandidates() {

        ArrayList<Candidate> priorityCandidates = new ArrayList<>();

        for (Candidate person : this.candidates) {

            if (person.getPriority() == 1 ) {
                priorityCandidates.add(person);
            }
        }

        return priorityCandidates;
    }


    public ArrayList<Candidate> sortByName() {

        ArrayList<Candidate> sortedList = (ArrayList<Candidate>) this.candidates.clone();

        for (int i = 0; i<sortedList.size()-1; i++) {

            for (int j = i+1; j<sortedList.size();j++) {

                if (sortedList.get(i).getName().compareTo(sortedList.get(j).getName()) > 0) {

                    Candidate temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }

        return sortedList;
    }


    public void printCandidates(ArrayList<Candidate> candidates) {

        for (Candidate person : candidates) {
            person.printInfo();
        }
    }




    public static void main(String[] args) {

        CandidateManager manager = new CandidateManager();
        boolean check = manager.readData("C:\\Users\\minha\\Desktop\\Tai lieu hoc tap\\THJava\\oops\\candidate\\data.txt.txt");
        System.out.println(check);

        System.out.println("List of candidates: ");
        manager.printCandidates(manager.candidates);

        System.out.println("Selection A candidates: ");
        ArrayList<Candidate> selectionACandidates = manager.getSelectionCandidates("A");
        manager.printCandidates(selectionACandidates);

        System.out.println("Get priority candidates: ");
        ArrayList<Candidate> priorityCandidates = manager.getPriorityCandidates();
        manager.printCandidates(priorityCandidates);

        ArrayList<Candidate> sortedList = manager.sortByName();
        manager.printCandidates(sortedList);






    }
}
