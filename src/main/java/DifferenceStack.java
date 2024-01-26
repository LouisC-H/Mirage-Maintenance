public class DifferenceStack {

    private Integer[] intList;
    private DifferenceStack nextLayer;
    private DifferenceStack previousLayer;
    private int newValue;

    public DifferenceStack(String inputData) {
        String[] numberSplit = inputData.split(" ");
        this.intList = new Integer[numberSplit.length];
        for (int i = 0; i < numberSplit.length; i++) {
            intList[i] = Integer.valueOf(numberSplit[i]);
        }
        stackManagement();
    }

    public DifferenceStack(Integer[] calculatedDifferences, DifferenceStack parentStack) {
        this.intList = calculatedDifferences;
        this.previousLayer = parentStack;
        stackManagement();
    }

    private void stackManagement() {
////        part 1
//        if (!checkIfAllZeros()){
//            createNextLayer();
//            this.newValue = nextLayer.getNewValue() + intList[intList.length-1];
//        } else {
//            this.newValue = 0;
//        }
        //        part 2
        if (!checkIfAllZeros()){
            createNextLayer();
            this.newValue = - nextLayer.getNewValue() + intList[0];
        } else {
            this.newValue = 0;
        }
    }

    private void createNextLayer() {
        Integer[] calculatedDifferences = new Integer[intList.length - 1];
        for (int i = 0; i < calculatedDifferences.length; i++) {
            calculatedDifferences[i] = intList[i+1] - intList[i];
        }
        this.nextLayer = new DifferenceStack(calculatedDifferences, this);
    }

    private boolean checkIfAllZeros() {
        boolean allZeros = true;
        for (int i: intList) {
            if (i != 0){
                allZeros = false;
                break;
            }
        }
        return allZeros;
    }

    public int getNewValue() {
        return newValue;
    }
}
