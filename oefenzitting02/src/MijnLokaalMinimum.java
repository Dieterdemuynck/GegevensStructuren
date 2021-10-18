public class MijnLokaalMinimum implements LokaalMinimum{
    @Override
    public int lokaalMinimum(int[] row) {
        int start = 0;
        int end = row.length - 1;
        int i = end / 2;  // start is 0 at first
        while (0 < i && i < row.length - 1){  // Why I don't check if start != end becomes clear later
            if (row[i-1] > row[i] && row[i] < row[i+1]){
                return row[i];  // WE FOUND IT
            }
            if (row[i-1] < row[i]){  // There is a minimum towards the left. We can move to the left.
                end = i - 1;
            } else {  // There is a minimum towards the right. We can move to the right.
                start = i + 1;
            }
            i = start + (end - start) / 2;
        }
        // If start == end, that means we MUST have found a local minimum.
        // Thus, reaching this part of the code, i MUST be either 0 or n-1, which means we constantly moved down
        // towards the ends of the row. This means row[i] is sure to be a local minimum, UNLESS it is 0
        // due to how flooring works. It could be that element 1 is the actual local minimum.
        if (i == 0 && row[i+1] < row[i]){
            return row[i+1];
        }
        return row[i];
    }
}
