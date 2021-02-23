package com.company;

/*
 * Course: 	 	T CSS 305 - Programming Practicum
 * File name: 	main.java
 * Assignment: 	1
 * Due Date: 	1.16.2021 - 1.19.2020
 * Instructor: 	Professor Kivanc
 */

import java.util.*;

/**
 * Main class representing three versions of a calculator:
 * a binary, hex or bandwidth calculator. These calculators support
 * computation and conversion commands.
 *
 * @author Raz Consta
 * @version 1.7.2021 - 1.16.2021
 */
public class Main {

    /**
     * Main method of TripleCalculator class.
     *
     * @param args Command line input
     */
    public static void main(String[] args)
    {
        prompt(0);
    }

    /**
     * Prompts the user to choose the desired calculator.
     *
     * @param step integer representing the desired calculator; 0 when starting
     */
    public static void prompt(int step)
    {
        Scanner in = new Scanner(System.in);

        if (step == 0)
        {
            System.out.print("-----------------------------------------------"
                    + "\nSelect the type of calculator you want to use: "
                    + "\n 1 - Binary"
                    + "\n 2 - Hex"
                    + "\n 3 - Bandwidth"
                    + "\nEnter the digit representing your choice: ");

            String[] domain = {"1", "2", "3"};

            int firstChoice = validateChoice(domain, in);

            if (firstChoice == 1)
            {
                binaryCalculator();
                step = 1;
            }

            if (firstChoice == 2)
            {
                hexCalculator();
                step = 2;
            }

            if (firstChoice == 3)
            {
                bandwidthCalculator();
                step = 3;
            }
        }
        else if (step == 1)
                binaryCalculator();
        else if (step == 2)
                hexCalculator();
        else if (step == 3)
                bandwidthCalculator();

        System.out.print("-----------------------------------------------"
                           + "\nSelect what you want to do next:"
                           + "\n 1 - exit the calculator "
                           + "\n 2 - return to the calculator selection menu "
                           + "\n 3 - perform another operation in the current "
                           + "calculator"
                           + "\nEnter the digit representing your choice: ");

        String[] domain = {"1", "2", "3"};

        int secondChoice = validateChoice(domain, in);

        if (secondChoice == 1)
            System.out.println("Thank you for using our calculator.");
        if (secondChoice == 2)
            prompt(0);
        if (secondChoice == 3)
            prompt(step);
    }

    /**
     * Checks user input for errors and returns an integer representing the
     * choice.
     *
     * @param domain String Array of valid choices
     * @param scan Scanner for user input
     * @return integer representing the choice
     */
    public static int validateChoice(String[] domain, Scanner scan)
    {
        List list = Arrays.asList(domain);
        boolean valid ;
        String s;

        do {
            valid = true;
            s = scan.next();

            if (!list.contains(s))
                valid = false;

            if (!valid)
                System.out.print(" Valid entries include " + list.toString()
                        + ".\n Try entering the units again: ");
        } while (!valid);

        return Integer.parseInt(s);
    }

    /**
     * Static method representing the binary calculator.
     */
    public static void binaryCalculator()
    {
        System.out.print("-----------------------------------------------"
                + "\nSelect the operation you want to perform:"
                + "\n 1 - Add two binary numbers"
                + "\n 2 - Subtract two binary numbers"
                + "\n 3 - Multiply two binary numbers"
                + "\n 4 - Divide two binary numbers"
                + "\n 5 - Convert a binary number to a decimal number"
                + "\n 6 - Convert a decimal number to a binary number"
                + "\n 0 - Test mode"
                + "\nEnter the digit representing your choice: ");

        String[] domain = {"1", "2", "3", "4", "5" , "6" ,"0"};

        Scanner in = new Scanner(System.in);
        int choice = validateChoice(domain, in);
        System.out.println();

        // Add two binary values
        if (choice == 1)
        {
            System.out.print("Enter the first binary number: ");
            String a = validateBinary(in);
            System.out.print("Enter the second binary number: ");
            String b = validateBinary(in);
            System.out.println();
            System.out.println(a + " + " + b + " = "
                    + decimalToBinary(binaryToDecimal(a) + binaryToDecimal(b))
                    + " (binary) or " + (binaryToDecimal(a) + binaryToDecimal(b))
                    + " (decimal)");
        }

        // Subtract two binary values
        if (choice == 2)
        {
            System.out.print("Enter the first binary number: ");
            String a = validateBinary(in);
            System.out.print("Enter the second binary number: ");
            String b = validateBinary(in);
            System.out.println();

            if (binaryToDecimal(a) < binaryToDecimal(b))
            {
                System.out.println(a + " - " + b + " = -"
                        + decimalToBinary(binaryToDecimal(b) - binaryToDecimal(a))
                        + " (binary) or -" + (binaryToDecimal(b) - binaryToDecimal(a))
                        + " (decimal)");
            }
            else if (binaryToDecimal(a) >= binaryToDecimal(b))
            {
                System.out.println(a + " - " + b + " = "
                    + decimalToBinary(binaryToDecimal(a) - binaryToDecimal(b))
                    + " (binary) or " + (binaryToDecimal(a) - binaryToDecimal(b))
                    + " (decimal)");
            }

        }

        // Multiply two binary values
        if (choice == 3)
        {
            System.out.print("Enter the first binary number: ");
            String a = validateBinary(in);
            System.out.print("Enter the second binary number: ");
            String b = validateBinary(in);
            System.out.println();
            System.out.println(a + " * " + b + " = "
                    + decimalToBinary(binaryToDecimal(a) * binaryToDecimal(b))
                    + " (binary) or " + (binaryToDecimal(a) * binaryToDecimal(b))
                    + " (decimal)");
        }

        // Divide two binary values
        if (choice == 4)
        {
            System.out.print("Enter the first binary number: ");
            String a = validateBinary(in);
            System.out.print("Enter the second binary number: ");
            String b = validateBinary(in);
            System.out.println();
            System.out.println(a + " / " + b + " = "
                    + decimalToBinary(binaryToDecimal(a) / binaryToDecimal(b))
                    + " remainder " + decimalToBinary(binaryToDecimal(a) % binaryToDecimal(b))
                    + " (binary) or " + (binaryToDecimal(a) / binaryToDecimal(b))
                    + " remainder " + binaryToDecimal(a) % binaryToDecimal(b)
                    + " (decimal)");
        }

        // Convert binary to decimal value
        if (choice == 5)
        {
            System.out.print("Enter the binary number you want to convert "
                    + "to a decimal number: ");
            String binaryInput = validateBinary(in);
            System.out.println(binaryInput + " converted to decimal is "
                    + binaryToDecimal(binaryInput));
        }

        // Convert decimal to binary value
        if (choice == 6)
        {
            System.out.print("Enter the decimal number you want to convert "
                    + "to a binary number: ");
            long decimalInput = validateLong(in);

            if (decimalInput == -1)
            {
                System.out.println("");
            }
            else {
                System.out.println(decimalInput + " converted to binary is "
                        + decimalToBinary(decimalInput));
            }
        }

        // Test mode
        if (choice == 0)
        {
            String a, b;

            // Add
            a = "1110111010101111111";
            b = "1000100011011111100";
            System.out.println("1: " + a + " + " + b + " = "
                    + decimalToBinary(binaryToDecimal(a) + binaryToDecimal(b))
                    + " (binary) or " + (binaryToDecimal(a) + binaryToDecimal(b))
                    + " (decimal)");
            System.out.println("\t Expected value: " +
                    "10111011110001111011 (binary) or 769147 (decimal)\n");

            // Subtract
            a = "1000100011011";
            b = "1110111010101111111";

            System.out.println("2: " + a + " - " + b + " = -"
                    + decimalToBinary(binaryToDecimal(b) - binaryToDecimal(a))
                    + " (binary) or -" + (binaryToDecimal(b) - binaryToDecimal(a))
                    + " (decimal)");
            System.out.println("\t Expected value: " +
                    "-1110110010001100100 (binary) or -484452 (decimal)\n");

            // Multiply
            System.out.println("3: " + a + " * " + b + " = "
                    + decimalToBinary(binaryToDecimal(a) * binaryToDecimal(b))
                    + " (binary) or " + (binaryToDecimal(a) * binaryToDecimal(b))
                    + " (decimal)");
            System.out.println("\t Expected value: " +
            "1111111100101101101001101100101 (binary) or 2140590949 (decimal)\n");

            // Divide
            a = "101101110101111";
            b = "10110101";
            System.out.println("4: " + a + " / " + b + " = "
                    + decimalToBinary(binaryToDecimal(a) / binaryToDecimal(b))
                    + " remainder " + decimalToBinary(binaryToDecimal(a) % binaryToDecimal(b))
                    + " (binary) or " + (binaryToDecimal(a) / binaryToDecimal(b))
                    + " remainder " + binaryToDecimal(a) % binaryToDecimal(b)
                    + " (decimal)");
            System.out.println("\t Expected value: " +
            "10000001 remainder 1111010 (binary) or 129 remainder 122 (decimal)\n");

            // Binary to decimal
            a = "101101010111111011";
            System.out.println("5: " + a + " converted to decimal is "
                    + binaryToDecimal(a));
            System.out.println("\t Expected value: 185851\n");

            // Decimal to binary
            long decimalInput = -2342346213512L;
            System.out.println("6: " + decimalInput + " converted to binary is "
                    + decimalToBinary(decimalInput));
            System.out.println("\t Expected value: -1011110101101101100100010001000\n");
        }
    }

    /**
     * Checks user input for errors and returns a String representing a binary
     * number.
     *
     * @param scan Scanner for user input
     * @return String representing binary number
     */
    public static String validateBinary(Scanner scan)
    {
        boolean valid ;
        String s;

        do {
            valid = true;
            s = scan.next();

            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) != '0' && s.charAt(i) != '1')
                {
                    valid = false;
                    i = s.length();
                }

            if (!valid)
                System.out.print(" Only 0 and 1 are valid characters."
                        + "\n Try entering the binary number again: ");
        } while (!valid);

        return s;
    }

    public static long validateLong(Scanner scan)
    {
        long x = 0;

        try
        {
            x = scan.nextLong();
        } catch (InputMismatchException e)
        {
            System.out.print("Next time enter a valid decimal.");
            return -1;
        }

        return x;
    }

    /**
     * Returns a "long" number representing the given binary number.
     *
     * @param theString String representing binary number
     * @return "long" number representing the given binary number
     */
    public static long binaryToDecimal(String theString)
    {
        long decimalValue = 0, i = 0;

        for (int j = theString.length() - 1; j >= 0; j--)
            if (theString.charAt(j) == '1')
                decimalValue += Math.pow(2, i++);
            else
                i++;

        return decimalValue;
    }

    /**
     * Returns a String representing the given decimal number.
     *
     * @param theDecimal long representing decimal number
     * @return String representing a binary number
     */
    public static String decimalToBinary(long theDecimal)
    {
        if (theDecimal == 0)
            return "0";

        boolean negative = false;

        if (theDecimal < 0)
        {
            negative = true;
            theDecimal = (int) (Math.abs(theDecimal));
        }

        String temp = "";

        while (theDecimal > 0)
        {
            temp += Long.toString(theDecimal%2);
            theDecimal /= 2;
        }

        String binaryValue = "";

        for (int i = temp.length() - 1; i >= 0; i--)
            binaryValue += temp.charAt(i);

        if (negative)
            return "-" + binaryValue;
        else
            return binaryValue;
    }

    /**
     * Static method representing the hex calculator.
     */
    public static void hexCalculator()
    {
        System.out.print("-----------------------------------------------"
                + "\nSelect the operation you want to perform:"
                + "\n 1: Add two hex numbers"
                + "\n 2: Subtract two hex numbers"
                + "\n 3: Multiply two hex numbers"
                + "\n 4: Divide two hex numbers"
                + "\n 5: Convert a hex number to a decimal number"
                + "\n 6: Convert a decimal number to a hex number"
                + "\n 0: Test mode"
                + "\nEnter the digit representing your choice: ");

        String[] domain = {"1", "2", "3", "4", "5", "6", "0"};

        Scanner in = new Scanner(System.in);
        int choice = validateChoice(domain, in);
        System.out.println();

        // Add two hex values
        if (choice == 1)
        {
            System.out.print("Enter the first hex number: ");
            String a = validateHex(in);
            System.out.print("Enter the second hex number: ");
            String b = validateHex(in);
            System.out.println();
            System.out.println(a + " + " + b + " = "
                    + decimalToHex(hexToDecimal(a) + hexToDecimal(b))
                    + " (hex) or " + (hexToDecimal(a) + hexToDecimal(b))
                    + " (decimal)");
        }

        // Subtract two hex values
        if (choice == 2)
        {
            System.out.print("Enter the first hex number: ");
            String a = validateHex(in);
            System.out.print("Enter the second hex number: ");
            String b = validateHex(in);
            System.out.println();
            System.out.println(a + " - " + b + " = "
                    + decimalToHex(hexToDecimal(a) - hexToDecimal(b))
                    + " (hex) or " + (hexToDecimal(a) - hexToDecimal(b))
                    + " (decimal)");
        }

        // Multiply two hex values
        if (choice == 3)
        {
            System.out.print("Enter the first hex number: ");
            String a = validateHex(in);
            System.out.print("Enter the second hex number: ");
            String b = validateHex(in);
            System.out.println();
            System.out.println(a + " * " + b + " = "
                    + decimalToHex(hexToDecimal(a) * hexToDecimal(b))
                    + " (hex) or " + (hexToDecimal(a) * hexToDecimal(b))
                    + " (decimal)");
        }

        // Divide two hex values
        if (choice == 4)
        {
            System.out.print("Enter the first hex number: ");
            String a = validateHex(in);
            System.out.print("Enter the second hex number: ");
            String b = validateHex(in);
            System.out.println();
            System.out.println(a + " / " + b + " = "
                    + decimalToHex(hexToDecimal(a) / hexToDecimal(b))
                    + " remainder "
                    + decimalToHex(hexToDecimal(a) % hexToDecimal(b))
                    + " (hex) or " + (hexToDecimal(a) / hexToDecimal(b))
                    + " remainder " + hexToDecimal(a) % hexToDecimal(b)
                    + " (decimal)");
        }

        // Convert hexadecimal to decimal value
        if (choice == 5)
        {
            System.out.print("Enter the hex number you want to convert "
                    + "to a decimal number: ");
            String hexInput = validateHex(in);
            System.out.println(hexInput + " converted to decimal is "
                    + hexToDecimal(hexInput));
        }

        // Convert decimal to hexadecimal value
        if (choice == 6)
        {
            System.out.print("Enter the decimal number you want to convert "
                    + "to a hex number: ");
            long decimalInput = validateLong(in);

            if (decimalInput == -1)
            {
                System.out.println("");
            }
            else
            System.out.println(decimalInput + " converted to hex is "
                    + decimalToHex(decimalInput));
        }

        // Test mode
        if (choice == 0)
        {
            String a, b;

            // Add
            a = "-8ABD456";
            b = "FFF549543";
            System.out.println("1: " + a + " + " + b + " = "
                    + decimalToHex(hexToDecimal(a) + hexToDecimal(b))
                    + " (hex) or " + (hexToDecimal(a) + hexToDecimal(b))
                    + " (decimal)");
            System.out.println("\t Expected value: " +
                    "FF6A8C0ED (hex) or 68562764013 (decimal)\n");

            // Subtract
            a = "-8ABD456";
            b =  "43DB45CF6";
            System.out.println("2: " + a + " - " + b + " = "
                    + decimalToHex(hexToDecimal(a) - hexToDecimal(b))
                    + " (hex) or " + (hexToDecimal(a) - hexToDecimal(b))
                    + " (decimal)");
            System.out.println("\t Expected value: " +
                    "-44660314C (hex) or -18360578380 (decimal)\n");

            // Multiply
            a = "-8ABD456";
            b = "43DB45CF6";
            System.out.println("3: " + a + " * " + b + " = "
                    + decimalToHex(hexToDecimal(a) * hexToDecimal(b))
                    + " (hex) or " + (hexToDecimal(a) * hexToDecimal(b))
                    + " (decimal)");
            System.out.println("\t Expected value: " +
                    "-24C65EE7DFE4F2A4 (hex) or -2649909780740895396 (decimal)\n");

            // Divide
            a = "-FFF556ACBC4349";
            b = "123123CBF";
            System.out.println("4: " + a + " / " + b + " = "
                    + decimalToHex(hexToDecimal(a) / hexToDecimal(b))
                    + " remainder "
                    + decimalToHex(hexToDecimal(a) % hexToDecimal(b))
                    + " (hex) or " + (hexToDecimal(a) / hexToDecimal(b))
                    + " remainder " + hexToDecimal(a) % hexToDecimal(b)
                    + " (decimal)");
            System.out.println("\t Expected value: " +
            "-E11E2C remainder -11E9C7074 (hex) or -14753324 remainder -4808536180 (decimal)\n");

            // Hex to Decimal
            a = "-DDF5356F58F";
            System.out.println("5: " + a + " converted to decimal is "
                    + hexToDecimal(a));
            System.out.println("\t Expected value: " +
                    "-15252827075983\n");

            // Decimal to Hex
            long c = -342523455;
            System.out.println("6: " + c + " converted to hex is "
                    + decimalToHex(c));
            System.out.println("\t Expected value: " +
                    "-146A7E3F\n");
        }
    }

    /**
     * Check user input for errors and returns a string representing a hex number.
     *
     * @param scan Scanner for user input
     * @return String representing a hex number.
     */
    public static String validateHex(Scanner scan)
    {
        boolean valid ;
        String s;
        Character[] domain = {'-', '0', '1', '2', '3', '4', '5', '6', '7', '8',
                              '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        List list = Arrays.asList(domain);

        do {
            valid = true;
            s = scan.next();

            for (int i = 0; i < s.length(); i++)
                if (!list.contains(s.charAt(i)))
                {
                    valid = false;
                    i = s.length();
                }


            if (!valid)
                System.out.print(" Only 0-9 and A-F are valid characters."
                        + "\n Try entering the value again: ");
        } while (!valid);

        return s;
    }

    /**
     * Returns a "long" representing the given binary number.
     *
     * @param theString String representing a hex number.
     * @return "long" representing the given binary number
     */
    public static long hexToDecimal(String theString)
    {
        boolean negative = false;
        int x = 0;

        long decimalValue = 0;
        String helper = "0123456789ABCDEF";

        int j = theString.length() - 1;

        if (theString.startsWith("-"))
        {
            negative = true;
            x = 1;
            j = theString.length() - 2;
        }

        for (int i = x; i < theString.length(); i++)
            decimalValue += helper.indexOf(theString.charAt(i)) *
                    Math.pow(16, j--);


        if (negative)
            return -1 * decimalValue;

        return decimalValue;
    }

    /**
     * Returns a String hex number representing the given decimal number.
     *
     * @param theDecimal long representing the number to convert to hex
     * @return String hex number
     */
    public static String decimalToHex(long theDecimal)
    {
        if (theDecimal == 0)
            return "0";

        boolean negative = false;

        if (theDecimal < 0)
        {
            negative = true;
            theDecimal = -1 * theDecimal;
        }

        long remainder;
        String result = "";
        String helper = "0123456789ABCDEF";

        while(theDecimal > 0)
        {
            remainder = theDecimal % 16;
            result = helper.charAt((int)(remainder))+ result;
            theDecimal /= 16;
        }

        if (negative)
            return "-" + result;
        else
            return result;
    }

    /**
     * Static method representing the bandwidth calculator functions.
     */
    public static void bandwidthCalculator()
    {
        System.out.print("-----------------------------------------------"
                + "\nSelect the operation you want to perform:"
                + "\n 1: Data unit converter"
                + "\n 2: Download/Upload Time Calculator"
                + "\n 3: Website Bandwidth Calculator"
                + "\n 4: Hosting bandwidth converter"
                + "\n 0: Test mode"
                + "\nEnter the digit representing your choice: ");

        String[] choices = {"1", "2", "3", "4", "0"};

        Scanner in = new Scanner(System.in);
        int choice = validateChoice(choices, in);
        System.out.println();

        // Data unit conversion
        if (choice == 1)
        {
            System.out.print("Enter the quantity you want to convert "
                    + "(without units): ");

            double quantity = validateData(in);

            System.out.print("Enter the data units"
                    + "(b, kb, mb, gb, tb, B, KB, MB, GB, TB): ");

            String[] domain = {"b", "kb", "mb", "gb", "tb",
                    "B", "KB", "MB", "GB", "TB"};
            String unit = validateType(domain, in);
            System.out.println();

            dataUnitConvert(quantity, unit);
        }

        // Download/Upload Time Calculator
        if (choice == 2)
        {
            System.out.print("Enter the quantity of the file size"
                             + " (without units): ");
            double fileSize = validateData(in);

            System.out.print("Enter the data units"
                    + "(B, KB, MB, GB, TB): ");

            String[] domain1 = {"B", "KB", "MB", "GB", "TB"};

            String fileSizeUnit = validateType(domain1, in);
            System.out.println();

            System.out.print("Enter the quantity of the bandwidth"
                    + " (without units): ");
            double bandwidthSize = validateData(in);

            System.out.print("Enter the data units"
                    + "(bit/s, Kbit/s, Mbit/s, Gbit/s, Tbit/s): ");

            String[] domain2 = {"bit/s", "Kbit/s", "Mbit/s", "Gbit/s", "Tbit/s"};

            String bandwidthUnit = validateType(domain2, in);
            System.out.println();

            downUpCalculator(fileSize, fileSizeUnit, bandwidthSize, bandwidthUnit);
        }

        // Website Bandwidth Calculator
        if (choice == 3)
        {
            System.out.print("Enter the number of page views"
            + " (without the frequency): ");

            double views = validateData(in);

            System.out.print("Enter the frequency (second, minute, hour, day, "
                            + "week, month, year): ");

            String[] domain1 = {"second", "minute", "hour", "day", "week",
                    "month", "year"};

            String freq = validateType(domain1, in);
            System.out.println();

            System.out.print("Enter the page size without the units: ");

            double size = validateData(in);

            System.out.print("Enter the units of the page size"
            + " (B, KB, MB, GB, TB): ");

            String[] domain2 = {"B", "KB", "MB", "GB", "TB"};

            String pageUnit = validateType(domain2, in);
            System.out.println();

            System.out.print("Enter the redundancy factor: ");
            double factor = validateData(in);

            websiteBandwidthCalculator(views, freq, size, pageUnit, factor);
        }

        // Hosting bandwidth converter
        if (choice == 4)
        {
            System.out.print("Select the operation you want to perform:"
            + "\n 1. Monthly usage to bandwidth"
            + "\n 2. Bandwidth to monthly usage"
            + "\nType the digit representing your choice: ");

            String[] twoChoices = {"1", "2"};
            int secondChoice = validateChoice(twoChoices, in);
            System.out.println();

            if (secondChoice == 1)
            {
                System.out.print("Enter the quantity of the monthly usage"
                        + " (without units): ");
                double usageSize = validateData(in);

                System.out.print("Enter the data units"
                        + "(B, KB, MB, GB, TB): ");

                String domain1[] = {"B", "KB", "MB", "GB", "TB"};

                String usageUnit = validateType(domain1, in);
                System.out.println();

                System.out.print("Enter the units of bandwidth to convert to"
                + " (bit/s, Kbit/s, Mbit/s, Gbit/s, Tbit/s): ");

                String domain2[] = {"bit/s", "Kbit/s", "Mbit/s", "Gbit/s",
                                    "Tbit/s"};

                String bandwidthUnit = validateType(domain2, in);
                System.out.println();

                monthlyUsageToBandwidth(usageSize, usageUnit, bandwidthUnit);
            }
            else if (secondChoice == 2)
            {
                System.out.print("Enter the quantity of the bandwidth"
                        + " (without units): ");
                double bandwidthSize = validateData(in);

                System.out.print("Enter the units of the quantity you typed"
                        + " (bit/s, Kbit/s, Mbit/s, Gbit/s, Tbit/s): ");

                String domain1[] = {"bit/s", "Kbit/s", "Mbit/s", "Gbit/s",
                        "Tbit/s"};

                String bandwidthUnit = validateType(domain1, in);
                System.out.println();

                System.out.print("Enter the units of monthly usage to convert"
                + " to: (B, KB, MB, GB, TB)");

                String domain2[] = {"B", "KB", "MB", "GB", "TB"};

                String usageUnit = validateType(domain2, in);
                System.out.println();

                bandwidthToMonthlyUsage(bandwidthSize, bandwidthUnit, usageUnit);
            }
        }

        // Test mode
        if (choice == 0)
        {
            // Data unit converter
            dataUnitConvert(324.32, "tb");
            System.out.println();

            // Download/upload time calculator


            // Website bandwidth calculator
            System.out.println("Website bandwith equired for " +
                    "4751.312 page views per minute, with an average page " +
                    "size of 215.6 MB and redundancy factor of 1.72");
            websiteBandwidthCalculator(4751.321, "minute",
                                    215.6, "MB", 1.72);
            System.out.println();

            // Hosting bandwith calculator
            monthlyUsageToBandwidth(28.31, "KB", "Mbit/s");
            bandwidthToMonthlyUsage(1235.15, "Gbit/s", "KB");
        }
    }

    /**
     * Checks for user input errors and returns a "double" representing data
     * quantity.
     *
     * @param scan Scanner for user input.
     * @return "double" representing data quantity.
     */
    public static double validateData(Scanner scan)
    {
        boolean valid;
        String s;

        Character[] domain = {'.', '0', '1', '2', '3', '4', '5', '6', '7', '8',
                              '9'};
        List list = Arrays.asList(domain);

        do {
            valid = true;
            s = scan.next();

            for (int i = 0; i < s.length(); i++)
                if (!list.contains(s.charAt(i)))
                {
                    valid = false;
                    i = s.length();
                }

            if (!valid)
                System.out.print(" Only . and 0-9 are valid characters."
                        + "\n Try entering the value again: ");
            } while (!valid);

        return Double.parseDouble(s);
    }

    /**
     * Checks for user input errors and returns a String representing the
     * data units.
     *
     * @param domain String Array representing valid data units.
     * @param scan Scanner for user input.
     * @return String representing data units.
     */
    public static String validateType(String[] domain, Scanner scan)
    {
        List list = Arrays.asList(domain);
        boolean valid ;
        String s;

        do {
            valid = true;
            s = scan.next();

            if (!list.contains(s))
                valid = false;

            if (!valid)
                System.out.print(" Valid entries include " + list.toString()
                        + ".\n Try entering the units again: ");
        } while (!valid);

        return s;
    }

    /**
     * Prints data conversions for a given data type.
     *
     * @param quantity double representing the data quantity
     * @param unit String representing the data type
     */
    public static void dataUnitConvert(double quantity, String unit)
    {
        String[] ranks = {"b", "kb", "mb", "gb", "tb",
                "B", "KB", "MB", "GB", "TB"};

        /*
        default1 is the bits representation
        default 2 is the bytes representation
         */
        double default1 = 0, default2 = 0;

        int rank = 0;

        for (int i = 0; i < ranks.length; i++)
            if (unit.equals(ranks[i]))
            {
                rank = i;
                i = ranks.length;
            }


        System.out.println(quantity + " " + unit
                + " is equivalent to any of the following:");

        if (rank <= 4)
        {
            if (rank == 0)
            {
                default1 = quantity;
                default2 = quantity / 8;
            }
            else {
                default1 = quantity * Math.pow(1000, rank);
                default2 = default1 / 8;
            }
        }

        if (rank >= 5)
        {
            if (rank == 5)
            {
                default1 = quantity * 8;
                default2 = quantity;
            }
            else
            {
                default2 = quantity * Math.pow(1000, rank - 5);
                default1 = default2 * 8;
            }
        }

        // -------------------------------------------------------------------
        double[] allUnits = new double[10];

        allUnits[0] = default1;

        for (int i = 1; i <=4; i++)
            allUnits[i] = allUnits[i - 1] / 1000;

        allUnits[5] = default2;

        for(int i = 6; i <= 9; i++)
            allUnits[i] = allUnits[i - 1] / 1000;

        // -------------------------------------------------------------------

        for (int i = 0; i <= 9; i++)
            if (i != rank)
                System.out.println(allUnits[i] + " " + ranks[i]);
    }

    /**
     * Prints the required time to download or upload a file.
     *
     * @param fileSize double representing the file size
     * @param fileSizeUnit String representing the unit of the file size
     * @param bandwidthSize double representing the bandwidth
     * @param bandwidthUnit String representing the unit of the bandwidth
     */
    public static void downUpCalculator
    (double fileSize, String fileSizeUnit,
     double bandwidthSize, String bandwidthUnit)
    {
        String[] ranks1 = {"B", "KB", "MB", "GB", "TB"};
        String[] ranks2 = {"bit/s", "Kbit/s", "Mbit/s", "Gbit/s", "Tbit/s"};
        int rank1 = 0;
        int rank2 = 0;

        for (int i = 0; i <= 4; i++)
            if (fileSizeUnit.equals(ranks1[i]))
            {
                rank1 = i;
                i = 4;
            }


        for (int i = 0; i <= 4; i++)
            if (bandwidthUnit.equals(ranks2[i]))
            {
                rank2 = i;
                i = 4;
            }


        double default1 = fileSize * Math.pow(1000, rank1);
        double default2 = bandwidthSize * Math.pow(1000, rank2);

        long seconds = 0, minutes = 0, hours = 0, days = 0;

        minutes = (long)((default1 * 8) / default2 / 60);
        seconds = (long)((default1 * 8) / default2 % 60);
        if (minutes > 60) {
            hours = minutes / 60;
            minutes %= hours * 60;

            if (hours > 24) {
                days = hours / 24;
                hours %= days * 24;
            }
        }

        System.out.print("Download or upload time needed is: ~");

        if (days != 0)
            System.out.print(days + " days ");
        if (hours != 0)
            System.out.print(hours + " hours ");
        if (minutes != 0)
            System.out.print(minutes + " minutes ");

        System.out.println(seconds + " seconds");
    }

    /**
     * Prints to console estimated bandwidth needs of a website.
     *
     * @param views double representing the number of views
     * @param freq String representing the frequency of the number of views
     * @param size double representing the page size
     * @param pageUnit String representing the unit of the page size
     * @param factor double representing the redundancy factor
     */
    public static void websiteBandwidthCalculator
                       (double views, String freq, double size, String pageUnit,
                        double factor)
    {
        // a month is defined as 30.4375 days

        String[] ranks1 = {"second", "minute", "hour", "day", "week",
                           "month", "year"};

        /* these coefficients can help us get the number of page views per month
        double[] coefficients = {0.000000380257054,
                                 0.0000228154,
                                 0.0013689254,
                                 0.0328542094,
                                 0.2299794661,
                                 1,
                                 12};
         */

        // these coefficients help us get the number of page views per month
        double[] coefficients = {2629800,
                                43830,
                                730.5,
                                30.4375,
                                4.3482142857,
                                1,
                                0.0833333333};


        int rank1 = 0;

        for (int i = 0; i <= 6; i++)
            if (freq.equals(ranks1[i]))
            {
                rank1 = i;
                i= 6;
            }

        String[] ranks2 = {"B", "KB", "MB", "GB", "TB"};

        int rank2 = 0;

        for (int i = 0; i <= 6; i++)
            if (pageUnit.equals(ranks2[i]))
            {
                rank2 = i;
                i = 6;
            }

        // default1 represents the number of page views per month
        double default1 = views * coefficients[rank1];

        // default2 represents the page size in MB
        double default2 = size * Math.pow(1000, rank2 - 2);

        double answer1 = default1 * default2 * 8 / 2629800;
        double answer2 = default1 * default2 / 1000;

        //System.out.print("default1 = " + default1 + "default2 = " + default2);

        System.out.println("Actual bandwidth needed is "
                        + answer1 + " Mbit/s or "
                        + answer2 + " GB per month."
                        + "\nWith redundancy factor of " + factor
                        + " , the bandwidth needed is "
                        + answer1 * factor + " Mbit/s or "
                        + answer2 * factor + " GB per month.");
    }

    /**
     * Prints the equivalent bandwidth for the given monthly usage.
     *
     * @param usageSize double representing the monthly usage
     * @param usageUnit String representing the data type of the monthly usage
     */
    public static void monthlyUsageToBandwidth
            (double usageSize, String usageUnit, String bandwidthUnit)
    {
        String[] ranks1 = {"B", "KB", "MB", "GB", "TB"};
        int rank1 = 0, rank2 = 0;

        for (int i = 0; i <= 4; i++)
            if (usageUnit.equals(ranks1[i]))
            {
                rank1 = i;
                i = 4;
            }

        double default1 = usageSize * Math.pow(1000, rank1);

        String[] ranks2 = {"bit/s", "Kbit/s", "Mbit/s", "Gbit/s", "Tbit/s"};

        for (int i = 0; i <= 4; i++)
            if (bandwidthUnit.equals(ranks2[i]))
            {
                rank2 = i;
                i = 4;
            }

        // a month is defined as 30.4375 days
        double answer = (default1 * 8 / 2629800) / Math.pow(1000, rank2);

        System.out.println(usageSize + " " + usageUnit + " per month is "
                    + "equivalent to " + answer + " " + bandwidthUnit);
    }

    /**
     * Prints the equivalent monthly usage for the given bandwidth.
     *
     * @param bandwidthSize double representing the bandwidth
     * @param bandwidthUnit String representing the data type of the bandwidth
     */
    public static void bandwidthToMonthlyUsage
            (double bandwidthSize, String bandwidthUnit, String usageUnit)
    {
        String[] ranks1 = {"bit/s", "Kbit/s", "Mbit/s", "Gbit/s", "Tbit/s"};
        int rank1 = 0, rank2 = 0;

        for (int i = 0; i <= 4; i++)
            if (bandwidthUnit.equals(ranks1[i]))
            {
                rank1 = i;
                i = 4;
            }

        double default1 = bandwidthSize * Math.pow(1000, rank1);

        String[] ranks2 = {"B", "KB", "MB", "GB", "TB"};

        for (int i = 0; i <= 4; i++)
            if (usageUnit.equals(ranks2[i]))
            {
                rank2 = i;
                i = 4;
            }

        // a month is defined as 30.4375 days
        double answer = (default1 / 8 * 2629800) / Math.pow(1000, rank2);

        System.out.println(bandwidthSize + " " + bandwidthUnit + " is "
                + "equivalent to " + answer + " " + usageUnit + " per month.");
    }
}