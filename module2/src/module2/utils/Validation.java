package module2.utils;

import faramaResort.controllers.FuramaController;

public class Validation {

    static public boolean checkDate(String date) {
        String REGEX_BIRTHDAY = "[0-9]{1,2}/[0-9]{1,2}/20[2-9][0-9]";
        if (date.matches(REGEX_BIRTHDAY)) {
            String[] dayOfBirthArray = date.split("/");
            if ((Integer.parseInt(dayOfBirthArray[1])) < 0 || (Integer.parseInt(dayOfBirthArray[1])) > 12) {
                return false;
            } else {
                switch (Integer.parseInt(dayOfBirthArray[1])) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (Integer.parseInt(dayOfBirthArray[0]) < 0 || (Integer.parseInt(dayOfBirthArray[0]) > 31)) {
                            return false;
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (Integer.parseInt(dayOfBirthArray[0]) < 0 || (Integer.parseInt(dayOfBirthArray[0]) > 30)) {
                            return false;
                        }
                        break;
                    case 2:
                        if ((Integer.parseInt(dayOfBirthArray[2]) % 4 == 0 && Integer.parseInt(dayOfBirthArray[2]) % 100 != 0) || Integer.parseInt(dayOfBirthArray[2]) % 400 == 0) {
                            if (Integer.parseInt(dayOfBirthArray[0]) < 0 || Integer.parseInt(dayOfBirthArray[0]) > 29) {
                                return false;
                            }
                        } else {
                            if (Integer.parseInt(dayOfBirthArray[0]) < 0 || Integer.parseInt(dayOfBirthArray[0]) > 28) {
                                return false;
                            }
                        }
                }

                return true;
            }
        }
        return false;
    }

}
