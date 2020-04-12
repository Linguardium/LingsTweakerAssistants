package mod.linguardium.lingassist.Assistants;

import java.util.Random;

public class RandomAssistant {
    public static final RandomAssistant INSTANCE = new RandomAssistant();
    public static final Random random = new Random();
    private RandomAssistant() {}
    public Integer nextInt(Integer bound) {
        return random.nextInt(bound);
    }
    public Integer nextInt() {
        return random.nextInt();
    }
    public Boolean nextBoolean() {
        return random.nextBoolean();
    }
    public Long nextLong() {
        return random.nextLong();
    }
    public Double nextDouble() {
        return random.nextDouble();
    }
    public Float nextFloat() {
        return random.nextFloat();
    }
}
