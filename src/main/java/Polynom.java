import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynom {
    ArrayList<Monom> p1;

    public ArrayList<Monom> getP1() {
        return p1;
    }

    public void setP1(Polynom p1) {
        this.p1 = p1.getP1();
    }

    public Polynom() {
        this.p1 = new ArrayList<>();
    }

    public static boolean isNumeric(String str) {

        return str.matches("[+-]*\\d*\\.?\\d+");
    }

    public void readPolynomial(String s){
        p1.clear();
        String monomialFormat = "([+-]?[\\d]*[a-zA-Z]?\\^?\\d*)", monomialPartsFormat = "([+-]?[\\d]*)([a-zA-Z]?)\\^?(\\d*)";
        Pattern pattern1 = Pattern.compile(monomialFormat);
        Matcher matcher1 = pa1.matcher(s);
        while (!m1.hitEnd()) {
            matcher1.find();
            Pattern pattern2 = Pattern.compile(monomialPartsFormat);
            Matcher matcher2 = pattern2.matcher(m1.group());
            if (matcher2.find()) {
                double coefficient;
                try {
                    String coef = matcher2.group(1);
                    if (isNumeric(coef)) {
                        coefficient = Double.parseDouble(coef);
                    } else {
                        coefficient =Double.parseDouble(coef+"1");
                    }
                } catch (IllegalStateException e) {
                    coefficient = 0.00;
                }

                int exponent;
                try{
                    String exp = matcher2.group(3);
                    if (isNumeric(exp)) {
                        exponent = Integer.parseInt(exp);
                    } else {
                        exponent = 1;
                    }
                }catch (IllegalStateException e) {
                    exponent = 0;
                }
                p1.add(new Monom(coefficient, exponent));
            }
        }
        p1.sort((o1, o2) -> o2.getPower().compareTo(o1.getPower()));
    }

    public String polyToString(){
        StringBuilder aux= new StringBuilder();int i;
        for ( i=0;i<p1.size()-1;i++) {
            DecimalFormat df = new DecimalFormat("#.##");
            p1.get(i).setCoefficient(Double.valueOf(df.format(p1.get(i).getCoefficient())) );
            if(p1.get(i).getCoefficient()!=1) {
                aux.append(p1.get(i).getCoefficient()).append("x^").append(p1.get(i).getPower()).append("+");
            }
            else
            {
                aux.append("x^").append(p1.get(i).getPower()).append("+");
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        p1.get(i).setCoefficient(Double.valueOf(df.format(p1.get(i).getCoefficient())) );
        if(p1.get(i).getPower()!=0){
            if(p1.get(i).getCoefficient()!=1) {
                aux.append(p1.get(i).getCoefficient()).append("x^").append(p1.get(i).getPower());
            }
            else
            {
                aux.append("x^").append(p1.get(i).getPower());
            }
        }
        else{
            aux.append(p1.get(i).getCoefficient());
        }
        return aux.toString();
    }
}
