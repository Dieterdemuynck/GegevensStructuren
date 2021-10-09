import java.util.Collections;
import java.util.List;

public class MyParty implements Party {
    @Override
    public boolean check(List<Interval> helpers, int start, int stop){
        if (start >= stop){
            // The work hours for a non-existing party can always be filled in
            return true;
        }
        if (helpers.size() == 0){
            // No one can help out (why even input this?)
            return false;
        }

        // Here comes the real sh!t:
        // We sort the list by start time. With this, we can check if there's a continuous stream of helpers.
        Collections.sort(helpers);

        // We run through the list until we've found someone whose interval lines up with the start of the party
        int firstHelper = helpers.size();  // if there's no first helper, this will skip the next for loop
        int helperStop = start;
        // ...this means we immediately return false.
        for (int i = 0; i < helpers.size(); i++){
            if (helpers.get(i).getStop() > start){
                // We found someone whose interval lines up
                if (helpers.get(i).getStart() > start){
                    // it's possible they don't actually start before or at the start of the party. If this is the case:
                    // No one starts out at the proper time
                    return false;
                }
                // They line up with the start => initialise helperStop:
                helperStop = helpers.get(i).getStop();  // The time when help from helpers stops
                firstHelper = i;
                break;
            }
        }
        for (int i = firstHelper; i < helpers.size(); i++){
            if (helperStop < helpers.get(i).getStart()){
                // due to the sorted list, we now know there is no one who'll start helping at the last stop time
                return false;
            } else {
                // next helper can start before last stop time, we might be able to extend the stop time
                helperStop = Math.max(helperStop, helpers.get(i).getStop());

                if (helperStop >= stop) {
                    // The party interval has been entirely filled in
                    return true;
                }
            }
        }
        // So far, there has been a continuous stream of helpers from the start, but the party interval hasn't been
        // filled in yet.
        return false;
    }
}
