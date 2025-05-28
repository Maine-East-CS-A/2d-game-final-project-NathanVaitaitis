public class CHKN {
//Jump to line 159.
    private static Blocks[][] grid = new Blocks[8][8];

    // color stuff AAAAAAAAAAAHHHHHHHHHH 
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    //block by type!!! CHKN only has hard coded parts, kind of like lego does. However, it's heavily modded, so custom is allowed.
    public enum BlockType 
    {
        MOUTH, BODY, TAIL, LEG, ARM, EYE, EAR, WING, MISC, CUSTOM
    }

    // Static initializer block to fill grid
    static {
        for (int a = 0; a < 8; a++) 
        {
            for (int b = 0; b < 8; b++) 
            {
                grid[a][b] = new Blocks("", -1, BlockType.CUSTOM, a, b);
            }
        }
    }

    // Inner class
    public static class Blocks {
        private String animal;
        private int size;
        private BlockType type;
        private int x, y;

        public Blocks(String animal, int size, BlockType type, int x, int y) 
        {
            this.animal = animal;
            this.size = size;
            this.type = type; // ← keep type as passed in!
            this.x = x;
            this.y = y;
        }


        public String getAnimal() { return animal; }
        public int getSize() { return size; }
        public BlockType getType() { return type; }
        public int getX() { return x; }
        public int getY() { return y; }

        public void setAnimal(String a) { this.animal = a; }
        public void setSize(int s) { this.size = s; }
        public void setType(BlockType t) { this.type = t; }
        public void setCoordinates(int x, int y) { this.x = x; this.y = y; }

        public String build() 
        {
            String symbol = ".";

            switch (animal.toLowerCase())
            {
                case "chicken": symbol = "c"; break;
                case "snake": symbol = "s"; break;
                case "cat": symbol = "a"; break;
                case "pig": symbol = "p"; break;
                case "cow": symbol = "o"; break;
                case "elephant": symbol = "e"; break;
                case "spider": symbol = "x"; break;
                case "crab": symbol = "r"; break;
                case "robot": symbol = "b"; break;
                case "octopus": symbol = "t"; break;
            }

            if (size > 0) 
            {
                symbol = symbol.toUpperCase();
            }

            String color;
            switch (type) 
            {
                case MOUTH: color = RED; break;
                case BODY: color = GREEN; break;
                case TAIL: color = BLUE; break;
                case LEG: color = YELLOW; break;
                case ARM: color = PURPLE; break;
                default: color = WHITE; break;
            }

            return color + symbol + RESET;
        }

        
        public String toString() 
        {
            return animal + ", size " + size + ", " + type + ", at (" + x + ", " + y + ")";
        }
    }

    public static void insert(Blocks block) 
    {
        int x = block.getX();
        int y = block.getY();

        if (!block.toString().equals(grid[x][y].toString())) 
        {
            grid[x][y] = block;
        } else {
            for (int c = 0; c < 8; c++) 
            {
                for (int d = 0; d < 8; d++) 
                {
                    if (!block.toString().equals(grid[c][d].toString())) 
                    {
                        grid[c][d] = block;
                        return;
                    }
                }
            }
        }
    }

    public static void display() 
    {
        for (int e = 0; e < 8; e++) 
        {
            for (int f = 0; f < 8; f++) 
            {
                if (grid[e][f].getSize() == -1) 
                {
                    System.out.print(".");
                } else {
                    System.out.print(grid[e][f].build());
                }
            }
            System.out.println();
        }
    }
}