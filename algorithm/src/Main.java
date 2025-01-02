import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {




        int N = 5;
        String binary = Integer.toBinaryString(N);
        System.out.println(binary);

        String [] biArray = binary.split("0");
        List<String> binaryList = new ArrayList<>(Arrays.asList(biArray));
        binaryList.removeAll(Arrays.asList(" ", ""));
        int size = binaryList.size()-1;


        System.out.println(binaryList);

        biArray = binary.split("1");
        binaryList = new ArrayList<>(Arrays.asList(biArray));
        binaryList.removeAll(Arrays.asList(" ", ""));

        System.out.println(binaryList);

        int max =0;
        for(String s : binaryList){
            max = Math.max(s.length(), max);
        }
        System.out.println(max);




        }
    }
