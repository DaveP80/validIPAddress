import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CheckIP {

    public static void main(String[] args) {

        while (true) {
            System.out.println("input IP address example: 3.4.3.0");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String address = input.trim();
            int count = 0;
            int count2 = 0;

            if (address.endsWith(".") || address.startsWith(".")) {
                count2++;
                System.out.println("invalid IP, dot at end or beginning");
                address = "exit";
            }

            if (!address.equals("exit")) {
                String dotregex = "(\\.)";

                Pattern pattern = Pattern.compile(dotregex);
                Matcher matcher = pattern.matcher(address);

                while (matcher.find()) {

                    count++;

                }

                if (count != 3) {
                    count2++;
                    System.out.println("invalid ip, need 3 dots" + "\n");
                    address = "exit";
                }
            }
            if (!address.equals("exit")) {
                String digitregex = "[^\\d.]";

                Pattern pattern2 = Pattern.compile(digitregex);
                Matcher matcher2 = pattern2.matcher(address);

                while (matcher2.find()) {
                    count2++;
                    System.out.println("invalid ip, enter only positive digits" + "\n");
                    address = "exit";
                    break;
                }
            }

            String twodot = "(\\.\\.)";

            Pattern pattern3 = Pattern.compile(twodot);
            Matcher matcher3 = pattern3.matcher(address);

            while (matcher3.find()) {
                count2++;
                System.out.println("invalid ip, dots separate ints" + "\n");
                address = "exit";
                break;

            }

            String fourints = "(\\d+)";

            Pattern pattern4 = Pattern.compile(fourints);
            Matcher matcher4 = pattern4.matcher(address);

            while (matcher4.find()) {

                System.out.println(matcher4.group());

                if (Integer.parseInt(matcher4.group()) > 255 || matcher4.group().matches("0[\\d]+")) {
                    System.out.println("invalid ip, numbers need to be <= 255" + "\n");
                    count2++;
                    break;
                }
            }
            if (count == 3 && count2 == 0) {
                System.out.println("correct IP " + address + "\n");
            }
        }
    }

}
