// This code is incredibly messy in my opinion, which means it's probably pure garbage.
// I mean, I'm a total newbie at Java, so it makes sense. It's still embarrassing though.
// EDIT: I'm just an idiot, the proper algorithm is way easier.
import java.util.List;

public class MijnDrieSomProbleem implements DrieSomProbleem {

    @Override
    public TripletIndices zoekNulSomTriplet(List<Integer> sortedInput) {
        int leftMost;
        int rightMost;
        int sum;
        for (int i = 0; i < sortedInput.size() - 2; i++) {
            leftMost = i + 1;
            rightMost = sortedInput.size() - 1;
            while (leftMost != rightMost){
                sum = sortedInput.get(leftMost) + sortedInput.get(rightMost) + sortedInput.get(i);
                if (sum == 0){
                    return new TripletIndices(i, leftMost, rightMost);
                } else if (sum > 0){
                    rightMost--;
                } else {
                    leftMost++;
                }
            }
        }
        return null;
    }
    // Original, way overcomplicated code down below.
    // I can't believe I overcomplicated the algorithm so damn much. Just... Wow.
    // I'm impressed, both by the code I've written and my own stupidity.
//    @Override
//    public TripletIndices zoekNulSomTriplet(List<Integer> sortedInput) {
//        if (sortedInput.size() < 3) {
//            // there can't be three elements which sum up to zero if there are less than three elements.
//            return null;
//        }
//        int firstPos = searchFirstPos(sortedInput);
//        if (firstPos <= sortedInput.size() - 3 && sortedInput.get(firstPos + 2) == 0) {
//            // If the third positive number is 0, there's a sequence of at least three zeroes.
//            // We handle this case separately, due to the fact that 0 is considered positive.
//            return new TripletIndices(firstPos, firstPos + 1, firstPos + 2);
//        }
//        if (firstPos == 0 || firstPos == -1) {
//            // If there are either no strictly positive or no strictly negative numbers, and there are no three zeroes,
//            // the sum of three elements will always be strictly positive or strictly negative respectively.
//            return null;
//        }
//        // Trivial cases are done, now comes the real algorithm:
//        // For every element in the list, we can add the smallest negative number and the largest positive number to it.
//        // After doing so, we can constantly "shift" the negative or positive index over until the sum is zero,
//        // this because the list is sorted. If the sum is strictly positive, we need a smaller positive number.
//        // If the sum is strictly negative, we need a bigger negative number.
//        // If either the positive numbers or negative numbers are "exhausted", there is no sum which leads to 0 with
//        // this first element, so we continue to the next.
//        int negIndex = 1;
//        int posIndex = sortedInput.size() - 1;
//        int sum;
//        for (int i = 0; i < sortedInput.size() - 2; i++) {
//            if (i == firstPos - 1) {
//                // negIndex is now actually firstPos, so reset this back to the start of the list.
//                // From this point on i is positive, and we'll do all calculations with only one negative number
//                negIndex = 0;
//                continue;
//            }
//            while (negIndex < firstPos && posIndex >= firstPos && posIndex > i) {
//                sum = sortedInput.get(i) + sortedInput.get(negIndex) + sortedInput.get(posIndex);
//                if (sum == 0) {
//                    if (i >= firstPos) {
//                        return new TripletIndices(negIndex, i, posIndex);
//                    }
//                    return new TripletIndices(i, negIndex, posIndex);
//                } else if (sum > 0) {
//                    posIndex--;
//                } else {
//                    negIndex++;
//                }
//            }
//            // After the while loop, no triplet has been returned. This means there is no sum equal to 0 with var i.
//            // Take the next element, and reset negIndex and posIndex. This reset depends on var i.
//            if (i >= firstPos) {
//                negIndex = 0;
//            } else {
//                negIndex = i + 2;
//            }
//            posIndex = sortedInput.size() - 1;
//        }
//        return null;
//    }
//
//    /**
//     * Search for the first positive integer in a sorted list, and return the index.
//     * If size is 0 or there are no positive integers, return -1.
//     * If three consecutive zeroes are found, it immediately returns the index of third last zero it found.
//     * In the worst case, this function is logarithmic (I believe).
//     */
//    public int searchFirstPos(List<Integer> sortedInput){
//        if (sortedInput.size() == 0 || sortedInput.get(sortedInput.size()-1) < 0){
//            // we know there is no positive integer (either the list is empty or the largest number is negative)
//            return -1;
//        }
//        int start = 0;
//        int end = sortedInput.size() - 1;
//        int i = end / 2;  // start is 0 at first
//        while (start != end){
//            if (sortedInput.get(i) == 0){
//                break;
//            }
//            if (sortedInput.get(i) > 0){
//                end = i - 1;
//            } else {
//                start = i + 1;
//            }
//            i = start + (end - start) / 2;
//        }
//        if (sortedInput.get(start) == 0){
//            // We redefine i to be a counter for the amount of zeroes we found.
//            i = 1;
//            while (start > 0 && sortedInput.get(start-1) == 0 && i < 3){
//                // If we found 0, it might be possible we don't have the *first* 0 element.
//                // In this case, move through the list until we found the first, or until we've gone through 3 zeroes.
//                start--;
//                i++;
//            }
//        }
//        return start;
//    }
//
}