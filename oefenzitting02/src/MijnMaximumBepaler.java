public class MijnMaximumBepaler implements MaximumBepaler{
    @Override
    public int bepaalMaximum(int... row) {
        if (row.length == 0) {
            throw new IllegalArgumentException();
        }
        int start = 0;
        int end = row.length - 1;
        int i = end / 2;  // start is 0 at first
        while (start != end){
            if (row[i] > row[i+1]) {
                return row[i];
            } else if (row[0] > row[i]) {
                end = i - 1;
            } else {
                start = i + 1;
            }
            i = start + (end - start) / 2;
        }
        return row[i]; // i is now either the start or end of the row
    }
}
