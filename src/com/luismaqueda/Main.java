package com.luismaqueda;

import com.luismaqueda.dto.TidyCase;
import com.luismaqueda.helper.Helper;

public class Main {

    public static void main(String[] args) {



        // ############################################################################################
        // ############################################################################################
        // ################ This is the small-practice example given at code.google page. #############
        // ############################################################################################
        // ############################################################################################

        String fileName1 = "resources/small-practice.in";
        TidyCase smallPracticeTidyCase = Helper.getTidyCaseFromStreamFromFile(fileName1);
        Helper.printTidyCase(smallPracticeTidyCase);

        // ############################################################################################
        // ############################################################################################
        // ################ This is the large-practice example given at code.google page. #############
        // ############################################################################################
        // ############################################################################################

        String fileName2 = "resources/large-practice.in";
        TidyCase largePracticeTidyCase = Helper.getTidyCaseFromStreamFromFile(fileName2);
        Helper.printTidyCase(largePracticeTidyCase);


    }
}
