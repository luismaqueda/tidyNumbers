package com.luismaqueda.helper;

import com.luismaqueda.dto.TidyCase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Helper {

    static String header = "Input"+ getBlanks(0L) +"Output";
    static String numCasesLine = "%d";
    static String caseLine = "%d%sCase #%d: %d";

    final static int BLANKS = 50;


    public static TidyCase getTidyCaseFromStreamFromFile(String fileNamePath) {

        List<String> result = null;
        try (Stream<String> stream = Files.lines(Paths.get(fileNamePath))) {
            result = stream.collect(Collectors.toList());
            return convertToTidyCase(result);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }


    /**
     *
     * @param rawData that contains the number of cases to analyze and the cases as well
     * @return an object with the cases translated to Integer values and the number of cases.
     */
    public static TidyCase convertToTidyCase(List<String> rawData) {
        TidyCase tidyCase = new TidyCase();
        tidyCase.setNumberOfCases(Integer.valueOf(rawData.get(0)).intValue());
        List<Long> theCases = new ArrayList<Long>();
        rawData.subList(1,rawData.size()-1).forEach(line->theCases.add(new Long(line)));
        tidyCase.setTheCases(theCases);
        return tidyCase;
    }

    public static Long getTidyNumber(final Long maxNumber) {

        try {
            final String aux = Long.toString(maxNumber);
            if (aux.length() <=1) {
                return maxNumber;
            } else {

                final char[] chars = convertToCharArray(aux);
                final boolean result = ascendingOrderedNumber(chars);

                if (result) {
                    return maxNumber;
                } else {
                    return getTidyNumber(maxNumber - 1);
                }
            }

        } catch (Error e) {
            return -1L;
        }

    }

    private static boolean ascendingOrderedNumber(char[] array)
    {
        boolean result = true;
        for(int j=0;j<array.length - 1 && result;j++) {
            result = result && Integer.valueOf(array[j]) <= Integer.valueOf(array[j+1]);
        }
        return result;
    }



    private static char[] convertToCharArray(String caseToStudy) {
        char[] result = new char[caseToStudy.length()];
        for (int i=0;i<caseToStudy.length();i++) {
            result[i] = caseToStudy.charAt(i);
        }

        return result;
    }


    public static void printTidyCase(TidyCase tidyCase) {


        /*
        Input               Output

        4
        132                 Case #1: 129
        1000                Case #2: 999
        7                   Case #3: 7
        111111111111111110  Case #4: 99999999999999999
        */

        System.out.println(header);
        System.out.println("");
        System.out.println(String.format(numCasesLine,tidyCase.getNumberOfCases()));
        int index = 1;
        for(Long currentCase : tidyCase.getTheCases()) {
            System.out.println(
                String.format(caseLine,currentCase, getBlanks(currentCase),(index++),Helper.getTidyNumber(currentCase))
            );
        }
    }

    private static String getBlanks(Long currentCase) {
        int numberLength = currentCase.toString().length();
        StringBuffer blanks = new StringBuffer();
        for (int i=0;i< BLANKS - numberLength; i++) {
            blanks.append(" ");
        }
        return blanks.toString();
    }

}
