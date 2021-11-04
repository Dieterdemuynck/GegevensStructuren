public class MyMajority implements Majority{
    @Override
    public int findMajority(Sequence numbers) {
        return findMajority(numbers, 0, numbers.size());
    }
    public int findMajority(Sequence numbers, int start, int end) {
        int amount = end - start;
        if (amount == 0) return -1;
        if (amount == 1) return numbers.get(start);
        int center = amount/2 + start;

        int leftMaj = findMajority(numbers, start, center);
        int rightMaj = findMajority(numbers, center+1, end);

        if (leftMaj == rightMaj) return leftMaj;

        // No majority element found,
        return Math.max(countAmount(numbers, start, end, leftMaj), countAmount(numbers, start, end, rightMaj));
    }

    private int countAmount(Sequence numbers, int start, int end, int majElement){
        if (majElement == -1) return -1;
        int majAmount = (end - start)/2;

        int counter = 0;
        for (int i = start; i < end; i++) {
            if (numbers.get(i) == majElement) {
                counter++;
                if (counter > majAmount) return majElement;
            }
        }
        return -1;
    }
}
