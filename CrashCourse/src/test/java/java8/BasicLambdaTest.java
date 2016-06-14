package java8;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Created by mkose on 13/06/2016.
 */
public class BasicLambdaTest {

    int i = 0;

    @Test
    public void  runnableExample() {
        Assert.assertEquals(i, 0);
        Runnable r = () -> i++;
        r.run();
        Assert.assertEquals(i, 1);
    }

    @Test
    public void  comparatorExample() {
        Comparator<String> c = (a,b) -> a.compareTo(b);
        List<String> names = Lists.newArrayList("alpha", "gamma", "beta", "zeta");
        Collections.sort(names, c);
        Assert.assertEquals("beta", names.get(1));
    }

    /**
     * Represents a predicate (boolean-valued function) of one argument
     */
    @Test
    public void predicateExample() {
        Predicate<String> p = (a) -> !(a.isEmpty());

        Assert.assertEquals(p.test(""), false);
        Assert.assertEquals(p.test("something"), true);
    }

    /**
     * Consumer: An action to be performed with the object passed as argument
     */
    @Test
    public void consumerExample() {
        Consumer<Starship> powerUp = (a) -> a.shields++;
        Consumer<Starship> takeHit = (a) -> a.shields--;

        Starship starship = new Starship();

        powerUp.accept(starship);
        powerUp.accept(starship);
        takeHit.accept(starship);

        Assert.assertEquals(1, starship.shields);
    }

    /**
     * Function: Transform a T to a U
     */
    @Test
    public void transformFunctionExample() {
        Function<Starship, Salvage> destroy = (a) -> new Salvage(a);
        Starship starship = new Starship("Intrepid");
        Salvage wreck = destroy.apply(starship);

        Assert.assertEquals(wreck.creator.name, starship.name);
    }

    /**
     * Supplier : Provide an instance of T (such as a factory)
     */
    @Test
    public void supplierExample() {
        Supplier<Starship> federation = () -> new Starship("USS Enterprise");
        Supplier<Starship> klingon = () -> new Starship("K'Tinza");

        Starship ship = federation.get();

        Assert.assertTrue(ship.name.contains("USS"));

        ship = klingon.get();

        Assert.assertTrue(ship.name.contains("K'"));

    }

    /**
     * UnaryOperator: A unary operator from T -> T
     */
    @Test
    public void unaryOperatorExample() {
        UnaryOperator<Starship> powerUp = (a) -> {
            a.shields++;
            return a;
        };

        Starship ship = new Starship("Excelsior");

        Starship poweredUp = powerUp.apply(ship);

        Assert.assertEquals(poweredUp.shields, 1);
    }
}
