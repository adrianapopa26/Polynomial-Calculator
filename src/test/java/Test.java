import org.junit.jupiter.api.Assertions;

public class Test {

    @org.junit.jupiter.api.Test
    void testAddition() {
        Polynom y=new Polynom();
        y.getP1().add(new Monom(1.00,3));
        y.getP1().add(new Monom(4.00,2));
        y.getP1().add(new Monom(5.00,0));

        Polynom z= new Polynom();
        z.getP1().add(new Monom(1.00,3));
        z.getP1().add(new Monom(2.00,2));
        z.getP1().add(new Monom(3.00,1));

        Operations addition=new Operations();
        addition.getResult().getP1().clear();
        addition.addition(z,y);

        String aux=addition.getResult().polyToString();
        Assertions.assertEquals("2.0x^3+6.0x^2+3.0x^1+5.0",aux);

        y.getP1().clear();
        z.getP1().clear();
        y.getP1().add(new Monom(1.00,5));
        y.getP1().add(new Monom(3.00,3));
        y.getP1().add(new Monom(7.00,2));
        y.getP1().add(new Monom(1.00,0));
        z.getP1().add(new Monom(3.00,5));
        z.getP1().add(new Monom(4.00,4));
        z.getP1().add(new Monom(5.00,3));
        z.getP1().add(new Monom(1.00,2));
        z.getP1().add(new Monom(8.00,1));
        addition.getResult().getP1().clear();
        addition.addition(z,y);
        aux=addition.getResult().polyToString();
        Assertions.assertEquals("4.0x^5+4.0x^4+8.0x^3+8.0x^2+8.0x^1+1.0",aux);

        y.getP1().clear();
        z.getP1().clear();
        y.getP1().add(new Monom(1.00,6));
        y.getP1().add(new Monom(3.00,5));
        y.getP1().add(new Monom(5.00,4));
        y.getP1().add(new Monom(5.00,3));
        y.getP1().add(new Monom(2.00,2));
        y.getP1().add(new Monom(5.00,1));
        y.getP1().add(new Monom(1.00,0));

        z.getP1().add(new Monom(3.00,6));
        z.getP1().add(new Monom(4.00,5));
        z.getP1().add(new Monom(5.00,4));
        z.getP1().add(new Monom(1.00,3));
        z.getP1().add(new Monom(8.00,2));
        z.getP1().add(new Monom(3.00,1));
        z.getP1().add(new Monom(6.00,0));
        addition.getResult().getP1().clear();
        addition.addition(z,y);
        aux=addition.getResult().polyToString();
        Assertions.assertEquals("4.0x^6+7.0x^5+10.0x^4+6.0x^3+10.0x^2+8.0x^1+7.0",aux);
    }

    @org.junit.jupiter.api.Test
    void testSubtraction() {
        Polynom y= new Polynom();
        y.getP1().add(new Monom(1.00,3));
        y.getP1().add(new Monom(4.00,2));
        y.getP1().add(new Monom(5.00,0));

        Polynom z= new Polynom();
        z.getP1().add(new Monom(1.00,3));
        z.getP1().add(new Monom(2.00,2));
        z.getP1().add(new Monom(3.00,1));

        Operations addition=new Operations();
        addition.getResult().getP1().clear();
        addition.subtraction(y,z);

        String aux=addition.getResult().polyToString();
        Assertions.assertEquals("2.0x^2+-3.0x^1+5.0",aux);

        y.getP1().clear();
        z.getP1().clear();
        y.getP1().add(new Monom(1.00,5));
        y.getP1().add(new Monom(3.00,3));
        y.getP1().add(new Monom(7.00,2));
        y.getP1().add(new Monom(1.00,0));

        z.getP1().add(new Monom(3.00,5));
        z.getP1().add(new Monom(4.00,4));
        z.getP1().add(new Monom(5.00,3));
        z.getP1().add(new Monom(1.00,2));
        z.getP1().add(new Monom(8.00,1));
        addition.getResult().getP1().clear();
        addition.subtraction(y,z);
        aux=addition.getResult().polyToString();
        Assertions.assertEquals("-2.0x^5+-4.0x^4+-2.0x^3+6.0x^2+-8.0x^1+1.0",aux);

        y.getP1().clear();
        z.getP1().clear();
        y.getP1().add(new Monom(1.00,6));
        y.getP1().add(new Monom(3.00,5));
        y.getP1().add(new Monom(5.00,4));
        y.getP1().add(new Monom(5.00,3));
        y.getP1().add(new Monom(2.00,2));
        y.getP1().add(new Monom(5.00,1));
        y.getP1().add(new Monom(1.00,0));

        z.getP1().add(new Monom(3.00,6));
        z.getP1().add(new Monom(4.00,5));
        z.getP1().add(new Monom(5.00,4));
        z.getP1().add(new Monom(1.00,3));
        z.getP1().add(new Monom(8.00,2));
        z.getP1().add(new Monom(3.00,1));
        z.getP1().add(new Monom(6.00,0));
        addition.getResult().getP1().clear();
        addition.subtraction(y,z);
        aux=addition.getResult().polyToString();
        Assertions.assertEquals("-2.0x^6+-1.0x^5+4.0x^3+-6.0x^2+2.0x^1+-5.0",aux);
    }

    @org.junit.jupiter.api.Test
    void testMultiplication() {
        Polynom y= new Polynom();
        y.getP1().add(new Monom(1.00,3));
        y.getP1().add(new Monom(4.00,2));
        y.getP1().add(new Monom(5.00,0));

        Polynom z= new Polynom();
        z.getP1().add(new Monom(1.00,3));
        z.getP1().add(new Monom(2.00,2));
        z.getP1().add(new Monom(3.00,1));

        Operations addition=new Operations();
        addition.getResult().getP1().clear();
        addition.multiplication(y,z);

        String aux=addition.getResult().polyToString();
        Assertions.assertEquals("x^6+6.0x^5+11.0x^4+17.0x^3+10.0x^2+15.0x^1",aux);

        y.getP1().clear();
        z.getP1().clear();
        y.getP1().add(new Monom(1.00,5));
        y.getP1().add(new Monom(3.00,3));
        y.getP1().add(new Monom(1.00,0));

        z.getP1().add(new Monom(3.00,5));
        z.getP1().add(new Monom(4.00,4));
        z.getP1().add(new Monom(8.00,0));
        addition.getResult().getP1().clear();
        addition.multiplication(y,z);
        aux=addition.getResult().polyToString();
        Assertions.assertEquals("3.0x^10+4.0x^9+9.0x^8+12.0x^7+11.0x^5+4.0x^4+24.0x^3+8.0",aux);

        y.getP1().clear();
        z.getP1().clear();
        y.getP1().add(new Monom(2.00,2));
        y.getP1().add(new Monom(5.00,1));
        y.getP1().add(new Monom(1.00,0));

        z.getP1().add(new Monom(8.00,2));
        z.getP1().add(new Monom(3.00,1));
        z.getP1().add(new Monom(6.00,0));
        addition.getResult().getP1().clear();
        addition.multiplication(y,z);
        aux=addition.getResult().polyToString();
        Assertions.assertEquals("16.0x^4+46.0x^3+35.0x^2+33.0x^1+6.0",aux);
    }

    @org.junit.jupiter.api.Test
    void testDivision() {
        Polynom y= new Polynom();
        y.getP1().add(new Monom(1.00,3));
        y.getP1().add(new Monom(4.00,2));
        y.getP1().add(new Monom(5.00,0));

        Polynom z= new Polynom();
        z.getP1().add(new Monom(1.00,3));
        z.getP1().add(new Monom(2.00,2));
        z.getP1().add(new Monom(3.00,1));

        Operations addition=new Operations();
        addition.getResult().getP1().clear();
        addition.division(y,z);

        String aux=addition.getResult().polyToString();
        Assertions.assertEquals("1.0",aux);

        aux=addition.getReminder().polyToString();
        Assertions.assertEquals("2.0x^2+-3.0x^1+5.0",aux);


        y.getP1().clear();
        z.getP1().clear();
        y.getP1().add(new Monom(1.00,5));
        y.getP1().add(new Monom(1.00,3));
        y.getP1().add(new Monom(1.00,0));

        z.getP1().add(new Monom(1.00,3));
        z.getP1().add(new Monom(1.00,2));
        z.getP1().add(new Monom(1.00,0));
        addition.getResult().getP1().clear();
        addition.division(y,z);
        aux=addition.getResult().polyToString();
        Assertions.assertEquals("x^2+-1.0x^1+2.0",aux);

        aux=addition.getReminder().polyToString();
        Assertions.assertEquals("-3.0x^2+x^1+-1.0",aux);

        y.getP1().clear();
        z.getP1().clear();
        y.getP1().add(new Monom(1.00,2));
        y.getP1().add(new Monom(5.00,1));
        y.getP1().add(new Monom(1.00,0));

        z.getP1().add(new Monom(1.00,2));
        z.getP1().add(new Monom(3.00,1));
        z.getP1().add(new Monom(6.00,0));
        addition.getResult().getP1().clear();
        addition.division(y,z);
        aux=addition.getResult().polyToString();
        Assertions.assertEquals("1.0",aux);

        aux=addition.getReminder().polyToString();
        Assertions.assertEquals("2.0x^1+-5.0",aux);
    }

    @org.junit.jupiter.api.Test
    void testDerivation() {
        Polynom y= new Polynom();
        y.getP1().add(new Monom(1.00,3));
        y.getP1().add(new Monom(4.00,2));
        y.getP1().add(new Monom(5.00,1));

        Operations addition=new Operations();
        addition.getResult().getP1().clear();
        addition.derivation(y);

        String aux=addition.getResult().polyToString();
        Assertions.assertEquals("3.0x^2+8.0x^1+5.0",aux);

        y.getP1().clear();
        y.getP1().add(new Monom(1.00,5));
        y.getP1().add(new Monom(3.00,3));
        y.getP1().add(new Monom(1.00,0));

        addition.getResult().getP1().clear();
        addition.derivation(y);
        aux=addition.getResult().polyToString();
        Assertions.assertEquals("5.0x^4+9.0x^2",aux);

        y.getP1().clear();
        y.getP1().add(new Monom(2.00,2));
        y.getP1().add(new Monom(5.00,1));
        y.getP1().add(new Monom(1.00,0));

        addition.getResult().getP1().clear();
        addition.derivation(y);
        aux=addition.getResult().polyToString();
        Assertions.assertEquals("4.0x^1+5.0",aux);
    }

    @org.junit.jupiter.api.Test
    void testIntegration() {
        Polynom y= new Polynom();
        y.getP1().add(new Monom(1.00,3));
        y.getP1().add(new Monom(4.00,2));
        y.getP1().add(new Monom(5.00,1));

        Operations addition=new Operations();
        addition.getResult().getP1().clear();
        addition.integration(y);

        String aux=addition.getResult().polyToString();
        Assertions.assertEquals("0.25x^4+1.33x^3+2.5x^2",aux);

        y.getP1().clear();
        y.getP1().add(new Monom(1.00,5));
        y.getP1().add(new Monom(3.00,3));
        y.getP1().add(new Monom(1.00,0));

        addition.getResult().getP1().clear();
        addition.integration(y);
        aux=addition.getResult().polyToString();
        Assertions.assertEquals("0.17x^6+0.75x^4+x^1",aux);

        y.getP1().clear();
        y.getP1().add(new Monom(2.00,2));
        y.getP1().add(new Monom(5.00,1));
        y.getP1().add(new Monom(1.00,0));

        addition.getResult().getP1().clear();
        addition.integration(y);
        aux=addition.getResult().polyToString();
        Assertions.assertEquals("0.67x^3+2.5x^2+x^1",aux);
    }
}
