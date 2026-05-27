import java.util.ArrayList;
import java.util.List;

public class SalaryAnalyzer {

    public boolean isNumeric(String line) {

        return line != null && line.matches("-?\\d+(\\.\\d+)?");
    }

    public List<Double> getValidNumbers(List<String> fileLines){

        List<Double> validNumbers = new ArrayList<>();

        for(String line : fileLines){

            if(isNumeric(line)){

                validNumbers.add(Double.parseDouble(line));
            }
        }

        return validNumbers;
    }

    public int[] countEntries(List<String> fileLines){

        int validEntries = 0;
        int invalidEntries = 0;

        for(String line : fileLines){

            if(isNumeric(line)){
                validEntries++;
            } else {
                invalidEntries++;
            }
        }

        return new int[]{validEntries, invalidEntries};
    }

    public double findHighestSalary(List<Double> validNumbers){

        if(validNumbers.isEmpty()){
            return -1;
        }

        double max = validNumbers.get(0);

        for(double number : validNumbers){

            if(number > max){
                max = number;
            }
        }

        return max;
    }

    public double calculateAverageSalary(List<Double> validNumbers){

        if(validNumbers.isEmpty()){
            return -1;
        }

        double sum = 0;

        for(double number : validNumbers){

            sum += number;
        }

        return sum / validNumbers.size();
    }
}