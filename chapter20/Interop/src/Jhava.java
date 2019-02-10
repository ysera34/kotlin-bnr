import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    @NotNull
    public String utterGreeting() {
        return greeting;
    }

    @Nullable
    public String determineFriendshipLevel() {
        return null;
    }
}
