import de.kuschku.cytubebot2.utils.OptionalUtils;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class OptionalUtilTest {
    private Optional<Boolean> a = Optional.empty();
    private Optional<Boolean> b = Optional.of(true);
    private Optional<Boolean> c = Optional.of(false);

    @Test
    public void test1() {
        assertEquals(OptionalUtils.findFirstPresent(a, b, c), b);
    }

    @Test
    public void test2() {
        assertEquals(OptionalUtils.findFirstPresent(c, b, a), c);
    }

    @Test
    public void test3() {
        assertEquals(OptionalUtils.findFirstPresent(a, a, a), Optional.empty());
    }
}
