import java.util.List;

public class MijnZoeker implements Zoeker{

    @Override
    public Persoon zoekBeroemdheid(List<Persoon> groep){
        // OBVIOUS CASES
        if (groep.size() == 0){
            return null;  // empty list -> no famous people
        }
        if (groep.size() == 1){
            return groep.get(0);  // one person -> he both knows everyone and no other person knows him -> he's famous
        }

        int candidateIndex = 0; // Candidate
        int nextCandidateIndex = 1; // Possible next candidate
        while (nextCandidateIndex < groep.size()){
            if (groep.get(candidateIndex).kent(groep.get(nextCandidateIndex))){
                candidateIndex = nextCandidateIndex;
            }
            nextCandidateIndex++;
        }
        // candidate is now the only candidate.
        // Check to see if everyone knows them, and if they don't know any of the people that we haven't
        // tested yet.
        Persoon candidate = groep.get(candidateIndex);
        for (int i = 0; i < groep.size(); i++){
            if (i == candidateIndex){
                continue; // they obviously know themselves, this should be skipped
            }
            if (i < candidateIndex && candidate.kent(groep.get(i))){  // allows for fewer calls to Persoon.kent()
                return null;  // if we find someone that our candidate does know, he can't be famous
            }
            if (!groep.get(i).kent(candidate)){
                return null;  // if we find someone who doesn't know the candidate, our candidate can't be famous
            }
        }
        return groep.get(candidateIndex);
    }
}
