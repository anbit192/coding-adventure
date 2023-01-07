package designpatterns.builder.character;

import designpatterns.builder.character.builders.CharacterBuilder;
import designpatterns.builder.character.product.Character;

public class App {
    public static void main(String[] args) {
        CharacterBuilder characterBuilder = (CharacterBuilder) CharacterBuilder.getBuilderInstance();
        ClassGenerator classGenerator = new ClassGenerator();

        classGenerator.Mage(characterBuilder);
        Character an = characterBuilder.getCharacter();

        classGenerator.Warrior(characterBuilder);
        Character anbish = characterBuilder.getCharacter();

        System.out.println(an);
        System.out.println(anbish);

        an.hit(anbish);
        System.out.println(anbish);


    }
}
