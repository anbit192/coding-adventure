package designpatterns.builder.character;

public class CharacterBuilder implements Builder {
    private Character character;

    private static Builder builder;

    public static Builder getBuilderInstance() {
        if (builder == null) {
            return new CharacterBuilder();
        }

        return builder;
    }

    private CharacterBuilder() {

    }

    @Override
    public Builder reset() {
        this.character = new Character();
        return this;
    }

    @Override
    public Builder setHP(int hp) {
        character.setHp(hp);
        return this;
    }

    @Override
    public Builder setATK(int atk) {
        character.setAtk(atk);
        return this;
    }

    @Override
    public Builder setMP(int mp) {
        character.setMp(mp);
        return this;
    }

    @Override
    public Builder setSkill(Skill skill) {
        character.setSkill(skill);
        return this;
    }

    public Character getCharacter() {
        return this.character;
    }
}
