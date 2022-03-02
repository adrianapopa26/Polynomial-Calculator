public class Monom {
    private  Double coefficient;
    private Integer power;

    public Monom(Double coefficient, Integer power) {
        this.coefficient =coefficient;
        this.power =power;
    }

    public  Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}
