package extraLarge.entities;

import extraLarge.SpecialAttributes;
import extraLarge.War;
import extraLarge.listSpecial.CustomStringList;
import extraLarge.listSpecial.ObjectsList;
import extraLarge.spaces.World;
import extraLarge.specialExceptions.InsufficientIntelligenceQuotientException;
import extraLarge.specialExceptions.NotAMindReaderException;
import extraLarge.specialExceptions.TooMuchOfAPussyException;

import java.util.ArrayList;

public class SpecialObject extends SpecialAttributes {

    private CustomStringList fetishes;
    private ObjectsList memories;
    private String nickname;
    private CustomStringList thoughts;
    private ObjectsList relationships;
    private double love;
    private ObjectsList family;
    private boolean happy;
    private String[] vocabulary;
    private War[] ongoingFights;

    public War[] getOngoingFights() {
        return ongoingFights;
    }

    public String[] getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String[] vocabulary) {
        this.vocabulary = vocabulary;
    }

    public ObjectsList getFamily() {
        return family;
    }

    public boolean isHappy() {
        return happy;
    }

    public void setLove(double love) {
        this.love = love;
    }

    public double getLove() {
        return love;
    }

    public SpecialObject getMemories(SpecialObject object) {
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public ObjectsList getRelationships() {
        return relationships;
    }

    public CustomStringList getThoughts() {
        return thoughts;
    }

    public CustomStringList getFetishes() {
        return fetishes;
    }

    public ArrayList<String> getArtTags() {
        return (ArrayList<String>) this.attributes.keySet();
    }

    public void addPhysicalAttribute(String attribute) {
        this.attributes.put(attribute, 0.0);
    }

    public void addToMemory(SpecialObject object) {
        memories.add((Life) object);
    }

    public void addFamily(Ghost g) {
        this.family.add(g);
    }

    public void setParents(Ghost[] parents) {
        this.family = new ObjectsList();
        this.family.add(parents[0]);
        this.family.add(parents[1]);
    }

    public void removeFamily(Ghost g) {
        this.family.remove(g);
    }

    public SpecialObject getMemory(SpecialObject anotherObject) {
        for (SpecialObject object : memories.getElements()) {
            if (object.nickname.equalsIgnoreCase(anotherObject.nickname)) {
                return object;
            }
        }
        return null;
    }

    public void getMemory(Life object, String memory) {

    }

    public void setMemory(String mood, String time) {

    }

    public void setMemory(Life object, String time) {

    }

    public void setNicknameFor(SpecialObject object, String name) {
        object.nickname = name;
    }

    public String decodeMessage(String msg, String decode) throws InsufficientIntelligenceQuotientException {
        return msg;
    }

    public String codeMessage(String msg, String encode) {
        return msg;
    }

    public void ignoreMessage() {

    }

    public void setMessage(String msg) {

    }

    public void announce(String msg) {
        System.out.println(msg);
    }

    public void clearThoughts() {
        this.thoughts = new CustomStringList();
    }

    public void sayTo(CustomStringList msg, SpecialObject object) throws TooMuchOfAPussyException {
        System.out.println(msg);
    }

    public void sayTo(String msg, SpecialObject object) {
        System.out.println(msg);
    }

    public void transferThoughts(SpecialObject object) {
        for (String myThought : this.thoughts.getElements()) {
            object.thoughts.add(myThought);
        }
    }

    public void transferAttribute(SpecialObject object) {
        String[] keySet = (String[]) this.attributes.keySet().toArray();
        for (int i = 0; i < this.attributes.size(); i++) {
            object.attributes.put(keySet[i], this.attributes.get(keySet[i]));
        }
    }

    public void fight(Life others) {
    }

    public void command(Life object, String command) {
        System.out.println(object.getNickname() + " " + command + " !");
    }

    public void pay(Life object, double amount, String description) {

    }

    public void praise(Life object, String content) {

    }

    public void gift(Life object, String gift) {

    }

    public void ask(Life object, String question) {
        System.out.println(this.nickname + " ask: "+ question);
    }

    public void ask(World world, String question) {
        System.out.println(this.nickname + " ask: "+ question);
    }


    public void callFor(Life object) {
        System.out.println(this.nickname + "called for " + object.getNickname());
    }

    public void manipulate(Life object, String action) {

    }

    public void consumeLast() {

    }

    public double getFinanceProperties() {
        return 192.0;
    }

    public void love(Life object) {
        this.setLove(100);
    }

    public Ghost[] getDreamParents() {
        Ghost[] dreamParents = {new Ghost(), new Ghost()};
        return dreamParents;
    }

    public void throwTantrum() {
        System.out.println("wahhh wahhh wahhhh!!!!");
    }

    public void disorient(Life object) {

    }

    public void listenTelepathically(Life object, World world) throws NotAMindReaderException {

    }

}
