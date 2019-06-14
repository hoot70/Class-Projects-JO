import java.util.ArrayList;

import java.util.List;

class Board {
    StringBuilder Board(String stuff, ArrayList<String> array) {
        var arr = stuff.split("");
        StringBuilder total = new StringBuilder("");
        for (String a: arr){
            StringBuilder sup = new StringBuilder(a);
            StringBuilder blank = new StringBuilder("_");
            sup.append(" ");
            blank.append(" ");
            List<String> list = new ArrayList<>(array);

            if (list.contains(a)) {
                total.append(sup);
            } else if (list.contains(a) && a.equals(" ")){
                total.append(sup.append("  "));
            }
            else {
                total.append(blank);
            }
        }
        return total;
    }

}

