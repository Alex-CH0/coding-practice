import java.util.List;

public class GridSearch {
    public  String gridSearch(List<String> G, List<String> P) {
        // 테스트 케이스 5개 미통과

        System.out.println("Start");
        int gridLength = G.size();
        int patternLength = P.size();
        int patternFound = 0;

        if(patternLength>gridLength)
            return "NO";

        loop:
        for(int i=0;i<=gridLength - patternLength;i++){
            String gridRow = G.get(i);
            int patternIndex =0;
            int charIndex =-1;
            int newI = i;
            String pattern = P.get(patternIndex);

            if(gridRow.contains(pattern)){
                patternFound++;
                charIndex = gridRow.indexOf(pattern);
                System.out.println("First Found in row : "+i);
            }else{
                patternFound=0;
                continue loop;
            }

            while(patternFound<patternLength){
                System.out.println("got into While");

                newI++;
                patternIndex++;

                System.out.println("i" + newI);
                System.out.println("patternIndex" + patternIndex);

                pattern= P.get(patternIndex);
                gridRow = G.get(newI);

                System.out.println("pattern" + pattern);

                if(gridRow.contains(pattern) && gridRow.indexOf(pattern)==charIndex){
                    patternFound++;
                    System.out.println("Found" + patternFound);
                    if(patternFound==patternLength){
                        break loop;

                    }
                }else{
                    patternFound=0;
                    if(gridLength==patternLength){
                        return "NO";
                    }
                    continue loop;
                }
            }
        }
        return patternFound==patternLength? "YES":"NO";

    }

}
