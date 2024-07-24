#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Spell {
  private:
    string scrollName;

  public:
    Spell() : scrollName("") {}

  public:
    Spell(string name) : scrollName(name) {}

  public:
    virtual ~Spell() {}

  public:
    string revealScrollName() { return scrollName; }
};

class Fireball : public Spell {
  private:
    int power;

  public:
    Fireball(int power) : power(power) {}
    void revealFirepower() { cout << "Fireball: " << power << endl; }
};

class Frostbite : public Spell {
  private:
    int power;

  public:
    Frostbite(int power) : power(power) {}
    void revealFrostpower() { cout << "Frostbite: " << power << endl; }
};

class Thunderstorm : public Spell {
  private:
    int power;

  public:
    Thunderstorm(int power) : power(power) {}
    void revealThunderpower() { cout << "Thunderstorm: " << power << endl; }
};

class Waterbolt : public Spell {
  private:
    int power;

  public:
    Waterbolt(int power) : power(power) {}
    void revealWaterpower() { cout << "Waterbolt: " << power << endl; }
};

class SpellJournal {
  public:
    static string journal;
    static string read() { return journal; }
};
string SpellJournal::journal = "";

class Wizard {
  public:
    Spell *cast() {
        Spell *spell;

        string s;
        cin >> s;

        int power;
        cin >> power;

        if (s == "fire") {
            spell = new Fireball(power);
        } else if (s == "frost") {
            spell = new Frostbite(power);
        } else if (s == "water") {
            spell = new Waterbolt(power);
        } else if (s == "thunder") {
            spell = new Thunderstorm(power);
        } else {
            spell = new Spell(s);
            cin >> SpellJournal::journal;
        }
        return spell;
    }
};

int lcs(string &X, string &Y, int m, int n) {
    if (m == 0 || n == 0) {
        return 0;
    } else if (X[m - 1] == Y[n - 1]) {
        return 1 + lcs(X, Y, m - 1, n - 1);
    } else {
        return max(lcs(X, Y, m - 1, n), lcs(X, Y, m, n - 1));
    }
}

void counterspell(Spell *spell) {

    /* Enter your code here */
    if (dynamic_cast<Fireball *>(spell)) {
        Fireball *fireball = dynamic_cast<Fireball *>(spell);
        fireball->revealFirepower();
    } else if (dynamic_cast<Frostbite *>(spell)) {
        Frostbite *frostbite = dynamic_cast<Frostbite *>(spell);
        frostbite->revealFrostpower();
    } else if (dynamic_cast<Waterbolt *>(spell)) {
        Waterbolt *waterbolt = dynamic_cast<Waterbolt *>(spell);
        waterbolt->revealWaterpower();
    } else if (dynamic_cast<Thunderstorm *>(spell)) {
        Thunderstorm *thunderstorm = dynamic_cast<Thunderstorm *>(spell);
        thunderstorm->revealThunderpower();

    } else {
        string spell_name = spell->revealScrollName();
        string journal_name = SpellJournal::read();
        cout << lcs(spell_name, journal_name, spell_name.length(),
                    journal_name.length())
             << endl;
    }
}

int main() {
    int T;
    cin >> T;
    Wizard Arawn;
    while (T--) {
        Spell *spell = Arawn.cast();
        counterspell(spell);
    }
    return 0;
}