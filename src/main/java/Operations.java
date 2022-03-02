import java.util.ArrayList;

public class Operations {
    private Polynom result;
    private Polynom reminder;

    public Polynom getReminder() {
        return reminder;
    }

    public Operations() {
        this.result= new Polynom();
        this.reminder= new Polynom();
    }

    public  Polynom getResult() {
        return result;
    }

    public  void addition(Polynom a,Polynom b) {
        int i = 0, j = 0;
        double aux;
        while (i < a.getP1().size() && j < b.getP1().size()) {
            if (a.getP1().get(i).getPower() > b.getP1().get(j).getPower()) {
                result.getP1().add(a.getP1().get(i));
                i++;
            } else {
                if (a.getP1().get(i).getPower() < b.getP1().get(j).getPower()) {
                    result.getP1().add(b.getP1().get(j));
                    j++;
                } else {
                    aux = a.getP1().get(i).getCoefficient() + b.getP1().get(j).getCoefficient();
                    Monom m = new Monom(aux, a.getP1().get(i).getPower());
                    result.getP1().add(m);
                    i++;
                    j++;
                }
            }

        }
        while(i < a.getP1().size()){
            result.getP1().add(a.getP1().get(i));
            i++;
        }
        while(j < b.getP1().size()){
            result.getP1().add(b.getP1().get(j));
            j++;
        }
    }

    public  void subtraction(Polynom a, Polynom b) {
        int i = 0, j = 0;
        double aux;
        while (i < a.getP1().size() && j < b.getP1().size()) {
            if (a.getP1().get(i).getPower() > b.getP1().get(j).getPower()) {
                result.getP1().add(a.getP1().get(i));
                i++;
            } else {
                if (a.getP1().get(i).getPower() < b.getP1().get(j).getPower()) {
                    result.getP1().add(new Monom(-b.getP1().get(j).getCoefficient(),b.getP1().get(j).getPower()));
                    j++;
                } else {
                    aux = a.getP1().get(i).getCoefficient() - b.getP1().get(j).getCoefficient();
                    Monom m = new Monom(aux, a.getP1().get(i).getPower());
                    if(aux!=0){

                        result.getP1().add(m);
                    }

                    i++;
                    j++;
                }
            }

        }
        while(i < a.getP1().size()){
            result.getP1().add(a.getP1().get(i));
            i++;
        }
        while(j<b.getP1().size()){
            result.getP1().add(new Monom(-b.getP1().get(j).getCoefficient(),b.getP1().get(j).getPower()));
            j++;
        }
    }

    public void multiplication(Polynom a, Polynom b){
        Polynom partialResult= new Polynom();
        for (Monom monom : a.getP1()) {
            for (Monom value : b.getP1()) {
                partialResult.getP1().add(new Monom(monom.getCoefficient() * value.getCoefficient(), monom.getPower() + value.getPower()));
            }
        }
        int i=0;
        partialResult.getP1().sort((o1, o2) -> o2.getPower().compareTo(o1.getPower()));
        for (Monom p1 : new ArrayList<>(partialResult.getP1())){
            if(i==0 || result.getP1().get(i-1).getPower()>p1.getPower()) {
                result.getP1().add(p1);
                for (Monom p2 : new ArrayList<>(partialResult.getP1())){
                    if(p2.getPower().equals(p1.getPower())&& p2!=p1){
                        result.getP1().get(i).setCoefficient(result.getP1().get(i).getCoefficient()+p2.getCoefficient());
                        partialResult.getP1().remove(p2);
                    }
                }
                i++;
           }
        }
    }

    public Monom getFirst(ArrayList<Monom> m){
        if( !m.isEmpty()){
            for(Monom monom:m){
                if(monom.getCoefficient()!=0){
                    return monom;
                }
            }
        }
        return new Monom(0.00,0);
    }

    public void division(Polynom a, Polynom b){
        while(getFirst(a.getP1()).getPower()>=b.getP1().get(0).getPower() && !a.getP1().isEmpty()){
            Monom c=new Monom(a.getP1().get(0).getCoefficient()/b.getP1().get(0).getCoefficient(),a.getP1().get(0).getPower()-b.getP1().get(0).getPower());
            result.getP1().add(c);
            Polynom aux= new Polynom();
            for(Monom monom:b.getP1()){
                aux.getP1().add(new Monom(monom.getCoefficient()*c.getCoefficient(), monom.getPower()+c.getPower()));
            }
            Operations x=new Operations();
            x.subtraction(a,aux);
            x.getResult().getP1().removeIf(monom -> monom.getCoefficient() == 0);
            a.setP1(x.getResult());
        }
        reminder=a;
    }

    public void derivation(Polynom a){
        for (Monom monom : a.getP1()){
            if(monom.getPower()>0){
                result.getP1().add(new Monom(monom.getCoefficient()* monom.getPower(), monom.getPower()-1));
            }
        }
    }

    public void integration(Polynom a){
        for (Monom monom : a.getP1()){
            result.getP1().add(new Monom(monom.getCoefficient()/(monom.getPower()+1), monom.getPower()+1));
        }
    }

}
