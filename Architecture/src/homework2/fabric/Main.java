package homework2.fabric;

import homework2.fabric.fabrics.ExperienceGenerator;
import homework2.fabric.fabrics.GemGenerator;
import homework2.fabric.fabrics.GoldGenerator;
import homework2.fabric.fabrics.HonorGenerator;
import homework2.fabric.fabrics.ItemGenerator;
import homework2.fabric.fabrics.SkillPointGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // создаем список из различных фабрик
        List<ItemGenerator> generators = new ArrayList<>();
        generators.add(new ExperienceGenerator());
        generators.add(new HonorGenerator());
        generators.add(new GoldGenerator());
        generators.add(new GemGenerator());
        generators.add(new SkillPointGenerator());

        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            // выбираем случайную фабрику и используем ее метод для генерации и получения соотвветствующей награды
            int index = random.nextInt(0, generators.size());
            generators.get(index).getReward();
        }

    }
}
