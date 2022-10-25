package revisionForFinalTest.candidate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CandidateManager {

    private ArrayList<Candidate> candidates = new ArrayList<>();

    public boolean readData(String fileName) {

        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] strArray = line.split("\\|");

                String id = strArray[0];
                String name = strArray[1];
                String selection = strArray[2];
                String gender = strArray[3];
                int year = Integer.parseInt(strArray[4].strip());
                int priority = Integer.parseInt(strArray[5].strip());

                Candidate candidate = new Candidate(id, name, selection, gender, year, priority);
                this.candidates.add(candidate);
            }

            scan.close();
            return true;
        }
        catch (FileNotFoundException fnfe) {
            return false;
        }

    }

    public ArrayList<Candidate> getSecondYoungest() {
        ArrayList<Candidate> secondYoungest = new ArrayList<>();

        int max = this.candidates.get(0).getYear();
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i<candidates.size(); i++) {
            if (candidates.get(i).getYear()>max) {
                max = candidates.get(i).getYear();
            }
        }

        for (int i = 0; i<candidates.size();i++) {
            if (candidates.get(i).getYear() > secondMax && candidates.get(i).getYear()!=max) {
                secondMax = candidates.get(i).getYear();
            }
        }

        for (int i = 0; i<candidates.size();i++) {

            if (candidates.get(i).getYear()==secondMax) {
                secondYoungest.add(candidates.get(i));
            }
        }

        return secondYoungest;
    }

    public ArrayList<Candidate> getSelectionCandidates(String selection) {

        ArrayList<Candidate> selectionCandidates = new ArrayList<>();

        for (int i = 0; i<this.candidates.size();i++) {

            if (candidates.get(i).getSelection().equals(selection)) {
                selectionCandidates.add(candidates.get(i));
            }
        }

        return selectionCandidates;
    }


    public ArrayList<Candidate> getPriorityCandidates() {

        ArrayList<Candidate> priorityCandidates = new ArrayList<>();

        for (int i = 0; i<this.candidates.size();i++) {

            if (candidates.get(i).getPriority() == 1 ) {
                priorityCandidates.add(candidates.get(i));
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

        for (int i = 0; i<candidates.size();i++) {
            candidates.get(i).print();
        }
    }

    public static void main(String[] args) {

        CandidateManager manager = new CandidateManager();
        boolean check = manager.readData("C:\\Users\\minha\\Desktop\\Tai lieu hoc tap\\THJava\\revisionForFinalTest\\candidate\\data.txt");
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
