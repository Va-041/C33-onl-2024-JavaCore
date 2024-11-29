package lesson1.homework;

/**
 *<a>This is my first homework assignment in the Java developer courses from TeachMeSkills, which I am doing
 * <p>I hope that I will be able to successfully carry them out in the future
 * </p>
 *</a>
 * @author Soroka Vadim, C33-onl2024
 */

class HomeworkLessonOne {               //here I follow the first rule from the Java Code Conventions... class = noun, UpperCamel
    public static void main(String[] args) {
        // main is entry-point

        //Method call
        getBasicInformationOnJava();
        setBasicVariables();
        arithmeticOperators();

    }
    public static void getBasicInformationOnJava() { // here I follow the fifth rule JCC... method = verb,LowerCamel
        System.out.println("\nThis is a method with basic information about the Java language, called using next line");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println();
    }

    public static void setBasicVariables() {
        System.out.print("This is a method with basic information about variables, called without using next line\n");
        System.out.println();

        System.out.println("= = = = Integer = = = =");
        byte byteValue = 11;
        System.out.println("byteValue = " + byteValue + " -> this is a primitive 8-bit integer byte-type variable " +
                "with a value range of -128 ~ 127");

        short shortValue = 5533;
        System.out.println("shortValue = " + shortValue + " -> this is a primitive 16-bit integer short-type variable" +
                " with a value range of -32768 ~ 32767");
        System.out.println("These types are practically not used at the moment, only in exceptional cases\n");
        // Byte and short used for memory saving, no more actual unless you have very little memory
        // If you use byte and short in arithmetic operations and/or pass it as parameters they will by default
        // turn to integer

        char charValue = 'V';
        System.out.println("charValue = " + charValue + " -> this is a primitive 16-bit integer char-type integer " +
                "variable which is officially it is a integer value, but factually it is a character");

        char charASCIIValue = 90;
        System.out.println("charASCIIValue = " + charASCIIValue + " -> this is the same integer char-type variable, " +
                "but written using the character code from the ASCII-table in decimal representation");

        int intValue = 225133;
        System.out.println("intValue = " + intValue + " -> this is a primitive 32-bit integer int-type variable with " +
                "a value range of -2147483648 ~ 2147483647");

        long longValue = 18_05_2004L;
        System.out.println("longValue = " + longValue + " -> this is a primitive 64-bit integer long-type variable " +
                "with a range of -9223372036854775808 ~ 9223372036854775808 and a special suffix L");
        System.out.println("\nUnderscores are used to separate large numbers for easier readability (to see how many " +
                "digits are in a number)\n" + "\n" + "Special suffixes for long (for example, 39832L), " +
                "float (for example, 2.4) and double (for example, -7.832D) are needed so that the compiler does " +
                "not try to lower the data type (for example, when writing long longValue = 2; the compiler will " +
                "think why allocate long memory for an ordinary two, if it has enough int, and He will count himself");


        // float PI = 3.1415F; -> f, F
        // double PI = 3.1415; -> if arithmetic or parameters needed
        System.out.println("\n\n= = = = Floating numbers = = = =");
        float floatValue = 18.999F; // . 7 numbers
        System.out.println("floatValue = " + floatValue + " -> this is a primitive 32-bit floating point variable " +
                "of the float-type with a range of values 1.4e-45f ~ 3.4e+38f ( . 7 numbers)");

        double doubleValue = 555.554433; // . 15 numbers, by default
        System.out.println("doubleValue = " + doubleValue + " -> this is a primitive 64-bit floating point variable " +
                "of the double-type with a range of values 4.9e-324f ~ 1.7e+308 ( . 15 numbers); default for " +
                "arithmetic operations and value transfer");

        // C/C++ !!! in Java boolean means boolean, only TRUE or FALSE
        // C/C++ 0 == false, != 0 true
        System.out.println("\n\n= = = = Logical variable = = = =");
        boolean isAlive = true;
        boolean isMarried = false;
        System.out.println(isMarried);
        System.out.println(isAlive);

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

    public static void arithmeticOperators() {
        System.out.println("\nThis is a method with basic arithmetic operators\n");

        int height = 182;
        double weight = 65.4;

        int getSumHeightAddition = height + (height / 10);
        System.out.println("getSumHeight = " + getSumHeightAddition);

        double getSumWeightDivided =  weight / 2 + getSumHeightAddition;
        System.out.println("getSumWeight = " + getSumWeightDivided);

        float getSumWeightSubtraction = (float) (weight - 44.3456f);    // casting...?
        System.out.println("getSumWeightSubtraction = " + getSumWeightSubtraction);

        int getMultipleHeightModulus = 24;
        long multipleFactor = 5;
        getMultipleHeightModulus = (int) (height * multipleFactor) % getMultipleHeightModulus;
        System.out.println("getMultipleHeightModulus = " + getMultipleHeightModulus);

        int valueIncrement = 99;
        valueIncrement++;
        System.out.println("valueIncrement = " + valueIncrement);

        int valueDecrement = 112;
        valueDecrement--;
        System.out.println("valueDecrement = " + valueDecrement);
    }
}