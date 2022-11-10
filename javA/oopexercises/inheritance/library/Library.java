package oopexercises.inheritance.library;

public class Library {
    Rent[] rents;

    public Library(Rent[] rents) {
        this.rents = rents;
    }

    public Rent getLongestRent() {
        long difference;
        long maxDifferent = 0;

        for (Rent rent : this.rents) {

            difference = rent.getEnd().getTime() - rent.getBegin().getTime();

            if ((difference) > maxDifferent) {
                maxDifferent = difference;
            }
        }

        for (Rent rent:this.rents) {
            difference = rent.getEnd().getTime() - rent.getBegin().getTime();
            if (Long.compare(difference, maxDifferent) == 0) {
                return rent;
            }
        }

        return null;
    }
}
