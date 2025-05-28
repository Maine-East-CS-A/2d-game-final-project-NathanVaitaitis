import java.util.Scanner;
public class Main 
{

    public static void main(String[] args) 
    {   //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //Edit Script here for custom creature manually:
        //My wonderful "ui". Yay.
        //_____________________________________________________________________________________
        CHKN.insert(new CHKN.Blocks("Chicken", 0, CHKN.BlockType.BODY, 4, 5));
        CHKN.insert(new CHKN.Blocks("Chicken", 0, CHKN.BlockType.BODY, 5, 5));
        CHKN.insert(new CHKN.Blocks("Chicken", 1, CHKN.BlockType.BODY, 3, 5));
        CHKN.insert(new CHKN.Blocks("Chicken", 0, CHKN.BlockType.MOUTH, 3, 4));
        CHKN.insert(new CHKN.Blocks("Chicken", 1, CHKN.BlockType.BODY, 6, 5));
        CHKN.insert(new CHKN.Blocks("Chicken", 1, CHKN.BlockType.TAIL, 6, 6));
        //____________________________________________________________________________________
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        System.out.println("\nAdd a new block? (y/n): ");


        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();

        String animal;
        String typeStr;
        int x; // [0, 7]
        int y; //[0, 7]
        
        while (response.equalsIgnoreCase("y")) //collect info and stuff.
        {
            System.out.print("Animal: ");
            animal = scanner.nextLine();
            System.out.print("Size (int): ");
            int size = Integer.parseInt(scanner.nextLine());
            System.out.print("BlockType (MOUTH, BODY, TAIL, LEG, ARM, EYE, EAR, WING, MISC, CUSTOM): ");
            typeStr = scanner.nextLine();
            CHKN.BlockType type = CHKN.BlockType.valueOf(typeStr.toUpperCase());
            System.out.print("X (0-7): ");
            x = Integer.parseInt(scanner.nextLine());
            System.out.print("Y (0-7): ");
            y = Integer.parseInt(scanner.nextLine());

            CHKN.insert(new CHKN.Blocks(animal, size, type, x, y)); //applies info
            CHKN.display(); //updates chart

            System.out.println("\nAdd another block? (y/n): "); //retry query
            response = scanner.nextLine();
        }
        System.out.print("Animal: "); //resume query
         animal = scanner.nextLine();
        System.out.print("Size (int): ");
         int size = Integer.parseInt(scanner.nextLine());
        System.out.print("BlockType (MOUTH, BODY, TAIL, LEG, ARM, EYE, EAR, WING, MISC, CUSTOM): ");
         typeStr = scanner.nextLine();
        CHKN.BlockType type = CHKN.BlockType.valueOf(typeStr.toUpperCase());
        System.out.print("X (0-7): ");
         x = Integer.parseInt(scanner.nextLine());
        System.out.print("Y (0-7): ");
         y = Integer.parseInt(scanner.nextLine());

        CHKN.insert(new CHKN.Blocks(animal, size, type, x, y)); //applies info. Again.
        CHKN.display(); //updates chart. Again.

        System.out.println("\n" + "Add another block? (y/n): "); //retry.
        response = scanner.nextLine();
        CHKN.display();

        
        scanner.close(); //Just in case. I'm scared of scanner.
         System.out.println("\n" +  "You can create your own blocks like:");
        System.out.println("Blocks b = new Blocks(\"Animal\", size, BlockType.TYPE, x, y);");
        System.out.println("Then use funcs. : setAnimal(), setSize(), setType(), setCoordinates()");
    }
}

