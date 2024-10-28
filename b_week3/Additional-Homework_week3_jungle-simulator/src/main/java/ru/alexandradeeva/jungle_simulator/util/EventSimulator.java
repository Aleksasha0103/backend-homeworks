package ru.alexandradeeva.jungle_simulator.util;

import ru.alexandradeeva.jungle_simulator.entity.Tiger;

public class EventSimulator {
    // Диапазон случайных чисел // Вероятность события // Название события // Изменение пунктов здоровья и энергии //

    // Если энергия = 0: -5 здоровья;
    // 0 - 9 // 40 % // тигр спит: +18 энергии, +15 здоровья;
    // 10 - 19 // 20 % // тигр съел мясо: -7 энергии, +7 здоровья * коэфф. мяса;
    // 20 - 29 // 25 % // тигр на диете и съел рыбу с травами и ягодами: -4 энергии, +6 здоровья * коэфф. рыбы;
    // 30 - 39 // 10 % // тигр попал под бегущее стадо буйволов: -30 энергии, -20 здоровья;
    // 40 - 49 // 45 % // тигр поболтал с Табаки: -3 энергии;
    // 50 - 59 // 25 % // тигр столкнулся с Каа: -5 энергии;
    // 60 - 69 // 40 % // тигр погулял по джунглям: -10 энергии, +10 здоровья;
    // 70 - 79 // 10 % // у тигра произошла стычка с Маугли: -40 энергии, -30 здоровья;
    // 80 - 89 // 30 % // тигр поболтал с Балу: +5 энергии;
    // 90 - 100 // 35 % // тигр ходил с Багирой на водопой: +8 энергии;


    // Для расчёта вероятности: //
    // 0.0 * 100 = 0
    // 1.0 * 100 = 100

    public void startSimulation(Tiger tiger) {
        System.out.println("____________________________________________");
        System.out.println("Автор: ");
        System.out.println("Добро пожаловать в наш симулятор джунглей! " +
                "Понаблюдаем за тем, как проходят дни могущественного тигра Шер-Хана!");
        System.out.println("____________________________________________");
        System.out.println("Шер-Хан: ");
        System.out.println("Приветствую! Я Шер-Хан, величайший из тигров и единоличный правитель этих джунглей.");
        System.out.println("Все думают, что у меня здесь нет друзей, но это не так: я не в ладах лишь с Маугли, " +
                "ибо царь зверей может быть только один.");
        System.out.println("Хочешь, расскажу, что у меня новенького? Слушай:");
        System.out.println(" ");
        System.out.println("/Начальные значения здоровья и энергии:/");
        while (checkStatus(tiger)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber <= 9) {
                sleepEvent(tiger);
            } else if (eventNumber >= 10 && eventNumber <= 19) {
                eatMeatEvent(tiger);
            } else if (eventNumber >= 20 && eventNumber <= 29) {
                eatFishEvent(tiger);
            } else if (eventNumber >= 30 && eventNumber <= 39) {
                beatByBullsEvent(tiger);
            } else if (eventNumber >= 40 && eventNumber <= 49) {
                talkToTabaquiEvent(tiger);
            } else if (eventNumber >= 50 && eventNumber <= 59) {
                meetWithKaaEvent(tiger);
            } else if (eventNumber >= 60 && eventNumber <= 69) {
                walkInJungleEvent(tiger);
            } else if (eventNumber >= 70 && eventNumber <= 79) {
                beatByMowgliEvent(tiger);
            } else if (eventNumber >= 80 && eventNumber <= 89) {
                talkToBalooEvent(tiger);
            } else if (eventNumber >= 90 && eventNumber <= 100) {
                meetWithBagheeraEvent(tiger);
            }
        }
        System.out.println("____________________________________________");
        System.out.println("Автор: ");
        System.out.println("Ой! Кажется, былые встречи с Маугли и буйволами не прошли даром – здоровье подсело...");
        System.out.println("Царь джунглей умер!((( Да здравствует новый царь!");
        System.out.println("____________________________________________");
    }

    // События: //

    private void sleepEvent(Tiger tiger) {
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy + 18;
        health = health + 15;
        if (energy > 100) {
            energy = 100;
        }
        if (health > 100) {
            health = 100;
        }
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkHealthIsGood(tiger);
        System.out.println(" ");
        System.out.println("Быть царём иногда утомительно. Но этой ночью Бандар-логи не шумели, и я хорошо выспался.");
    }

    private void eatMeatEvent(Tiger tiger) {
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy - 7;
        health = health + (int) (tiger.getEnergyValueCoefficientMeat() * 7);
        if (energy < 0) {
            energy = 0;
        }
        if (health > 100) {
            health = 100;
        }
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkHealthIsGood(tiger);
        System.out.println(" ");
        System.out.println("Это была славная охота! " +
                "Захотелось мяска, поймал здоровенную антилопу – даже для Табаки немного осталось.");
    }

    private void eatFishEvent(Tiger tiger) {
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy - 4;
        health = health + (int) (tiger.getEnergyValueCoefficientFish() * 6);
        if (energy < 0) {
            energy = 0;
        }
        if (health > 100) {
            health = 100;
        }
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkHealthIsGood(tiger);
        System.out.println(" ");
        System.out.println("Увлечение антилопами привело к необходимости сесть на диету. " +
                "Жевал рыбу с травами и ягодами.");
    }

    private void beatByBullsEvent(Tiger tiger) {
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy - 30;
        health = health - 20;
        if (energy < 0) {
            energy = 0;
        }
        if (health < 0) {
            health = 0;
        }
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkHealthIsGood(tiger);
        System.out.println(" ");
        System.out.println("Эти глупые буйволы снова чего-то испугались! " +
                "Подвернулся им под копыта, как говорится, «очнулся – гипс».");
    }

    private void talkToTabaquiEvent(Tiger tiger) {
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy - 3;
        if (energy < 0) {
            energy = 0;
        }
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkHealthIsGood(tiger);
        System.out.println(" ");
        System.out.println("Опять заходил Табаки. " +
                "Устал от его пустой болтовни. Хотя как личный ассистент он неплох.");
    }

    private void meetWithKaaEvent(Tiger tiger) {
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy - 5;
        if (energy < 0) {
            energy = 0;
        }
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkHealthIsGood(tiger);
        System.out.println(" ");
        System.out.println("Столкнулся в джунглях с Каа – наслушался его нравоучений: " +
                "старик возомнил себя мудрецом. Утомлён.");
    }

    private void walkInJungleEvent(Tiger tiger) {
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy - 10;
        health = health + 10;
        if (energy < 0) {
            energy = 0;
        }
        if (health > 100) {
            health = 100;
        }
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkHealthIsGood(tiger);
        System.out.println(" ");
        System.out.println("Была прекрасная погода, поэтому я отлично провёл время на прогулке по моим владениям. " +
                "Всё-таки как похорошели джунгли при Шер-Хане!");
    }

    private void beatByMowgliEvent(Tiger tiger) {
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy - 40;
        health = health - 30;
        if (energy < 0) {
            energy = 0;
        }
        if (health < 0) {
            health = 0;
        }
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkHealthIsGood(tiger);
        System.out.println(" ");
        System.out.println("Произошла стычка с Маугли. " +
                "Надо признать, человеческий детёныш немного намял мне бока, но и ему от меня здорово досталось!");
    }

    private void talkToBalooEvent(Tiger tiger) {
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy + 5;
        if (energy > 100) {
            energy = 100;
        }
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkHealthIsGood(tiger);
        System.out.println(" ");
        System.out.println("Поболтал на прогулке с Балу: " +
                "весёлый и добродушный малый, всегда поднимает мне настроение.");
    }

    private void meetWithBagheeraEvent(Tiger tiger) {
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy + 5;
        if (energy > 100) {
            energy = 100;
        }
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkHealthIsGood(tiger);
        System.out.println(" ");
        System.out.println("Договорились с Багирой встретиться на водопое. " +
                "Она, конечно, красотка! Классно потусили!");
    }


    // Проверочные условия: //

    private void checkHealthIsGood(Tiger tiger) {
        if (tiger.getEnergy() <= 0) {
            int health = tiger.getHealth();
            health = health - 5;
            if (health < 0) {
                health = 0;
            }
            tiger.setHealth(health);
        }
    }

    // true - продолжается симуляция //
    // false - тигр умер //
    private boolean checkStatus(Tiger tiger) {
        System.out.println("/Здоровье: " + tiger.getHealth() + " Энергия: "
                + tiger.getEnergy() + "/");
        if (tiger.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }
}