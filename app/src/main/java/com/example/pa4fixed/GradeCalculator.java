package com.example.pa4fixed;

public class GradeCalculator {
    //fields
    private float minAverage;
    private float curAverage;
    private float finalPercent;


    // Methods
    /**
     * EVC for a grade calculator
     * @param minAverage
     * @param curAverage
     * @param finalPercent
     */
    public GradeCalculator(float minAverage, float curAverage, float finalPercent) {
        this.minAverage = minAverage;
        this.curAverage = curAverage;
        this.finalPercent = finalPercent;
    }


    public float calculateFinalGrade() {
        float neededGrade = (minAverage - ((100-finalPercent)/100)*curAverage)/finalPercent;
        return neededGrade;
    }
}
