import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class Jhava {

    private int hitPoints = 52489112;
    private String greeting = "BLARGH";

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public void offerFood() {
        Hero.handOverFood("pizza");
    }

    public void extendHandInFriendship() throws Exception {
        throw new Exception();
    }

    public void apologize() {
        try {
            Hero.acceptApology();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Caught!");
        }
    }

    @NotNull
    public String utterGreeting() {
        return greeting;
    }

    @Nullable
    public String determineFriendshipLevel() {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Hero.makeProclamation());

        System.out.println("Spells: ");
        Spellbook spellbook = new Spellbook();
        for (String spell : spellbook.spells) {
            System.out.println(spell);
        }
        System.out.println(String.format("Max spell count: %d", Spellbook.MAX_SPELL_COUNT));

        spellbook.getSpellbookGreeting();
        Spellbook.getSpellbookGreeting();

        Jhava jhava = new Jhava();
        jhava.apologize();

        Function1<String, Unit> translatorJ = Hero.getTranslator();
        translatorJ.invoke("TRUCE");
    }
}
