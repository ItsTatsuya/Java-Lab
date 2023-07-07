public class printstr {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide two command line arguments: <n> <str>");
            System.exit(1);
        }
        int n = Integer.parseInt(args[0]);
        String str = args[1];

        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }

    }
}
