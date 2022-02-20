// Printing out the progressive 'Get You a Cat' song using methods

public class assignmentTwo {
    public static void main(String[] agrs) {
        String catNoise = "fiddle-i-fee. \n";
        String henNoise = "chimmy-chuck, chimmy-chuck,";
        String duckNoise = "quack, quack,";
        String gooseNoise = "hissy, hissy,";
        String sheepNoise = "baa, baa,";
        String pigNoise = "oink, oink,";

        // Verse One
        mainVerse("cat");
        animalVerse("Cat", catNoise);

        // Verse Two
        mainVerse("hen");
        animalVerse("Hen", henNoise);
        animalVerse("Cat", catNoise);

        // Verse Three
        mainVerse("duck");
        animalVerse("Duck", duckNoise);
        animalVerse("Hen", henNoise);
        animalVerse("Cat", catNoise);

        // Verse Four
        mainVerse("goose");
        animalVerse("Goose", gooseNoise);
        animalVerse("Duck", duckNoise);
        animalVerse("Hen", henNoise);
        animalVerse("Cat", catNoise);

        // Verse Five
        mainVerse("sheep");
        animalVerse("Sheep", sheepNoise);
        animalVerse("Goose", gooseNoise);
        animalVerse("Duck", duckNoise);
        animalVerse("Hen", henNoise);
        animalVerse("Cat", catNoise);

        // Verse Six
        mainVerse("pig");
        animalVerse("Pig", pigNoise);
        animalVerse("Sheep", sheepNoise);
        animalVerse("Goose", gooseNoise);
        animalVerse("Duck", duckNoise);
        animalVerse("Hen", henNoise);
        animalVerse("Cat", catNoise);

    }
    //Method for the main two lines of the song
    static void mainVerse(String nameVar) {
        System.out.println("Bought me a " + nameVar + " and the "+ nameVar + " pleased me.");
        System.out.println("I fed my " + nameVar + " under the yonder tree.");
    }
    static void  animalVerse(String animalName, String animalSound) {
        System.out.println(animalName + " goes " + animalSound );
    }
}
