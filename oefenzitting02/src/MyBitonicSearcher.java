public class MyBitonicSearcher implements BitonicSearcher {
    @Override
    public int bitonicSearch(Sequence numbers, int query) {
        if (numbers.size() == 0) return -1; // Empty sequence
        if (numbers.size() == 1){
            if (numbers.get(0) == query) return 0;
            return -1;
        }
        if (numbers.size() == 2){
            if (numbers.get(0) == query) return 0;
            if (numbers.get(1) == query) return 1;
            return -1;
        }

        // Size is larger than 2, we can check for the top in a list without first and last element.
        int start = 1;
        int end = numbers.size() - 1;
        int center = (end - start)/2 + start;
        int current = numbers.get(center);

        // First, we find the top. From there, we can perform a binary search left and right of top for the query.
        int top = -1;

        while (start < end){  // we use "<" instead of "!=" since this allows us to "test" for 1 element too.
            if (current < numbers.get(center - 1)){
                end = center - 1;
            } else {
                if (current < numbers.get(center + 1)) {
                    start = center + 1;
                } else {
                    top = center;
                    break;
                }
            }
            center = (end - start)/2 + start;
            current = numbers.get(center);
        }
        // Top value hasn't been adjusted, this means the top isn't in the previously mentioned inner list.
        // Check if the top is either the left- or right-most element.
        if (top == -1 && start == 1){
            top = 0;
        } else if (top == -1){
            top = end + 1;
        }

        // We've got the top. Now, we perform simple binary searches on both sides of the pyramid, until
        // the query element is found.
        int leftResult = binarySearch(numbers, 0, top, query);
        if (leftResult != -1) return leftResult;
        return reverseBinarySearch(numbers, top, numbers.size(), query);
    }

    private int binarySearch(Sequence numbers, int start, int end, int query){
        int center = (end - start)/2 + start;
        while (start < end){
            if (numbers.get(center) == query){
                return center;
            }
            if (numbers.get(center) > query){
                end = center;
            } else {
                start = center + 1;
            }
            center = (end - start)/2 + start;
        }
        return -1;  // element not in list
    }

    private int reverseBinarySearch(Sequence numbers, int start, int end, int query){
        int center = (end - start)/2 + start;
        while (start < end){
            if (numbers.get(center) == query){
                return center;
            }
            if (numbers.get(center) < query){
                end = center;
            } else {
                start = center + 1;
            }
            center = (end - start)/2 + start;
        }
        return -1;  // element not in list
    }
}
