import java.util.Collections;
import java.util.List;

public class MySorter implements Sorter{
    @Override
    public void sort(List<Integer> list) {
        if (list.size() != 0){  // As long as we have a list to sort, we sort.
            int pivot = partition(list);

            sort(list.subList(0, pivot));
            sort(list.subList(pivot + 1, list.size()));
        }
    }

    private int partition(List<Integer> list){
        int pivot = list.size() - 1;
        int pivotEl = list.get(pivot);
        int j = 0;  // first known element >= pivotEl

        for (int i = 0; i < pivot; i++){
            if (list.get(i) < pivotEl){
                Collections.swap(list, i, j);
                j++;
            }
        }

        Collections.swap(list, pivot, j);
        return j;  // We return where the pivot element is now.
    }
}
